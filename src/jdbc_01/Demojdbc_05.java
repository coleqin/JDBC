package jdbc_01;

import java.sql.*;

public class Demojdbc_05 {
    public static void main(String[] args) {
        Statement stat = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///DB2", "root", "qiang2714");
            String sql = "select *from account ";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
           while(rs.next()) {
               int anInt = rs.getInt(1);
               String string = rs.getString("name");
               double aDouble = rs.getDouble(3);
               System.out.println(anInt + "-----" + string + "-----" + aDouble);
           }
//            if(rs.next()) {
//                int anInt2 = rs.getInt(1);
//                String string2 = rs.getString("name");
//                double aDouble2 = rs.getDouble(3);
//                System.out.println(anInt2 + "-----" + string2 + "-----" + aDouble2);
//            }
//
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
            if (rs != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
