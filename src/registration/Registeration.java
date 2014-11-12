package registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.AccData;


public class Registeration {

	String ID;
	AccData account;
	
	public static Boolean validateData(char[] password, String ID){
		Boolean status = false;
		
		try{
		Connection conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
		Statement s = conn.createStatement();
		String query = "Select ID,Password from logindata";
		ResultSet rs = s.executeQuery(query);
		String pass  = password.toString();
		while(rs.next()){
		if(pass.equalsIgnoreCase(rs.getString("Password")) && ID.equalsIgnoreCase(rs.getString("ID"))){
			return true;
		}
		}
		
		}catch(SQLException e){
			System.out.println(e.toString());
		}
		return status;
	}
	
	public Boolean submitData(){
		return true;
	}
	
	public void updateTotalParticipants(){
		
	}
	
	public String returnLoginID(){
		
		return this.ID;
	}

}
