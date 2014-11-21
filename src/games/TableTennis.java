package games;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.AccData;
import spree.EventManager;

public class TableTennis extends Games {

	static int max_participant=10;
	static int min_participant=2;
	//@ count keeps track of number of teams registered
	static int count=0;
	static EventManager em=new EventManager();
	
	public static EventManager getEM() {
		return em;
	}
	
	
	public static void setEM() throws SQLException{
		Connection conn = DriverManager.getConnection(AccData.getHost(),AccData.getUser(), AccData.getPass());
		Statement s = conn.createStatement();
		String query = "Select * from Event where Name=TableTennis";
		ResultSet rs = s.executeQuery(query);
		em.setName((String)rs.getString("EventManager"));
		
	}
	
	public Object getInfo() throws SQLException{
		Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		Statement s = conn.createStatement();
		String query = "Select * from Event where Name=TableTennis";
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
