package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con= DriverManager.getConnection("jdbc:mysql://walab.handong.edu:3306/p1_22001020","p1_22001020","yahwie0Mei");
	    }catch(Exception e){
	    	System.out.println(e);
	    }  
	    return con;  
	}  
	



}