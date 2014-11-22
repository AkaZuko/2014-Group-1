package games;
/**
 * Provides functionality for this game.
 * @author Spree_group1
 * @version 1.0
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.AccData;
import eventManager.EventManager;


public class Football extends Games {

	static int max_participant=20;
	static int min_participant=2;
	//@ count keeps track of number of teams registered
	static int count=0;
	static EventManager em;
	
	/**
	 * Method to get Event Manager
	 * @return EventManager
	 */
	public static EventManager getEM() {
		return em;
	}
	
	/**
	 * Sets Event Manager details for Football
	 * @throws SQLException
	 */
	public static void setEM() throws SQLException{
		/*Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		Statement s = conn.createStatement();
		String query = "Select * from Event where Name=Football";
		ResultSet rs = s.executeQuery(query);
		em.setName((String)rs.getString("EventManager"));
		String q="Select ID from emdata where Game='"+em.getGame()+"';";
		ResultSet r=s.executeQuery(q);
		String i=r.getString("ID");
		em = new EventManager(i);*/
		em = new EventManager("EM_FB");
	}
	
	/**
	 * Gets details of Football Game
	 * 
	 * @throws SQLException
	 * @return Object
	 */
	public Object getInfo() throws SQLException{
		Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		Statement s = conn.createStatement();
		String query = "Select * from Event where Name=Football";
		ResultSet rs = s.executeQuery(query);
		Object[][] data = new Object[10][5];

		int i=0;
		if(!rs.wasNull()){
			
		
		while(rs.next()){
			data[i][0] = (String)rs.getString("Name");
			data[i][1] = (String)rs.getString("EventManager");
			data[i][2] = (String)rs.getString("Venue");
			data[i][3] = (String)rs.getString("TimeSlot");
			data[i][4] = (String)rs.getString("TimeDuration");
			data[i][5] = (String)rs.getString("Result");
			
			
			++i;
			
		}
		
		return data;
		}
		else
			return null ;
		
		
	}
	
	

}
