
package handlers;

import Beans.Routebean;
import Beans.Busbean;
import Beans.Userbean;
import dbcon.DBConnections;
import java.sql.*;
import java.util.*;

public class Adminhandler {
      Connection conn ;
    
    public Adminhandler ()
    {
         DBConnections dbconn = new DBConnections();
         conn = dbconn.getConn() ;
    }
    public Vector getAllroutes() throws SQLException
    {
       Vector dataSet = new Vector();
       String sql = "select  * from ROUTES";
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
            Routebean ub = new Routebean();
            ub.setId(rSet.getInt("ID"));
            ub.setDest(rSet.getString("DESTINATION"));  
            ub.setStart(rSet.getString("STARTING"));
            ub.setBusid(rSet.getInt("BUSID"));
            
            
         
            dataSet.addElement(ub);
       }
      
       rSet.close();
       
       st.close();
       
       return dataSet;
    }

     public int deleteRoutesById(int userId) throws SQLException
    {
        String sql = "delete ROUTES where ID="+userId ;
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        conn.commit();
        st.close();
        return done;
    }
    
     public int updateRoutes(Routebean selectedUB) throws SQLException
    {
        String sql = "update ROUTES"
                + " set DESTINATION='"+selectedUB.getDest()+"' ,"
                + " STARTING='"+selectedUB.getStart()+"' ,"
                + " BUSID="+selectedUB.getBusid()
                + " where ID="+ selectedUB.getId() ;
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        conn.commit();
        st.close();
        return done;
    }
    public int addRoutes(Routebean selectedUB) throws SQLException
    {
        String sql = "insert into ROUTES (DESTINATION, STARTING ,BUSID)" +
                       " values ('"+selectedUB.getDest()+"' ,'"+selectedUB.getStart()+"',"+selectedUB.getBusid()+")";
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        conn.commit();
        st.close();
        return done;
    }
   
    ///////////////////////////////////////////////User handeler/////////////////////////////
     public Vector getAllUsers() throws SQLException
    {
       Vector dataSet = new Vector();
       String sql = "select * from USERS order by NAME";
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
            Userbean ub = new Userbean();
            ub.setId(rSet.getInt("id"));
            ub.setName(rSet.getString("name"));
            ub.setPassword(rSet.getString("password"));
         
            dataSet.addElement(ub);
       }
       rSet.close();
       st.close();
       
       return dataSet;
    }

     
    
    public int deleteUserById(int userId) throws SQLException
    {
        String sql = "delete USERS where ID="+ userId ;
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        conn.commit();
        st.close();
        return done;
    }

     public int updateUser(Userbean selectedUB) throws SQLException
    {
        String sql = "update USERS "
                + " set NAME='"+selectedUB.getName()+"' ,"
                + " PASSWORD='"+selectedUB.getPassword()+"' "
                + " where ID="+ selectedUB.getId() ;
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        conn.commit();
        st.close();
        return done;
    }
    public int addUser(String name, String password) throws SQLException
    {
        String sql = "insert into USERS (NAME , PASSWORD)"
                + " values ('"+name+"' ,'"+password+"')";
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        conn.commit();
        st.close();
        return done;
    }
    public int checkUserName(String name) throws SQLException 
    { 
        int validID = -1;
        String sql = "select ID from USERS"
                + " where Name='"+name+"'";
                ;
        try (Statement st  = conn.createStatement()) {
            ResultSet rSet = st.executeQuery(sql);
            while(rSet.next())
            {
                validID = rSet.getInt("id");
            }
            rSet.close();
        }
       
       return validID;
    }
   
    //////////////////////////////// log in////////////////////////
     
  public int checkUser(String user, String password) throws SQLException 
    { 
        int validID = -1;
        String sql = "select id from USERS"
                + " where NAME='"+user+"' "
                + "and PASSWORD='"+password+"'"
                ;
        try (Statement st = conn.createStatement()) {
            ResultSet rSet = st.executeQuery(sql);
            while(rSet.next())
            {
                validID = rSet.getInt("id");
            }
            rSet.close();
        }
       
       return validID;
    }
  
  ///////////////////////////////////////////////Bus handeler/////////////////////////////
   public int checkBusId(int id) throws SQLException 
    { 
        int validID = -1;
        String sql = "select ID from BUSS"
                + " where ID="+id;
                ;
        try (Statement st  = conn.createStatement()) {
            ResultSet rSet = st.executeQuery(sql);
            while(rSet.next())
            {
                validID = rSet.getInt("id");
            }
            rSet.close();
        }
       
       return validID;
    }
  
  public Vector getAllBuss() throws SQLException
    {
       Vector dataSet = new Vector();
       String sql = "select * from BUSS";
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
            Busbean ub = new Busbean();
            ub.setId(rSet.getInt("ID"));
            ub.setName(rSet.getString("NAME"));
            ub.setTimeleave(rSet.getString("TIMELEAVE"));  
            ub.setNumberseat(rSet.getString("NUMBERSEAT"));
            ub.setType(rSet.getString("TYPE"));
            ub.setPrice(rSet.getString("PRICE"));
             ub.setTimearrive(rSet.getString("TIMEARRIVE"));
            
         
            dataSet.addElement(ub);
       }
       rSet.close();
       st.close();
       
       return dataSet;
    }
  

  public int updateBus(Busbean selectedUB) throws SQLException
    {
          String sint=selectedUB.getNumberseat();
          int numberseat=Integer.parseInt(sint);
          String sr=  selectedUB.getPrice();
          int price=Integer.parseInt(sr);
           
        String sql = "update BUSS"
                + " set NAME='"+selectedUB.getName()+"' ,"
                + " TIMEARRIVE='"+selectedUB.getTimearrive()+"' ,"
                + " TIMELEAVE='"+selectedUB.getTimeleave()+"' ,"
                + " Type='"+selectedUB.getType()+"' ,"
                + " PRICE="+price+" ,"
                + " NUMBERSEAT="+numberseat+" where ID="+selectedUB.getId() ;
                
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        conn.commit();
        st.close();
        return done;
    }
   public int deleteBusById(int id) throws SQLException
    {
        String sql = "delete BUSS where ID="+id ;
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        
        conn.commit();
        st.close();
        return done;
    }
     
   public int addBus(Busbean bs) throws SQLException
    {
        String name=bs.getName();
        String tl=bs.getTimearrive();
        String ta=bs.getTimeleave();
        String tp=bs.getType();
        String nos=bs.getNumberseat();
        String pc=bs.getPrice();
        int price=Integer.parseInt(pc);
        int numberseat=Integer.parseInt(nos);
 
        String sql = "insert into BUSS (NAME ,TIMELEAVE,TIMEARRIVE,TYPE,NUMBERSEAT,PRICE)"
                + " values ('"+name+"' ,'"+tl+"','"+ta+"','"+tp+"',"+numberseat+","+price+")";
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        System.out.println(""+done);
        conn.commit();
        st.close();
        return done;
    }
   
  
  public void closeConnection() throws SQLException
    {
        conn.close();
    }
}