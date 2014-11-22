package organizer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import departments.*;

import common.AccData;

/**Class for Convenor of Spree
 * 
 * @author spree_group1
 * @version 1.0
 *
 */
public class Convenor implements OrganizingCommitte {

	private String Name=null;
	private String emailID=null;
	private String ID = null;
	
	/**
	 * constructor of convenor class, fetches details of the convenor from organozerdata database
	 * @param Id 
	 */
	public Convenor(String Id){
		Statement stmt=null;
		try{
			Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			stmt=conn.createStatement();
			String query = "Select * from organizerdata";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				if(rs.getString("ID").equals(Id)){
				this.Name = rs.getString("Name");
				this.emailID = rs.getString("EmailID");
				this.ID = Id;
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
	
	
	/**
	 * Get method for convenor name
	 * @return Name of convenor
	 */
	public String getName() {
		return Name;
	}
	/**
	 * Get method for email ID of convenor
	 * @return
	 */
	public String getEmailID() {
			return emailID;
	}

	/**
 * set method to set the email id of the convenor
 * @param emailID email id of the convenor
 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
public static void main(String[] args) {
	
	
      
      
}	
	
}