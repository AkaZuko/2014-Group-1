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
	
	public static Boolean validateData(String password, String ID){
		
		
		try{
		Connection conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
		Statement s = conn.createStatement();
		String query = "Select ID,Password from logindata";
		ResultSet rs = s.executeQuery(query);
		
		while(rs.next()){
			System.out.println(rs.getString("Password")+rs.getString("ID"));
			System.out.println(password+ID);
		if(password.equals(rs.getString("Password")) && ID.equals(rs.getString("ID"))){
			System.out.println("VALIDATING!");
			return true;
		}
		}
		
		}catch(SQLException e){
			System.out.println(e.toString());
		}
		return false;
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
