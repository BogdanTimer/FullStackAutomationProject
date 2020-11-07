package Utilities;

import java.sql.DriverManager;

public class manageDB extends commonOps {
    public static void initConnection(String dbUrl, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, user, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error occurred while connecting to database, see details: " + e);
        }
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error occurred while disconnecting from database, see details: " + e);
        }
    }
}
