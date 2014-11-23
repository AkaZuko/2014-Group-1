package common;

/*
 * This class provides functionality for 
 * validating and authenticating login.
 * 
 * @author Group1_Spree
 * @version 1.0
 */
import java.io.IOException;
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
			rs.next();
			totalRegistrations = rs.getInt("Count");

			rs.close();
			s.close();
			conn.close();
			}catch(SQLException e){
				System.out.println(e.toString());
			}
	}
	
	
	/*
	 * This function acts to authenticateLogin 
	 *
	 * 
	 * @return Boolean 
	 * @param String id, String password 
	 * @Exception IOException
	 */
	public Boolean authenticateLogin(String ID, String pass) throws IOException{
		AccData.addToLog("Admin authenticates");
		
		return Registeration.validateData(pass, ID);
	}
	
	public void updateTotalRegisterations(){
		try{
		Connection conn = DriverManager.getConnection(AccData.getHost(),  AccData.getUser(),  AccData.getPass());
		Statement s = conn.createStatement();
		String query = "Select Count from admindata;";
		
		ResultSet rs = s.executeQuery(query);
		int count = 0;
		while(rs.next()){
			count = rs.getInt("Count");
		}
		System.out.println(count);
		int newcount = count + 1;
		
		query = "UPDATE admindata SET Count="+Integer.toString(newcount)+" WHERE Count="+Integer.toString(count)+";";
		s.executeUpdate(query);
		System.out.println("1230");
		rs.close();
		s.close();
		conn.close();
		}catch(SQLException e){
			System.out.println("1230");
			e.printStackTrace();
			
		}
	}
}
