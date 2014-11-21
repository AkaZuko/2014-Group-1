package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import registration.Registeration;

public class Admin {
	private String ID;
	private String password;
	private static int totalRegistrations;
	public Admin(String id, String password){
		this.ID = id;
		this.password = password;
		try{
			Connection conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			Statement s = conn.createStatement();
			String query = "Select Count from admindata;";
			
			ResultSet rs = s.executeQuery(query);
			totalRegistrations = rs.getInt("Count");

			rs.close();
			s.close();
			conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public Boolean authenticateLogin(String ID, String pass){
		return Registeration.validateData(pass, ID);
	}
	
	public void updateTotalRegisterations(){
		try{
		Connection conn = DriverManager.getConnection(AccData.getHost(),  AccData.getUser(),  AccData.getPass());
		Statement s = conn.createStatement();
		String query = "Select Count from admindata;";
		
		ResultSet rs = s.executeQuery(query);
		int count = rs.getInt("Count");
		count = count + 1;
		
		query = "UPDATE admindata SET Count="+Integer.toString(count)+";";
		s.executeUpdate(query);
		
		rs.close();
		s.close();
		conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
