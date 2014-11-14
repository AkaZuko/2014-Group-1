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
	static int totalParticipants = 0;
	
	public Registeration(){
		updateTotalParticipants();
	}
	
	public static Boolean validateData(String password, String ID){
		
		
		try{
		Connection conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
		Statement s = conn.createStatement();
		String query = "Select ID,Password from logindata";
		ResultSet rs = s.executeQuery(query);
		
		while(rs.next()){

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
	
	public static Boolean submitData(String Name, String idno, String pass, String email, String age, String inst){
		try {
			Connection conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
			Statement s = conn.createStatement();
			System.out.println("working");
			String query2 = "INSERT INTO participantdata VALUES(" + "\"" + Name + "\"," + "\"P_" +  idno + "\"," + "\"" + pass + "\"," + "\"" + email +  "\",\"" + Integer.valueOf(age) +  "\"," + "\"" + inst + "\");";
			String query  = "INSERT INTO logindata VALUES(" + "\"" + Name + "\"," + "\"" + email +  "\"," + "\"" + pass + "\"," + "\"P_" +  idno + "\");";
			Boolean rs2 = s.execute(query2);
			Boolean rs3 = s.execute(query);
			System.out.println("working1");						
			
			s.close();
			conn.close();
			return true;
		} catch (SQLException e1) {
			System.out.println(e1.toString());
			return false;
		}
		
	}
	
	public void updateTotalParticipants(){
		try{
			Connection conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
			Statement s = conn.createStatement();
			String query = "Select ID,Password from logindata";
			ResultSet rs = s.executeQuery(query);
			
			while(rs.next()) totalParticipants++;
			}catch(SQLException e){
				System.out.println(e.toString());
			}
		}
	
	public String returnLoginID(){
			return this.ID;
	}

}
