package jdbc_01;

import Domain.Emp;
import util.JDBCUtil;
/*** 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 1. 定义Emp类
 2. 定义方法 public List<Emp> findAll(){}
 3. 实现方法 select * from emp;
 */

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demojdbc_07 {
    public static void main(String[] args) {
        List<Emp> list = new Demojdbc_06().findAll();
        System.out.println(list);
    }

    public List<Emp> findAll() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql:///DB2", "root", "qiang2714");
            conn = JDBCUtil.getConnection();
            String sql = "select *from emp";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ename = rs.getString("NAME");
                String gender = rs.getString("gender");
                double salary = rs.getDouble("salary");
                Date join_date = rs.getDate("join_date");
                int dept_id = rs.getInt("dept_id");
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setGender(gender);
                emp.setSalary(salary);
                emp.setJoindate(join_date);
                emp.setDept_id(dept_id);
                list.add(emp);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
       JDBCUtil.close(rs,stat,conn);
        }
        return list;
    }
}
