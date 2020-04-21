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
    private static final String Filename = "ABSOLUTE PATH TO DB PROPERTIES FILE";
    private static Connection con;
    private static boolean finished = false;
    //For ResultSet boolean value
    private static boolean MoreData= false;
    //Indicator of actual progress in SQL
    private static boolean inProgress= false;
    private static int StartingColumns = 1;
    private static int NewCurrentColumns;
    private static ResultSet rs;
    private static PreparedStatement ps;

    static{


            try {
                prop = new Properties();
                FileInputStream input = new FileInputStream(Filename);
                prop.load(input);
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                UN = prop.getProperty("Username" );
                PSW = prop.getProperty("Password");
                URL = prop.getProperty("URL", "jdbc:sqlserver://localhost:1433;databaseName=CanteenDB");
                Port = prop.getProperty("Port","1433");
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
                ResultSetMetaData rsmd = rs.getMetaData();
                NewCurrentColumns = rsmd.getColumnCount();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public static String ShowData()throws SQLException{
            StringBuilder sb = new StringBuilder();
            //Get number of columns
            try{

                while(MoreData){
                    sb.append(rs.getString(StartingColumns));
                    if(StartingColumns>=NewCurrentColumns){
                        StartingColumns = 1;
                        sb.append("\n");
                        MoreData = rs.next();
                    }
                    else{
                        StartingColumns++;
                        sb.append("\n");
                    }
                }
            }catch (Exception x){
                x.printStackTrace();
            }finally {
                MoreData = false;
                rs.close();
                ps.close();
                Disconnect();
            }
            return sb.toString();

        }
        public static void Queries(String SQL) throws SQLException{
            if(ps!=null){
                ps.close();
            }
            try{
                ConnectDB();
                ps = con.prepareStatement(SQL);
                int rows = ps.executeUpdate();
                System.out.println("Rows affected: "+ rows);

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                Disconnect();
            }
        }

        public static void InsertSQL(String SQL) throws SQLException { Queries(SQL);}
    }


