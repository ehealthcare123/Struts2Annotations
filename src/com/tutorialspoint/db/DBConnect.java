package com.tutorialspoint.db;
import java.io.File;
import java.sql.*;

public class DBConnect {
	 private Connection c;
	 
	 public DBConnect(){
		 c = null;
	 }
	 public boolean connectTOsqlite(){
		 try {
			 Class.forName("org.sqlite.JDBC");
			 String dbpath = "jdbc:sqlite:" + System.getProperty("user.home") + File.separator + "access.db";
			 c = DriverManager.getConnection(dbpath);
		 } catch ( Exception e ) {
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			 return false;
		 }
		 return true;
	 }
	 
	 public boolean createTable(){
		      String sql = "CREATE TABLE BENUTZER " +
		                   "(LOGIN CHAR(15) PRIMARY KEY  NOT NULL," +
		                   " NAME           TEXT     NOT NULL, " + 
		                   " PASSWORT       TEXT     NOT NULL)"; 
		    return this.executeStatement(sql);
	 }
	 
	 public boolean insertData(String Login, String Name, String Passwort){
	     String sql = "INSERT INTO BENUTZER(LOGIN,NAME,PASSWORT)"+
                      "VALUES ("+
	    		      "'"+Login+"',"+
	    		      "'"+Name+"',"+
	    		      "'"+Passwort+"')";
		 return this.executeStatement(sql);
	 }
	 
	 public boolean executeStatement(String sql){
		    Statement stmt = null;
		    try {
		      stmt = c.createStatement();
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      return false;
		    }
		    return true;
	 }
}
