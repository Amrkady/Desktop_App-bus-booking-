/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms;

import handlers.*;
import Beans.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alkady
 */
public class Adminform extends javax.swing.JFrame {
       
        int  pcount=0,nCount=0,crout=0,check=0,flag=0,fcount=0,tcount=0,bcount=0
                ,tlcount=0,tacount=0,tycount=0;
        
        boolean show=false;//// when update or delete  on user table will be true to the date move down
        boolean bool=false;////when update or delete  on bus table will be true to the date move down
         boolean sh=false;//// when update or delete  on Routes table will be true to the date move down
        String txt="";
    /**
     * Creates new form Adminform
     */
    public Adminform() throws SQLException {
        initComponents();
         add.setVisible(false);
         route.setVisible(false);
         view.setVisible(false);
         select.setText("");
          transtable.setShowGrid(true);
          routetable.setShowGrid(true);
          bustable.setShowGrid(true);
          usertable.setShowGrid(true);
          transperdate.setVisible(false);
          transtable.setShowGrid(true);
         // busData();
          //getUsers();
          //routeData();
         // getAllTransaction();
          yearMonthDay();
       
    }
     public void yearMonthDay()
    {
    for(int i=1;i<13;i++)
    {
        if(i<10)
        {
      
      transmonth.addItem("0"+i);
               }
        else
        {
       
       transmonth.addItem(i);
        }
    }
    for(int i=2000;i<2020;i++)
    {
        
    
     transyear.addItem(i);
    }
    for(int i=1;i<32;i++)
    {
         if(i<10)
         {
      
      transday.addItem("0"+i);
         }
        else
         {
       transday.addItem(i);
       
         }
    }
    
    }
    
    
     private void getAllTransaction()
    {
        Userhandler uh = new Userhandler();
        Vector usrList=new Vector();
        try {
            usrList = uh.getAllTransactions();
        } catch (SQLException ex) { 
            System.out.println("get all transaction error "+ex.getMessage());
        }
        try {
            uh.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Usersform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel dtm =(DefaultTableModel) transtable.getModel();
        dtm.setRowCount(0);
        for(int v=0; v< usrList.size() ; v++)
        {
          Transbean ub = (Transbean)usrList.elementAt(v);
          
          Vector newRow = new Vector();
          newRow.addElement(ub.getId());
          newRow.addElement(ub.getTransdate());
          newRow.addElement(ub.getFromcity());
          newRow.addElement(ub.getTocity());
          newRow.addElement(ub.getTakingoff());
          newRow.addElement(ub.getBusid());
          newRow.addElement(ub.getPrice());
          newRow.addElement(ub.getQuantity());
          newRow.addElement(ub.getTotal());
          dtm.addRow(newRow);
        }
        transtable.setModel(dtm);
        transtable.updateUI();
        jScrollPane3.setViewportView(transtable);
  
    }
          /////////////////////////////////////////user table //////////////////////
     private void getUsers() throws SQLException
    {
        Adminhandler dh = new Adminhandler();
        Vector usrList = dh.getAllUsers();
        dh.closeConnection();
        
        DefaultTableModel dtm =(DefaultTableModel) usertable.getModel();
        dtm.setRowCount(0);
        for(int v=0; v< usrList.size() ; v++)
        {
          Userbean ub = (Userbean)usrList.elementAt(v);
          
          Vector newRow = new Vector();
          newRow.addElement(ub.getId());
          newRow.addElement(ub.getName());
          newRow.addElement(ub.getPassword());
          dtm.addRow(newRow);
        }
        usertable.setModel(dtm);
        usertable.updateUI();
        jScrollPane1.setViewportView(usertable);
    } 
     
     /////////////////////////////////////////route table //////////////////////
     
    private void routeData() 
    {
        Adminhandler dh = new Adminhandler();
        Vector usrList=new Vector();
            try {
                usrList = dh.getAllroutes();
            } catch (SQLException ex) {
                System.out.println("get route exc "+ex.getMessage());
            }
            try {
                dh.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Adminform.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       DefaultTableModel dtm =(DefaultTableModel) routetable.getModel();
         dtm.setRowCount(0);
        for(int v=0; v< usrList.size() ; v++)
        {
          Routebean ub = (Routebean)usrList.elementAt(v);
          
          Vector newRow = new Vector();
          newRow.addElement(ub.getId());
          newRow.addElement(ub.getDest());
          newRow.addElement(ub.getStart());
          newRow.addElement(ub.getBusid());
          dtm.addRow(newRow);
        }
        routetable.setModel(dtm);
        routetable.updateUI();
        jScrollPane2.setViewportView(routetable);
    }
    
    /////////////////////////////////////////bus table //////////////////////
    
    private void busData() 
    {
        Adminhandler dh = new Adminhandler();
        Vector usrList=new Vector();
            try {
                usrList = dh.getAllBuss();
            } catch (SQLException ex) {
                System.out.println("get user exc "+ex.getMessage());
            }
            try {
                dh.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Adminform.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       DefaultTableModel dtm =(DefaultTableModel) bustable.getModel();
         dtm.setRowCount(0);
        for(int v=0; v< usrList.size() ; v++)
        {
          Busbean ub = (Busbean)usrList.elementAt(v);
          
          Vector newRow = new Vector();
          newRow.addElement(ub.getId());
          newRow.addElement(ub.getName());
          newRow.addElement(ub.getTimeleave());
          newRow.addElement(ub.getTimearrive());
          newRow.addElement(ub.getNumberseat());
          newRow.addElement(ub.getType());
          newRow.addElement(ub.getPrice());
          dtm.addRow(newRow);
        }
        bustable.setModel(dtm);
        bustable.updateUI();
        mytable.setViewportView(bustable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usertable = new javax.swing.JTable();
        adduser = new javax.swing.JButton();
        deleteuser = new javax.swing.JButton();
        updeteuser = new javax.swing.JButton();
        view = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        userpassword = new javax.swing.JTextField();
        saveuser_ = new javax.swing.JButton();
        reset_ = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        data = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        usermsg = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        transtable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        transyear = new javax.swing.JComboBox();
        transmonth = new javax.swing.JComboBox();
        transday = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        transok = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        transperdate = new javax.swing.JTable();
        logout3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        mytable = new javax.swing.JScrollPane();
        bustable = new javax.swing.JTable();
        addbus = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        add = new javax.swing.JPanel();
        vvv = new javax.swing.JLabel();
        busname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        numberseat = new javax.swing.JTextField();
        dd = new javax.swing.JLabel();
        timeleave = new javax.swing.JTextField();
        timearrive = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        typeee = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        gg = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        savebus_ = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        msg = new javax.swing.JLabel();
        selectbus = new javax.swing.JLabel();
        cancelbus = new javax.swing.JButton();
        logout2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        routetable = new javax.swing.JTable();
        addroute = new javax.swing.JButton();
        updateroute = new javax.swing.JButton();
        deleteroute = new javax.swing.JButton();
        route = new javax.swing.JPanel();
        tyuiolm = new javax.swing.JLabel();
        busid = new javax.swing.JTextField();
        saveroute = new javax.swing.JButton();
        resetroute = new javax.swing.JButton();
        cancelroute = new javax.swing.JButton();
        routemsg = new javax.swing.JLabel();
        from = new javax.swing.JTextField();
        to = new javax.swing.JTextField();
        thjkk = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        select = new javax.swing.JLabel();
        logout1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 255));

        jPanel4.setBackground(new java.awt.Color(51, 255, 204));

        usertable.setAutoCreateRowSorter(true);
        usertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PASSWORD"
            }
        ));
        usertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usertableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(usertable);

