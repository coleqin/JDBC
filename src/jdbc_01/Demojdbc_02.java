package jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//account表 添加一条记录
public class Demojdbc_02 {
    public static void main(String[] args) {
        Statement st = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "insert into account values(null,'王武',3000)";

            conn = DriverManager.getConnection("jdbc:mysql:///DB2", "root", "qiang2714");
            st = conn.createStatement();
            int i = st.executeUpdate(sql);
            System.out.println(i);
            if (i > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
