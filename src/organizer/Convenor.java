package organizer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import departments.*;

import common.AccData;


public class Convenor implements OrganizingCommitte {

	private String Name=null;
	private String emailID=null;
	private String ID = null;
	
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
	
	
	/**** TO GET NAME OF CONVENOR FROM DATABASE****/
	public String getName() {
		return Name;
	}
	
	public String getEmailID() {
			return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
public static void main(String[] args) {
	
	
      
      
}	
	
}