        adduser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        adduser.setText("Add User");
        adduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduserActionPerformed(evt);
            }
        });

        deleteuser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteuser.setText("Delete User");
        deleteuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteuserActionPerformed(evt);
            }
        });

        updeteuser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updeteuser.setText("Update User");
        updeteuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updeteuserActionPerformed(evt);
            }
        });

        view.setBackground(new java.awt.Color(102, 255, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 255));
        jLabel4.setText(" Password");

        saveuser_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveuser_.setText("Save");
        saveuser_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveuser_ActionPerformed(evt);
            }
        });

        reset_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset_.setText("Reset");
        reset_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_ActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        data.setForeground(new java.awt.Color(255, 0, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("User Name");

        usermsg.setBackground(new java.awt.Color(204, 204, 204));
        usermsg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout viewLayout = new javax.swing.GroupLayout(view);
        view.setLayout(viewLayout);
        viewLayout.setHorizontalGroup(
            viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLayout.createSequentialGroup()
                .addGroup(viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(usermsg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(viewLayout.createSequentialGroup()
                                .addComponent(reset_, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(saveuser_, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(viewLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(69, 69, 69)
                                    .addComponent(userpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(viewLayout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(58, 58, 58)
                        .addComponent(cancel)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        viewLayout.setVerticalGroup(
            viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(usermsg, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(reset_)
                    .addComponent(saveuser_))
                .addGap(74, 74, 74)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        logout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 102, 102));
        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logout))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updeteuser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteuser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adduser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 81, Short.MAX_VALUE))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logout)
                        .addGap(34, 34, 34)
                        .addComponent(adduser)
                        .addGap(40, 40, 40)
                        .addComponent(updeteuser)
                        .addGap(39, 39, 39)
                        .addComponent(deleteuser))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Users", jPanel4);

        jPanel3.setBackground(new java.awt.Color(51, 255, 204));

        transtable.setAutoCreateRowSorter(true);
        transtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "From", "To", "Taking Off", "Bus ID", "Price ", "Quantity", "Total"
            }
        ));
        transtable.setRowSorter(null);
        jScrollPane3.setViewportView(transtable);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 0, 255));
        jLabel12.setText("All Transaction ");

        transyear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        transyear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YYYY", "2002" }));

        transmonth.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        transmonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MM" }));

        transday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        transday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DD" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Transactions Per date");

        transok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        transok.setText("OK");
        transok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transokActionPerformed(evt);
            }
        });

        transperdate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date ", "Bus ID", "Taking Off", "Price", "Qauntity", "Total"
            }
        ));
        jScrollPane4.setViewportView(transperdate);

        logout3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logout3.setForeground(new java.awt.Color(255, 51, 51));
        logout3.setText("Log Out");
        logout3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout3))
            .addComponent(jScrollPane4)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(transday, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transok)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(transmonth, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(transyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209)))
                .addGap(0, 252, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel12))
                    .addComponent(logout3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(transok, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bookings", jPanel3);

        jPanel5.setBackground(new java.awt.Color(102, 255, 204));

        bustable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "TIMELEAVE", "TIMEARRIVE", "NUMBERSEATS", "TYPE", "PRICE"
            }
        ));
        bustable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bustableMouseClicked(evt);
            }
        });
        mytable.setViewportView(bustable);

        addbus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addbus.setText("Add Bus");
        addbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbusActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(102, 255, 204));

        vvv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vvv.setForeground(new java.awt.Color(51, 51, 255));
        vvv.setText("Bus Name");

        busname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busnameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Numberseats");

        numberseat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberseatActionPerformed(evt);
            }
        });

        dd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dd.setForeground(new java.awt.Color(51, 51, 255));
        dd.setText("TimeLeave");

        timeleave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeleaveActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("TimeArrive");

        typeee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        typeee.setForeground(new java.awt.Color(51, 51, 255));
        typeee.setText("Type");

        gg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gg.setForeground(new java.awt.Color(0, 0, 255));
        gg.setText("Price");

        savebus_.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        savebus_.setText("Save");
        savebus_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebus_ActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        msg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 0, 0));

        selectbus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cancelbus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelbus.setText("Cancel");
        cancelbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addLayout = new javax.swing.GroupLayout(add);
        add.setLayout(addLayout);
        addLayout.setHorizontalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(selectbus, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                            .addGap(400, 400, 400)
                            .addComponent(numberseat, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(addLayout.createSequentialGroup()
                            .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(vvv, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dd)
                                .addComponent(typeee, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addLayout.createSequentialGroup()
                                    .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(busname, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(timeleave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(type, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(reset, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(79, 79, 79)
                                    .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(addLayout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(117, 117, 117))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                                            .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(gg)
                                                .addComponent(savebus_))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(price)
                                                .addComponent(timearrive, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cancelbus)))))
                                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addLayout.setVerticalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLayout.createSequentialGroup()
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addLayout.createSequentialGroup()
                        .addComponent(selectbus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberseat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(busname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vvv))
                .addGap(56, 56, 56)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeleave, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timearrive, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(51, 51, 51)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeee, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelbus)
                    .addComponent(reset)
                    .addComponent(savebus_))
                .addGap(22, 22, 22))
        );

        logout2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logout2.setForeground(new java.awt.Color(255, 51, 51));
        logout2.setText("Log Out");
        logout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mytable, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(logout2)
                        .addComponent(addbus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(logout2)
                        .addGap(18, 18, 18)
                        .addComponent(addbus)
                        .addGap(43, 43, 43)
                        .addComponent(update)
                        .addGap(43, 43, 43)
                        .addComponent(delete))
                    .addComponent(mytable, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("Buss", jPanel5);

        jPanel6.setBackground(new java.awt.Color(51, 255, 204));

        routetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "STARTING ", "DETINATION", "BUDID"
            }
        ));
        routetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                routetableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(routetable);

        addroute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addroute.setText("Add Route");
        addroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addrouteActionPerformed(evt);
            }
        });

        updateroute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateroute.setText("Update Route");
        updateroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updaterouteActionPerformed(evt);
            }
        });

        deleteroute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteroute.setText("Delete Route");
        deleteroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleterouteActionPerformed(evt);
            }
        });

        route.setBackground(new java.awt.Color(102, 255, 204));

        tyuiolm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tyuiolm.setForeground(new java.awt.Color(51, 51, 255));
        tyuiolm.setText("Bus Id");

        saveroute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveroute.setText("Save");
        saveroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saverouteActionPerformed(evt);
            }
        });

        resetroute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resetroute.setText("Reset");
        resetroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetrouteActionPerformed(evt);
            }
        });

        cancelroute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelroute.setText("Cancel");
        cancelroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelrouteActionPerformed(evt);
            }
        });

        routemsg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        routemsg.setForeground(new java.awt.Color(255, 0, 0));

        from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromActionPerformed(evt);
            }
        });

        to.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toActionPerformed(evt);
            }
        });

        thjkk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        thjkk.setForeground(new java.awt.Color(51, 51, 255));
        thjkk.setText("To");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("From");

        select.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        select.setText("Select Routes");

        javax.swing.GroupLayout routeLayout = new javax.swing.GroupLayout(route);
        route.setLayout(routeLayout);
        routeLayout.setHorizontalGroup(
            routeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(routeLayout.createSequentialGroup()
                .addGroup(routeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(routeLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addGroup(routeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routemsg, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(routeLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(routeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(routeLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(resetroute)
                                .addGap(50, 50, 50)
                                .addComponent(saveroute)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelroute, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(routeLayout.createSequentialGroup()
                                .addGroup(routeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tyuiolm)
                                    .addComponent(jLabel5))
                                .addGap(29, 29, 29)
                                .addGroup(routeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(from)
                                    .addComponent(busid, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(94, 94, 94)
                                .addComponent(thjkk)
                                .addGap(32, 32, 32)
                                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        routeLayout.setVerticalGroup(
            routeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(routeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(routeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thjkk)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(routeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tyuiolm))
                .addGap(40, 40, 40)
                .addGroup(routeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetroute)
                    .addComponent(saveroute)
                    .addComponent(cancelroute))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(routemsg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        logout1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        logout1.setForeground(new java.awt.Color(255, 51, 51));
        logout1.setText("Log Out");
        logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(route, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(updateroute)
                        .addComponent(addroute, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteroute, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logout1))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(logout1)
                        .addGap(53, 53, 53)
                        .addComponent(addroute)
                        .addGap(35, 35, 35)
                        .addComponent(updateroute)
                        .addGap(41, 41, 41)
                        .addComponent(deleteroute))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(route, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("routes", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busnameActionPerformed

    private void addbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbusActionPerformed
        // TODO add your handling code here:
        bool=false;
        
        flag=1;
        add.setVisible(true);
        selectbus.setText(" Add Bus  ");
        resetActionPerformed(evt);
       
    }//GEN-LAST:event_addbusActionPerformed

      public boolean ckeckAllIDIsDigit(String str)
    {
       boolean validID=false;
       for(int i=0;i<str.length();i++)
         {
                if(Character.isDigit(str.charAt(i)))
                  validID=true;
                else 
                {
                    validID=false;
                    break;
                }
         }
       return validID ;
    }
    private void savebus_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebus_ActionPerformed
        
        String name=busname.getText().trim();
        String tl=timeleave.getText().trim();
        String ta=timearrive.getText().trim();
        String tp=type.getText().trim();
        String nos=numberseat.getText().trim();
        String  pc=price.getText().trim();
        
        if(name.length()>0 && tl.length()>0 && ta.length()>0 && tp.length()>0 && pc.length()>0 && nos.length()>0 
                && ckeckAllIDIsDigit(nos)&&ckeckAllIDIsDigit(pc) )
        {
              Adminhandler dh=new Adminhandler();
               Busbean bs=new Busbean();
                    
                       bs.setName(name);
                       bs.setNumberseat(nos);
                       bs.setPrice(pc);
                       bs.setTimearrive(ta);
                       bs.setTimeleave(tl);
                       bs.setType(tp);  
        
         /////////////////////////////////////////////////////////////////////
               /** add bus **/
              if(flag==1)
                {
                    
                 try {
                       int val=dh.addBus(bs);
                       if( val > -1){
                           busData();
                            JOptionPane.showMessageDialog(null, " ADD ");
                          resetActionPerformed(evt);
                       }
                        else{ 
                          resetActionPerformed(evt);
                           msg.setText("don't add bus ");
                           }
                    } 
                 catch (SQLException ex) 
                     {
                         System.out.println("insert error  "+ex.getMessage());
                     }
               } // end if flage
     //////////////////////////////////// ubdate bus///////////////////////////////////////
              else if(flag==2)
               {
                    try {
                         bs.setId(getBusId());
                        
                         int x= dh.updateBus(bs);
                          if( x > -1){
                           busData();
                            JOptionPane.showMessageDialog(null, " Updated ");
                          resetActionPerformed(evt);
                       }
                        else{ 
                          resetActionPerformed(evt);
                           msg.setText("don't update bus ");
                           };
                        } 
                    catch (SQLException ex)
                      {
                          System.out.println("ubdate error  "+ex.getMessage()); 
                       }
              }/// end else 2 flage 
              
        //////////////////////////////////// delete bus /////////////////////////      
              else if(flag==3)
              {
                  try {
                        
                      /////delete
                         
                      int del=dh.deleteBusById(getBusId());
                      
                     if( del > -1){
                           busData();
                           JOptionPane.showMessageDialog(null, "Deleted");
                          resetActionPerformed(evt);
                       }
                        else{ 
                          resetActionPerformed(evt);
                           msg.setText("don't delete bus ");
                           }
                  } catch (SQLException ex) {
                     System.out.println("delete error  "+ex.getMessage()); 
                  }
              }
              
                    } //  end if conditions to check data entered
        else /// else  to if conditions to check data entered
                 {
                      JOptionPane.showMessageDialog(null," Please Enter All Information and Correct numbers ");
                       resetActionPerformed(evt);
      
        }
    }//GEN-LAST:event_savebus_ActionPerformed

    
    
    private int bustabl(){

      Busbean sb =  getSelectedBus();
      int id=sb.getId();
        System.out.println("busssss  "+id);
            if(sb != null)
            {
               
               busname.setText(sb.getName());
               timeleave.setText(sb.getTimeleave());
               timearrive.setText(sb.getTimearrive());
               type.setText(sb.getType());
               price.setText(sb.getPrice());
               numberseat.setText(sb.getNumberseat());
            
        }
            else
                selectbus.setText("Select valid Buszzzzzzz !!");

return id;
}
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        bool=true;
        flag=2;
        add.setVisible(true);
        selectbus.setText("Select Bus");
        resetActionPerformed(evt);
        
    }//GEN-LAST:event_updateActionPerformed
  
    private Busbean getSelectedBus()
    {
        Busbean ub = new Busbean();
        int selectedUser = bustable.getSelectedRow();
        if(selectedUser >=0)
        {
            
            ub.setId((int)bustable.getValueAt(selectedUser, 0) );
            ub.setName( bustable.getValueAt(selectedUser,1).toString() );
            ub.setTimeleave(bustable.getValueAt(selectedUser, 2).toString());
             ub.setTimearrive(bustable.getValueAt(selectedUser,3).toString());
             ub.setNumberseat((String) bustable.getValueAt(selectedUser, 4));
              ub.setType(bustable.getValueAt(selectedUser,5).toString());
              ub.setPrice((String) bustable.getValueAt(selectedUser, 6));
       
        }
        
        else
        {
           JOptionPane.showMessageDialog(null, "Please Select Bus");
        }
        return ub;
    }
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        busname.setText("");
        type.setText("");
        price.setText(""); 
        timeleave.setText("");
        timearrive.setText("");
        numberseat.setText("");
        bustable.clearSelection();
         msg.setText("");
        
    }//GEN-LAST:event_resetActionPerformed

    private void bustableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bustableMouseClicked
        // TODO add your handling code here:
        if(bool==true){
           bustabl();
           msg.setText("");
           selectbus.setText("");
           
        }
    }//GEN-LAST:event_bustableMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        flag=3;
        add.setVisible(true);
        selectbus.setText(" Select  Bus ");
        bool=true;
        resetActionPerformed(evt);
    }//GEN-LAST:event_deleteActionPerformed

    ///////////////////////////////////////////////////UUUUSSSSERRRR///////////////////
    /**
     * 
     * @param evt 
     */
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
         view.setVisible(false);
         reset_ActionPerformed(evt);
         data.setText("");
    }//GEN-LAST:event_cancelActionPerformed

    private void adduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduserActionPerformed
        // TODO add your handling code here:
        check=1;
        show=false;
         view.setVisible(true);
         data.setText("");
          reset_ActionPerformed(evt);
    }//GEN-LAST:event_adduserActionPerformed

    private void deleteuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteuserActionPerformed
        // TODO add your handling code here:
        view.setVisible(true);
         show=true;
        check=3;
        usermsg.setText("select User");
         reset_ActionPerformed(evt);
         data.setText("");
    }//GEN-LAST:event_deleteuserActionPerformed

    private void updeteuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updeteuserActionPerformed
        // TODO add your handling code here:
        
        view.setVisible(true);
         show=true;
         check=2;
         usermsg.setText("select User");
         
           reset_ActionPerformed(evt);
         
    }//GEN-LAST:event_updeteuserActionPerformed

    private void saveuser_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveuser_ActionPerformed
        // TODO add your handling code here:
          
           usermsg.setText("");
        String uName = username.getText().trim();
        String upass = userpassword.getText().trim();
        if(uName.length()>0 && upass.length()>0)
        {
             Adminhandler dh=new Adminhandler();
               Userbean bs=new Userbean();
                
                       bs.setName(uName);
                       bs.setPassword(upass);
//              
         /////////////////////////////////////////////////////////////////////
               /** add User **/
              if(check==1)
                {
                    
                 try { 
                        int validname= dh.checkUserName(uName);
                        if(validname<0){
                       int val=dh.addUser(uName,upass);
                       if( val > -1)
                       {
                           getUsers();
                         JOptionPane.showMessageDialog(null, " ADD ");
                          reset_ActionPerformed(evt);
                       }
                        else
                       { 
                          reset_ActionPerformed(evt);
                         //  msg.setText("don't add User ");
                        }
                        }
                        else
                        {
                        JOptionPane.showMessageDialog(null, "This Name Already Existing plz Enter Anther Name");
                        }
                 } 
                 catch (SQLException ex) 
                     {
                         System.out.println("insert error  "+ex.getMessage());
                     }
                }
            else if(check==2)
            {
            //// update//////////////
                try {
                    int validname= dh.checkUserName(uName);
                        if(validname<0){
                            bs.setId(getUserId());
                         int x= dh.updateUser(bs);
                          if( x > -1){
                           getUsers();
                           JOptionPane.showMessageDialog(null, " Updated");
                          reset_ActionPerformed(evt);
                       }
                        else{ 
                          reset_ActionPerformed(evt);
                        //   msg.setText("don't update User ");
                           };
                        
                        }
                
                        else
                        {
                        JOptionPane.showMessageDialog(null, "This Name Already Existing plz Enter Anther Name");
                        }
                }
                    catch (SQLException ex)
                      {
                          System.out.println("ubdate error  "+ex.getMessage()); 
                       }
            }
            else if (check==3)
            {
            ///// delete//////////////////
                if(getUserId()==1)
                        {
                           JOptionPane.showMessageDialog(null,"can't delete admin" );
                          
                        }
                        else
                        {
                try {
                     
                      int del=dh.deleteUserById(getUserId());
                     if( del > -1){
                           getUsers();
                           JOptionPane.showMessageDialog(null, "Deleted");
                         //  ms.setText(" User deleted ");
                          reset_ActionPerformed(evt);
                       }
                        else{ 
                          reset_ActionPerformed(evt);
                    //       msg.setText("don't delete User ");
                           }
                  } catch (SQLException ex) {
                     System.out.println("delete error  "+ex.getMessage()); 
                  }
              }
              
            }
        }
        else /// else  to if conditions to check data entered
                 {
                      JOptionPane.showMessageDialog(null," Please  Enter All Information ");
                       reset_ActionPerformed(evt);
                 }
         
    }//GEN-LAST:event_saveuser_ActionPerformed

    private void reset_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_ActionPerformed
        // TODO add your handling code here:
        username.setText("");
        userpassword.setText("");
         usertable.clearSelection();
         
         
    }//GEN-LAST:event_reset_ActionPerformed

    private void usertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usertableMouseClicked
        // TODO add your handling code here:
        if(show){
       usermsg.setText("");
        usertabl();
        data.setText("");
        }
    }//GEN-LAST:event_usertableMouseClicked

    private void toActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toActionPerformed

    private void numberseatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberseatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberseatActionPerformed

    private void cancelbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbusActionPerformed
        // TODO add your handling code here:
        add.setVisible(false);
    }//GEN-LAST:event_cancelbusActionPerformed

    private void cancelrouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelrouteActionPerformed
        // TODO add your handling code here:
         route.setVisible(false);
         resetrouteActionPerformed(evt);
    }//GEN-LAST:event_cancelrouteActionPerformed

    private void resetrouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetrouteActionPerformed
        // TODO add your handling code here:
       
        to.setText("");
        from.setText("");
        busid.setText("");
        
    }//GEN-LAST:event_resetrouteActionPerformed

    private void addrouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addrouteActionPerformed
        // TODO add your handling code here:
        crout=1;
        sh=false;
        select.setText("");
        route.setVisible(true);
        resetrouteActionPerformed(evt);
    }//GEN-LAST:event_addrouteActionPerformed

    private void updaterouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updaterouteActionPerformed
        // TODO add your handling code here:
        crout=2;
          sh=true;
         route.setVisible(true);
          select.setText("Select Routes");
        resetrouteActionPerformed(evt);
    }//GEN-LAST:event_updaterouteActionPerformed

    private void deleterouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleterouteActionPerformed
        // TODO add your handling code here:
         crout=3;
          sh=true;
         select.setText("Select Routes");
         route.setVisible(true);
        resetrouteActionPerformed(evt);
    }//GEN-LAST:event_deleterouteActionPerformed

    private int getIDRoute()
    {
     Routebean rb=getSelectedRoutes();
      
    return rb.getId();
    
    }
    private int getUserId()
    {
     Userbean bs=getSelectedUser();
        System.out.println("user  "+ bs.getId());
    return bs.getId();
    
    }
     private int getBusId()
    {
        
      Busbean x=getSelectedBus();
     System.out.println(" bus id function "+x.getId());
    return x.getId();
    
    }
    
    private void saverouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saverouteActionPerformed
        // TODO add your handling code here:
        
          
           String start = from.getText().trim();
           String end = to.getText().trim();
           String busID=busid.getText().trim();
              
           
        if(start.length()>0 && end.length()>0 &&busID.length()>0)
        {
             Adminhandler dh=new Adminhandler();
               Routebean bs=new Routebean();
                
                       bs.setStart(start);
                       bs.setDest(end);
                      int bid=Integer.parseInt(busID);
                      bs.setBusid(bid);
                       
         /////////////////////////////////////////////////////////////////////
                                  /** add Routes **/
              if(crout==1)
                {
                    
                    
                 try {
                        int validid=dh.checkBusId(bid);
                        if(validid>0)
                        {
                      int val=dh.addRoutes(bs);
                       if( val > -1)
                       {
                           routeData();
                            JOptionPane.showMessageDialog(null, " ADD ");
                         resetrouteActionPerformed(evt);
                       }
                        else
                       { 
                        resetrouteActionPerformed(evt);
                         //  msg.setText("don't add User ");
                        }
                    } 
                        else
                        
                      {
                          JOptionPane.showMessageDialog(null,"invalid Bus ID");
                      }
                 }
                 catch (SQLException ex) 
                     {
                         System.out.println("insert error  "+ex.getMessage());
                     }
                 
                }
            else if(crout==2)
            {

            //// update//////////////
                try {
                     int validid=dh.checkBusId(bid);
                        if(validid>0)
                        {
                            bs.setId(getIDRoute());
                         int x= dh.updateRoutes(bs);
                          if( x > -1){
                           routeData();
                            JOptionPane.showMessageDialog(null, "Updated ");
                         resetrouteActionPerformed(evt);
                       }
                        else{ 
                          reset_ActionPerformed(evt);
                        //   msg.setText("don't update User ");
                           };
                        
                         } 
                        else
                        
                      {
                          JOptionPane.showMessageDialog(null,"invalid Bus ID");
                      }
                 }
                    catch (SQLException ex)
                      {
                          System.out.println("ubdate error  "+ex.getMessage()); 
                       }
            }
            else if (crout==3)
            {
            ///// delete//////////////////
             
                try {
                        
                      int del=dh.deleteRoutesById(getIDRoute());
                     if( del > -1){
                          routeData();
                           JOptionPane.showMessageDialog(null, " Deleted ");
                         resetrouteActionPerformed(evt);
                       }
                        else{ 
                          resetrouteActionPerformed(evt);
                           }
                        } 
                        catch (SQLException ex) {
                     System.out.println("delete error  "+ex.getMessage()); 
                  }
                }
            
            }
        else /// else  to if conditions to check data entered
                 {
                      JOptionPane.showMessageDialog(null, "Enter all Information"); 
                      
                 }
        
        
    }//GEN-LAST:event_saverouteActionPerformed

    private void routetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_routetableMouseClicked
        // TODO add your handling code here:
         if(sh){
       select.setText("");
          routestabl();
        routemsg.setText("");
        }
       
    }//GEN-LAST:event_routetableMouseClicked

    
    private void transPerDate()
    {
       String yy=transyear.getSelectedItem().toString();
       String mm=transmonth.getSelectedItem().toString();
       String dd=transday.getSelectedItem().toString();
       String date=dd+"/"+mm+"/"+yy; 
       if(yy.charAt(0)!='Y' && mm.charAt(0)!='M'&& dd.charAt(0)!='D'){
          Vector usrList=new Vector();
        Userhandler uh=new Userhandler();
        try {
          usrList=uh.getAllTransactionsPerDate(date);
        } catch (SQLException ex) {
            System.out.println(" get per date "+ex.getMessage());
        }
        try {
            uh.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Usersform.class.getName()).log(Level.SEVERE, null, ex);
        }
         DefaultTableModel dtm =(DefaultTableModel) transperdate.getModel();
        dtm.setRowCount(0);
        if(usrList.size()>0){
        for(int v=0; v< usrList.size() ; v++)
        {
          Transbean ub = (Transbean)usrList.elementAt(v);
          
          Vector newRow = new Vector();
          newRow.addElement(ub.getTransdate());
          newRow.addElement(ub.getBusid());
          newRow.addElement(ub.getTakingoff());
          newRow.addElement(ub.getPrice());
          newRow.addElement(ub.getQuantity());
          newRow.addElement(ub.getTotal());
          dtm.addRow(newRow);
        }
        transperdate.setModel(dtm);
        transperdate.updateUI();
        jScrollPane4.setViewportView(transperdate);
           }
       
           else
            {
            JOptionPane.showMessageDialog(null," no booking in this day   ");
            }
       
       }
      else
        {
        JOptionPane.showMessageDialog(null," Please Enter completly  date  ");
        }
  
    }
    
    private void transokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transokActionPerformed
        // TODO add your handling code here:
        transperdate.setVisible(true);
        transPerDate();
    }//GEN-LAST:event_transokActionPerformed

    private void fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromActionPerformed

    private void timeleaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeleaveActionPerformed
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_timeleaveActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        LoginForm vu = new LoginForm();
            vu.setEnabled(true);
            vu.setVisible(true);
        
        this.setEnabled(false);
        this.setVisible(false);
        
    }//GEN-LAST:event_logoutActionPerformed

    private void logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout1ActionPerformed
        // TODO add your handling code here:
        LoginForm vu = new LoginForm();
            vu.setEnabled(true);
            vu.setVisible(true);
        
        this.setEnabled(false);
        this.setVisible(false);
    }//GEN-LAST:event_logout1ActionPerformed

    private void logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout2ActionPerformed
        // TODO add your handling code here:
          LoginForm vu = new LoginForm();
            vu.setEnabled(true);
            vu.setVisible(true);
        
        this.setEnabled(false);
        this.setVisible(false);
    }//GEN-LAST:event_logout2ActionPerformed

    private void logout3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout3ActionPerformed
        // TODO add your handling code here:
        LoginForm vu = new LoginForm();
            vu.setEnabled(true);
            vu.setVisible(true);
        
        this.setEnabled(false);
        this.setVisible(false);
    }//GEN-LAST:event_logout3ActionPerformed
 
    private Routebean getSelectedRoutes()
    {
        Routebean ub = new Routebean();
        int selectedroutes = routetable.getSelectedRow();
        if(selectedroutes >= 0)
        {
            ub.setId((int)routetable.getValueAt(selectedroutes, 0) );
            ub.setStart(routetable.getValueAt(selectedroutes,1).toString() );
            ub.setDest(routetable.getValueAt(selectedroutes, 2).toString());
             ub.setBusid((int)routetable.getValueAt(selectedroutes,3));
        
        }
        
        else
        {
           JOptionPane.showMessageDialog(null, "  Please Select route");
        }
        return ub;
    }
    
    
    
    private Userbean getSelectedUser()
    {
        Userbean ub = new Userbean();
        int selectedUser = usertable.getSelectedRow();
        if(selectedUser >= 0)
        {
            ub.setId( (int)usertable.getValueAt(selectedUser, 0) );
            ub.setName( usertable.getValueAt(selectedUser, 1).toString() );
            ub.setPassword( usertable.getValueAt(selectedUser, 2).toString());
        }
        else
        {
           JOptionPane.showMessageDialog(rootPane, " Select a user"); 
        }
        return ub;
   
    }
 private void routestabl(){

      Routebean sb =  getSelectedRoutes();
            if(sb != null)
            { 
             String busd=""+sb.getBusid();
               from.setText(sb.getDest());
              to.setText(sb.getStart());
              busid.setText(busd);
            }
  }
    
  private void usertabl(){

      Userbean sb =  getSelectedUser();
            if(sb != null)
            {
               username.setText(sb.getName());
              userpassword.setText(sb.getPassword());
            }
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Adminform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adminform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adminform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adminform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Adminform().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Adminform.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add;
    private javax.swing.JButton addbus;
    private javax.swing.JButton addroute;
    private javax.swing.JButton adduser;
    private javax.swing.JTextField busid;
    private javax.swing.JTextField busname;
    private javax.swing.JTable bustable;
    private javax.swing.JButton cancel;
    private javax.swing.JButton cancelbus;
    private javax.swing.JButton cancelroute;
    private javax.swing.JLabel data;
    private javax.swing.JLabel dd;
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteroute;
    private javax.swing.JButton deleteuser;
    private javax.swing.JTextField from;
    private javax.swing.JLabel gg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton logout1;
    private javax.swing.JButton logout2;
    private javax.swing.JButton logout3;
    private javax.swing.JLabel msg;
    private javax.swing.JScrollPane mytable;
    private javax.swing.JTextField numberseat;
    private javax.swing.JTextField price;
    private javax.swing.JButton reset;
    private javax.swing.JButton reset_;
    private javax.swing.JButton resetroute;
    private javax.swing.JPanel route;
    private javax.swing.JLabel routemsg;
    private javax.swing.JTable routetable;
    private javax.swing.JButton savebus_;
    private javax.swing.JButton saveroute;
    private javax.swing.JButton saveuser_;
    private javax.swing.JLabel select;
    private javax.swing.JLabel selectbus;
    private javax.swing.JLabel thjkk;
    private javax.swing.JTextField timearrive;
    private javax.swing.JTextField timeleave;
    private javax.swing.JTextField to;
    private javax.swing.JComboBox transday;
    private javax.swing.JComboBox transmonth;
    private javax.swing.JButton transok;
    private javax.swing.JTable transperdate;
    private javax.swing.JTable transtable;
    private javax.swing.JComboBox transyear;
    private javax.swing.JTextField type;
    private javax.swing.JLabel typeee;
    private javax.swing.JLabel tyuiolm;
    private javax.swing.JButton update;
    private javax.swing.JButton updateroute;
    private javax.swing.JButton updeteuser;
    private javax.swing.JLabel usermsg;
    private javax.swing.JTextField username;
    private javax.swing.JTextField userpassword;
    private javax.swing.JTable usertable;
    private javax.swing.JPanel view;
    private javax.swing.JLabel vvv;
    // End of variables declaration//GEN-END:variables
}
