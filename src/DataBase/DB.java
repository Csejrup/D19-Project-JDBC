package DataBase;


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import java.io.FileInputStream;

import java.sql.*;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class DB {
    private static Properties prop;
    private static String UN;
    private static String PSW;
    private static String DBname;
    private static String URL;
    private static String Port;
    private static String NOMOREDATA;
    private static final String Filmname = "C:\\Users\\plkub\\IdeaProjects\\TestDB\\src\\Database\\db.properties";
    private static Connection con;
    private static boolean finished = false;
    //For ResultSet boolean value
    private static boolean MoreData= false;
    //Indicator of actual progress in SQL
    private static boolean inProgress= false;
    private static int CurrentColumns = 1;
    private static int NewCurrentColumns;


    private static ResultSet rs;
    private static PreparedStatement ps;

    static{


        try {
            prop = new Properties();
            FileInputStream input = new FileInputStream(Filmname);
            prop.load(input);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            UN = prop.getProperty("Username");
            PSW = prop.getProperty("Password ");
            URL = prop.getProperty("URL", "jdbc:sqlserver://localhost:1433;databaseName=CanteenDB");
            Port = prop.getProperty("Port");
            DBname = prop.getProperty("Dbname");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ConnectDB() throws SQLException{
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:" + 1433 + ";databaseName=" +DBname, UN, PSW);
        }catch (SQLException sq){
            sq.getErrorCode();
        }
    } public static void Disconnect() throws SQLException{
        try {
            con.close();
        }catch (SQLException sq){
            sq.getErrorCode();
        }
    }
    public static void SelectData(String SqlQuery) throws SQLException {
        if(finished){
            System.exit(0);}
        try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            ConnectDB();
            inProgress = true;
            ps = con.prepareStatement(SqlQuery);
            rs = ps.executeQuery();
            MoreData = rs.next();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static String ShowData()throws SQLException{
        StringBuilder sb = new StringBuilder();
        //Get number of columns
        try{
            sb.append(rs.getString(CurrentColumns));
            if(CurrentColumns>=NewCurrentColumns){
                CurrentColumns =1;
            }
            else{
                CurrentColumns++;
            }
            rs.close();

        }catch (Exception x){
            x.printStackTrace();
        }finally {
            Disconnect();
        }
        return sb.toString();

    }
    public static void Queries(String SQL) throws SQLException{
        if(rs!=null){
            rs.close();
        }
        if(ps!=null){
            ps.close();
        }
        try{
            ConnectDB();
            ps = con.prepareStatement(SQL);
            int rows = ps.executeUpdate();
            ps.close();
            System.out.println("Rows affected: "+ rows);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Disconnect();
        }
    }

    public static void InsertSQL(String SQL) throws SQLException { Queries(SQL);}
}
