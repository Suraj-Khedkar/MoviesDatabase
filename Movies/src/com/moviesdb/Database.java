package com.moviesdb;
import java.sql.Connection;  
import java.sql.DatabaseMetaData;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Database {
	public void createNewDatabase(String fileName) {  
	        
	        String url = "jdbc:sqlite:D:\\Sqlite\\sqlite-tools-win32-x86-3370200\\" + fileName;  
	   
	        try {  
	            Connection conn = DriverManager.getConnection(url);  
	            if (conn != null) {  
	                DatabaseMetaData meta = conn.getMetaData();  
	                System.out.println("The driver name is " + meta.getDriverName());  
	                System.out.println("A new database "+ fileName +" has been created.");  
	            }  
	   
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }
	    public void createNewTable(String fileName, String tableName) {  
	        // SQLite connection string  
	        String url = "jdbc:sqlite:D:\\Sqlite\\sqlite-tools-win32-x86-3370200\\"+fileName;  
	        
	        // SQL statement for creating a new table  
	        String sql =  "CREATE TABLE IF NOT EXISTS "+ tableName +" (\n"
	        		+ "id integer PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
	        		+ " name text NOT NULL,\n"
	                + " actor text,\n"  
	                + " actress text,\n"  
	                + " year_of_release int NOT NULL,\n"
	                + " director text NOT NULL\n"
	                + ");"; 
	        
	        try{  
	            Connection conn = DriverManager.getConnection(url);  
	            Statement stmt = conn.createStatement();  
	            stmt.execute(sql);
	//            PreparedStatement ptmt = conn.prepareStatement(sql);
	//            ptmt.setString(1, tableName);
	//            ptmt.execute();
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }
	    private Connection connect(String fileName) {  
	        // SQLite connection string  
	        String url = "jdbc:sqlite:D:\\Sqlite\\sqlite-tools-win32-x86-3370200\\"+ fileName;  
	        Connection conn = null;  
	        try {  
	            conn = DriverManager.getConnection(url);  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	        return conn;  
	    }  
	
	
	    public void insert(String name, String actor, String actress, int year_of_release,String director ) {  
	        String sql = "INSERT INTO movies (name,actor,actress,year_of_release,director) VALUES(?,?,?,?,?)";  
	
	        try{  
	            Connection conn = this.connect("MoviesDB.db");  
	            PreparedStatement pstmt = conn.prepareStatement(sql);  
	            pstmt.setString(1, name);  
	            pstmt.setString(2, actor);
	            pstmt.setString(3, actress);
	            pstmt.setInt(4, year_of_release);
	            pstmt.setString(5, director);
	            pstmt.executeUpdate();  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());
	        }  
	    }
}
