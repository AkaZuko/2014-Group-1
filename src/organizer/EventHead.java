package organizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.AccData;

public class EventHead implements  OrganizingCommitte {
	
	private String Name=null;
	private String emailID=null;
	private String ID = null;
	
	public EventHead(String ID){
		Statement stmt=null;
		try{
			Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			stmt=conn.createStatement();
			String query = "Select * from organizerdata;";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				if(rs.getString("ID").equals(ID)){
				this.Name = rs.getString("Name");
				this.emailID = rs.getString("EmailID");
				this.ID = ID;
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
	}
	


	///***** MAIN STARTS HERE*****///

	public static void main(String[] args) {
		String ID="EH_1";
		EventHead E=new EventHead(ID);
	}

	public String getID() {
		return ID;
	}

	public String getEmailID() {
		return emailID;
	}


	public String getName() {
		return Name;
	}
	
	
	
	public void pushItem(String itemName ,int quantity){
		Statement s=null;
		try{
		Connection conn=DriverManager.getConnection(AccData.getHost(), "root", "12345");
		s=conn.createStatement();
		String query = "Select * from Inventory;";
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			if(rs.getString("Name").equals(itemName)){
			query= "Select NoOfItems from invenotry WHERE Name=\"" + itemName+ "\";";
			rs=s.executeQuery(query);
			int i=rs.getInt("NoOfItems");
			i=i+quantity;
			query = "UPDATE Inventory set NoOfItems = "+Integer.toString(i)+" where Name=\"" + itemName + "\";";
			s.executeUpdate(query);
			}
		}
		rs.close();
		s.close();
		conn.close();
	
		}catch(SQLException e){
			System.out.println(e.toString());
		}
	}	

}
