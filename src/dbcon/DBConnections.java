
package dbcon;

import java.sql.*;

import java.util.logging.*;

public class DBConnections {
    private static String JDBC_DRIVER   = "oracle.jdbc.OracleDriver";
    private static final String  DB_URL="jdbc:oracle:thin:@localhost:1521:XE";
    private static final String  DB_USER="dev";
    private static final String  DB_PASSWORD="dev";
    private  Connection conn;
    
    public DBConnections (){
    
        try
        {
          //  DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            System.out.println("register ");
           
            conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            System.out.println("connection ");
        } catch (SQLException ex) {
     
        
       System.out.println("connection failed"+ex.getMessage());
        }
    
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }



}