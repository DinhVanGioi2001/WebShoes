/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hung Dinh
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

    private final String serverName = "DESKTOP-F90LHD8";
//    private final String serverName = "0.tcp.ap.ngrok.io,10049";
    private final String dbName = "Wish";
    private final String portNumber = "1433";
    private final String instance = "";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "sa";
    private final String password = "1";

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName + ";encrypt=false";
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName + ";encrypt=false";
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

//    private static DBConnect instance;
//
//    private Connection conn = null;
//    private Statement stmt = null;
//    
//    public DBConnect() throws ClassNotFoundException, SQLException {
//        getConnection();
//        stmt = conn.createStatement();
//    }
//    public void getConnection() throws ClassNotFoundException {
//        try {
//            String[] IPS = {"DESKTOP-F90LHD8", "localhost:1433"};
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String IP = IPS[1];
//            String dbURL = "jdbc:sqlserver://" + IP + ";databaseName=Wish;encrypt=false";
//            String usrname = "sa";
//            String pw = "1";
//            conn = DriverManager.getConnection(dbURL, usrname, pw);
//
//            if (conn != null) {
//                System.out.println("Connected");
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Driver version: " + dm.getDriverVersion());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
//                System.out.println("Product version: " + dm.getDatabaseProductVersion());
//            }
//        } catch (SQLException ex) {
//            System.err.println("Cannot connect database, " + ex);
//        }
//    }
//    
//    public static DBConnect getSingletonInstance() throws ClassNotFoundException, SQLException{
//        if(instance == null){
//            instance = new DBConnect();
//        }
//        return instance;
//    }
//
//    public Connection getConn() {
//        return conn;
//    }
    public static void main(String[] args) {
        try {
//            DBConnect dBContext = new DBConnect();
            System.out.println(new DBConnect().getConnection());
//            dBContext.getConnection();
//            System.out.println(dBContext.getConn());
        } catch (Exception e) {
        }
    }
}
