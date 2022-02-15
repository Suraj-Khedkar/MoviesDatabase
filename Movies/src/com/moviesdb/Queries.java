package com.moviesdb;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Queries {
	private Connection database;
	Queries(String fileName){
		String url = "jdbc:sqlite:D:\\Sqlite\\sqlite-tools-win32-x86-3370200\\"+ fileName;  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        database=conn;
	}
	public void selectAll(String tableName){  
        String sql = "SELECT * FROM "+ tableName;  
        
        try {  
            Connection conn = database; 
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);
            System.out.println("SELECT ALL ROWS");
            
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getInt("id") + "\t" +
                				rs.getString("name") +  "\t" +   
                                rs.getString("actor") + "\t" +  
                                rs.getString("actress")+ "\t"+
                                rs.getInt("year_of_release")+ "\t"+
                                rs.getString("director"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
    public void year(String tableName,int year_of_release) {
    	String sql = "SELECT * FROM "+tableName+" WHERE year_of_release = "+year_of_release;
    	try{
    		Connection conn = database;
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
    		System.out.println("SELECT ROWS WITH year of release: "+ year_of_release);
            while (rs.next()) {  
                System.out.println(rs.getInt("id") + "\t" +
                				rs.getString("name") +  "\t" +   
                                rs.getString("actor") + "\t" +  
                                rs.getString("actress")+ "\t"+
                                rs.getInt("year_of_release")+ "\t"+
                                rs.getString("director"));  
            }  
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
        }
    }
    public void name(String tableName,String name) {
    	String sql = "SELECT * FROM "+tableName+" WHERE name = '"+name+"'";
    	try{
    		Connection conn = database;
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
    		System.out.println("SELECT ROWS containing movie: "+name);
            while (rs.next()) {  
                System.out.println(rs.getInt("id") + "\t" +
                				rs.getString("name") +  "\t" +   
                                rs.getString("actor") + "\t" +  
                                rs.getString("actress")+ "\t"+
                                rs.getInt("year_of_release")+ "\t"+
                                rs.getString("director"));  
            }  
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
        }
    }
    public void actor(String tableName,String actor) {
    	String sql = "SELECT * FROM "+tableName+" WHERE actor = '"+actor+"'";
    	try{
    		Connection conn = database;
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
    		System.out.println("SELECT ROWS WITH actor: "+actor);
            while (rs.next()) {  
                System.out.println(rs.getInt("id") + "\t" +
                				rs.getString("name") +  "\t" +   
                                rs.getString("actor") + "\t" +  
                                rs.getString("actress")+ "\t"+
                                rs.getInt("year_of_release")+ "\t"+
                                rs.getString("director"));  
            }  
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
        }
    }
    public void actress(String tableName,String actress) {
    	String sql = "SELECT * FROM "+tableName+" WHERE actress = '"+actress+"'";
    	try{
    		Connection conn = database;
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
    		System.out.println("SELECT ROWS WITH actress: "+actress);
            while (rs.next()) {  
                System.out.println(rs.getInt("id") + "\t" +
                				rs.getString("name") +  "\t" +   
                                rs.getString("actor") + "\t" +  
                                rs.getString("actress")+ "\t"+
                                rs.getInt("year_of_release")+ "\t"+
                                rs.getString("director"));  
            }  
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
        }
    }
    public void director(String tableName,String director) {
    	String sql = "SELECT * FROM "+tableName+" WHERE director = '"+director+"'";
    	try{
    		Connection conn = database;
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
    		System.out.println("SELECT ROWS WITH director: "+director);
            while (rs.next()) {  
                System.out.println(rs.getInt("id") + "\t" +
                				rs.getString("name") +  "\t" +   
                                rs.getString("actor") + "\t" +  
                                rs.getString("actress")+ "\t"+
                                rs.getInt("year_of_release")+ "\t"+
                                rs.getString("director"));  
            }  
        } catch (SQLException e) {
            System.out.println(e.getMessage());  
        }
    }
    public void sqlStatement(String sql) {
    	try {
    		Connection conn = database;
    		Statement smtmt = conn.createStatement();
    		ResultSet rs = smtmt.executeQuery(sql);
    		
    		
    		 // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getInt("id") + "\t" +
                				rs.getString("name") +  "\t" +   
                                rs.getString("actor") + "\t" +  
                                rs.getString("actress")+ "\t"+
                                rs.getInt("year_of_release")+ "\t"+
                                rs.getString("director"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        
    	}
    }
}
