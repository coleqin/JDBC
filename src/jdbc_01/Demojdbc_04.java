package jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demojdbc_04 {
    public static void main(String[] args) {
        Statement stat = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///DB2", "root", "qiang2714");
            String sql = "delete from account where id=3";
            stat = conn.createStatement();
            int i = stat.executeUpdate(sql);
            System.out.println(i);
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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

