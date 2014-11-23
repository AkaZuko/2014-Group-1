package eventManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import common.AccData;

/**
* <h1>SubmitScheduleFrame</h1>
* This class provide sets the values for the Event Manager depending on the loginID
* 
* @author  Group_1 spree
* @version 1.0
*/

public class EventManager {
	
		private AccData account;
 	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 	   private String Name;
 	   private String Game;
 	   private String EmailID;
 	   private String ID;
 	  /**
 	   * This is the constructor for the the class EventManager
 	   * @param String ID of the the Eventmanager
 	   *  @exception IOException
 	   */
	public EventManager(String ID) {
		Connection conn = null;
		Statement stmt = null;
		

		try{
		      
		      Class.forName("com.mysql.jdbc.Driver");

		      conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
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
