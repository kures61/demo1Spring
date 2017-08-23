/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odev.DB;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * @author Lokman
 */
public class odevDB {
    
	public static Connection getMySqlConneciton() {

            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url2 = "jdbc:mysql://localhost:3306/worddb";
                conn = DriverManager.getConnection(url2,"root","");
            } catch (ClassNotFoundException ex) {
                System.out.println("Connection error - 1 - ClassNotFoundException");
            } catch (Exception ex) {
                System.out.println("Connection error - 2 - Exception");
            }
            return conn;
	}
	    
    
}
