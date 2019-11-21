package jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demojdbc_03 {
    public static void main(String[] args) {
        Statement stat = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///DB2", "root", "qiang2714");
            String sql = "update account set balance=1500 where id=3";
            stat = conn.createStatement();
            int count = stat.executeUpdate(sql);
            System.out.println(count);
            if (count > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                try {
                    stat.close();
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

