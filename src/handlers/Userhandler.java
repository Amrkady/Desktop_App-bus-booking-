

package handlers;

import Beans.*;
import dbcon.DBConnections;
import java.sql.*;
import java.util.Vector;

public class Userhandler {
        Connection conn ;
    
    public Userhandler ()
    {
         DBConnections dbconn = new DBConnections();
         conn = dbconn.getConn() ;
    }
    
    
      public Vector getAllTransactionbyID(int id) throws SQLException
    {
        Vector dataSet = new Vector();
       String sql = "select * from TRANSACTION where ID="+id;
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
           
           Transbean tb = new Transbean();
            tb.setId(rSet.getInt("ID"));
            tb.setBusid(rSet.getInt("BUSID"));
            tb.setFromcity(rSet.getString("FROMCITY"));
            tb.setTocity(rSet.getString("TOCITY"));  
            tb.setTakingoff(rSet.getString("TAKING_OFF"));
            tb.setQuantity(rSet.getInt("QUANTITY"));
            tb.setPrice(rSet.getInt("PRICE"));
            tb.setTotal(rSet.getInt("TOTAL"));
            tb.setTransdate(rSet.getString("TRANSDATE"));
         
            dataSet.addElement(tb);
       }
       rSet.close();
       st.close();
       
       return dataSet;
    }
    public String getAllnuberseats(int busid) throws SQLException
    {
       String dataSet ="";
       String sql = "select NUMBERSEAT FROM BUSS WHERE ID="+busid;
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
             
           dataSet=rSet.getString("NUMBERSEAT"); 
            
       }
       st.close();
       
       return dataSet;
    }
