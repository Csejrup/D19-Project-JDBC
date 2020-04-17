package DataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DB {
    public static void main(String args[]) {
        Properties prop = new Properties();
String username = prop.getProperty("Login", "sa");
String password = prop.getProperty("Password", "123456");
String URL = prop.getProperty("URL", "jdbc:sqlserver://localhost:1433;databaseName=CanteenDB");

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=sample", "sa", "123456");

            Statement stmt = con.createStatement();

            int rows = stmt.executeUpdate("INSERT INTO project VALUES ('a1','Venus',56987)");

            System.out.println("number of rows affected = " + rows);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//
}
