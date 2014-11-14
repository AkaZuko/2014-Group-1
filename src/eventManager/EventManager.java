package eventManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import common.AccData;

/*
 * @author monalika
 */

public class EventManager {
	
		private AccData account;
 	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 	   private String Name;
 	   private String Game;
 	   private String EmailID;
 	   private String ID;
	
	public EventManager(String ID) {
		Connection conn = null;
		Statement stmt = null;
		
		// In the Spree database create table having 4 columns as username, name, emailID, game 
		//use the particular order and name of the variables
		//add entries for all 5 games
		
	 
			//this is extract data from the database
		try{
		      
		      Class.forName("com.mysql.jdbc.Driver");

		      
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
		      System.out.println("Connected database successfully...");
		      
		      
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();

		      String sql = "SELECT * FROM emdata";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while(rs.next()){
		    	  
		         //Retrieve by column name
		    	  if(rs.getString("ID").equals(ID)){
		         this.setID(rs.getString("ID"));
		         this.setName(rs.getString("Name"));
		         this.setEmailID(rs.getString("EmailID"));
		         this.setGame(rs.getString("Game"));
		    	  }  
		      }
		      rs.close();
		   }catch(SQLException se){
		      
		      se.printStackTrace();
		   }catch(Exception e){
		     
		      e.printStackTrace();
		   }finally{
		      
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }

}

	public String getID() {
		return ID;
	}

	private void setID(String iD) {
		ID = iD;
	}

	public String getEmailID() {
		return EmailID;
	}

	private void setEmailID(String emailID) {
		EmailID = emailID;
	}

	public String getGame() {
		return Game;
	}

	private void setGame(String game) {
		Game = game;
	}

	public String getName() {
		return Name;
	}

	private void setName(String name) {
		Name = name;
	}
}