//     public int updateTicket(int tickid, int tranid) throws SQLException
//    {
//        String sql = "update TICKETS"
//                + " set TRANSACTIONID="+tranid+ " where DATES="+tickid  ;
//        
//        Statement st = conn.createStatement();
//        int done = st.executeUpdate(sql);
//        conn.commit();
//        st.close();
//        return done;
//    }
    public Vector getAllTicketnum( String date ,int busid) throws SQLException
    {
       Vector dataSet = new Vector();
       String sql = "select TICKETCODE FROM TICKETS WHERE DATES='"+date+"'and  BUSID="+busid;
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
              dataSet.addElement( rSet.getInt("TICKETCODE"));
       }
       rSet.close();
       st.close();
       
       return dataSet;
    }
    public Vector getAllTransactionsPerDate(String stt) throws SQLException
    {
       Vector dataSet = new Vector();
       String sql = "select   TRANSDATE , BUSID , TAKING_OFF , PRICE , SUM(QUANTITY) QUANTITY "
                  + ",  SUM(TOTAL)  TOTAL  from TRANSACTION\n" +
                    "  group by   TRANSDATE,  BUSID,PRICE ,TAKING_OFF"
                     + " having TRANSDATE='"+stt+"'";
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
           Transbean tb = new Transbean();
            tb.setTransdate(rSet.getString("TRANSDATE"));
            tb.setBusid(rSet.getInt("BUSID"));
            tb.setTakingoff(rSet.getString("TAKING_OFF"));
            tb.setPrice(rSet.getInt("PRICE"));
            tb.setQuantity(rSet.getInt("QUANTITY"));
            tb.setTotal(rSet.getInt("TOTAL"));
            
         
            dataSet.addElement(tb);
       }
       rSet.close();
       st.close();
       
       return dataSet;
    }
      public int addTicket(Ticketbean tb) throws SQLException
    {
        String sql = "insert into TICKETS (DATES, TICKETCODE , BUSID)"
                + " values ('"+tb.getDate()+"' ,'"+tb.getTicketcode()+"',"+tb.getBusid()+")";
        
        Statement st = conn.createStatement();
                  st.executeUpdate(sql);
                  conn.commit();  
                   
        int id = -1;
        String sql2="select max(ID) ID from TICKETS";
        ResultSet rSet=st.executeQuery(sql2);
         while(rSet.next())
       {
           id=rSet.getInt("ID");
       }
       
        st.close();
        return id;
    }
    public int addTransaction(Transbean tb) throws SQLException
    {
        String sql = "insert into TRANSACTION (TAKING_OFF,FROMCITY ,TOCITY,TRANSDATE,BUSID,PRICE,QUANTITY,TOTAL)" +
                       " values ('"+tb.getTakingoff()+"' ,'"+tb.getFromcity()+"','"
                       +tb.getTocity()+"','"+tb.getTransdate()+"',"+tb.getBusid()+","
                       +tb.getPrice()+","+tb.getQuantity()+","+tb.getTotal()+")";
                                     
        
        Statement st = conn.createStatement();
                   st.executeUpdate(sql); 
                   conn.commit();  
                   
        int id = -1;
        String sql2="select max(ID) ID from TRANSACTION";
        ResultSet rSet=st.executeQuery(sql2);
         while(rSet.next())
       {
           id=rSet.getInt("ID");
       }
       
        st.close();
        return id;
    }
    
    public int updateTransaction(Transbean selectedUB) throws SQLException
    {
        String sql = "update TRANSACTION "
                + " set FROMCITY='"+selectedUB.getFromcity()+"' ,"
                + " TOCITY='"+selectedUB.getTocity()+"', "
                + " TAKING_OFF='"+selectedUB.getTakingoff()+"', "
                + " QUANTITY="+selectedUB.getQuantity()+" ,"
                + " PRICE="+selectedUB.getPrice()+" ,"
                + " TOTAL="+selectedUB.getTotal()+" ,"
                + " TRANSDATE='"+selectedUB.getTransdate()+"', "
                + " BUSID="+selectedUB.getBusid()
                + "  where ID="+ selectedUB.getId() ;
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        conn.commit();
        st.close();
        return done;
    }
   
    public Vector getAllTransactions() throws SQLException
    {
       Vector dataSet = new Vector();
       String sql = "select * from TRANSACTION";
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
           Transbean tb = new Transbean();
            tb.setId(rSet.getInt("ID"));
            tb.setBusid(rSet.getInt("BUSID"));
            tb.setFromcity(rSet.getString("FROMCITY"));
            tb.setTocity(rSet.getString("TOCITY"));  
            tb.setTakingoff(rSet.getString("TAKING_OFF"));
            tb.setQuantity(rSet.getInt("QUANTITY"));
            tb.setPrice(rSet.getInt("PRICE"));
            tb.setTotal(rSet.getInt("TOTAL"));
            tb.setTransdate(rSet.getString("TRANSDATE"));
         
            dataSet.addElement(tb);
       }
       rSet.close();
       st.close();
       
       return dataSet;
    }
    
    public Vector getAllBussTakingOffAndPrice(int busid) throws SQLException
    {
       Vector dataSet = new Vector();
       String sql = "select TIMELEAVE ,PRICE FROM BUSS WHERE  ID="+busid;
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
              Busbean ub = new Busbean();
             ub.setTimeleave(rSet.getString("TIMELEAVE")); 
             ub.setPrice(rSet.getString("PRICE"));
              dataSet.addElement(ub);
       }
       rSet.close();
       st.close();
       
       return dataSet;
    }
    public Vector getAllBuss(String start ,String dest) throws SQLException
    {
       Vector dataSet = new Vector();
       String sql = "select BUSID FROM ROUTES WHERE  STARTING='"+start+"' and DESTINATION='"+dest+"'";
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
            dataSet.addElement(rSet.getString("BUSID"));
       }
       rSet.close();
       st.close();
       
       return dataSet;
    }
    
    public Vector getAllDest(String start) throws SQLException
    {
       Vector dataSet = new Vector();
       String sql = "select DESTINATION FROM ROUTES WHERE  STARTING='"+start+"'";
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
            dataSet.addElement(rSet.getString("DESTINATION"));
       }
       rSet.close();
       st.close();
       
       return dataSet;
    }
    public int deleteTransactionById(int transId) throws SQLException
    {
        String sql = "delete TRANSACTION where ID="+ transId ;
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        conn.commit();
        st.close();
        return done;
    }
 public int deleteticketByTransId(int transId) throws SQLException
    {
        String sql = "delete TICKETS where ID="+ transId ;
        
        Statement st = conn.createStatement();
        int done = st.executeUpdate(sql);
        conn.commit();
        st.close();
        return done;
    }

    
   public Vector getAllStarting() throws SQLException
    {
       Vector dataSet = new Vector();
       String sql = "select distinct STARTING FROM ROUTES";
       Statement st = conn.createStatement();
       ResultSet rSet = st.executeQuery(sql);
       while(rSet.next())
       {
            dataSet.addElement(rSet.getString("STARTING"));
       }
       rSet.close();
       st.close();
       
       return dataSet;
    }
   
    public void closeConnection() throws SQLException
    {
        conn.close();
    }
}
