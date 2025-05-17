/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.footballstadiumticketsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import org.apache.derby.impl.tools.dblook.DB_Index;

/**
 *
 * @author ASUS
 */
public class DBconnect {
    
   
    
    
 static Connection conn = null;
  static  String driverName = "org.apache.derby.jdbc.ClientDriver";   //The mysql driver 
  static String DBURL = "jdbc:derby://localhost:1527/football3"; //Local mysql Server URL
  static  String DBUser = "root";                        //Database server username
  static  String DBPwd = "root";                             //Database server password
  static  boolean vcon = false;
    public static Connection ConnectDB(){       
        try {
            
         
           Class.forName(driverName);         
           
           
            //Connection conn
            conn = DriverManager.getConnection(DBURL,DBUser,DBPwd);
            vcon = true;
           // return conn;   
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            vcon = false;
            return null;
           
        }
        return conn;
    }
} 




