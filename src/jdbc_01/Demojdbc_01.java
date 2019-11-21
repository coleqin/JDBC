package jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static java.lang.Class.forName;

public class Demojdbc_01 {
    public static void main(String[] args) throws Exception {
        //导入驱动jar包
        //这册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库链接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql:///DB2", "root", "qiang2714");
        //定义SQL语句
        String sql = "update  account set balance = 1500 where id =1";
        //获取SQL执行对象 Statement
        Statement at = conn.createStatement();
        //执行SQL
        int i = at.executeUpdate(sql); //返回值是影响的行数
        //处理结果
        System.out.println(i);
        //释放资源
        at.close();
        conn.close();

    }
}
