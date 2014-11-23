package participant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import common.AccData;
import common.Admin;
import common.DashboardFrame;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import departments.*;

import registration.EventRegisterationFrame;

/**
* <h1>Participant</h1>
* This class defines the various functions of participant like view dashboard
* do event registration and update profile. 
* 
* @author  Group_1 spree
* @version 1.0
*/
public class Participant {

	private String name;
	private String id;
	private String password;
	private String age;

	private String institution;
	private String email;

	public Participant(String Id) {
		try{
		
			Connection conn = DriverManager.getConnection(AccData.getHost(),AccData.getUser(),AccData.getPass());
		Statement s = conn.createStatement();
		String query = "Select * from participantdata";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
		if(rs.getString("ID").equals(Id)){
			this.setName(rs.getString("Name"));
			this.setPassword(rs.getString("Password"));
			this.setAge(Integer.toString(rs.getInt("Age")));
			this.id = Id;
			this.setEmail(rs.getString("Email"));
			this.setInstitution(rs.getString("Institute"));			
		}
		}
		rs.close();
		s.close();
		conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	

	}
	/**
	   * This is the displayDash() method which displays the dashboard of participant 
	   * 
	   * @param none
	   * @return none	   
	   */
	public void displayDash() {
		try {
			DashboardFrame dashFrame = new DashboardFrame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	   * This is the doEventRegPar() method which registers the participant for 
	   * a particular event
	   * 
	   * @param none
	   * @return none	   
	   */
	public void doEventRegPar() {

		EventRegisterationFrame eveFrame = new EventRegisterationFrame(id,institution);
	}
		
	/**
	   * This is the updateProfile() method which updates the profile of participant 
	   * 
	   * @param none
	   * @return none
	   * @exception SQL Exception On database error.
	   * @see SQL Exception	   
	   */
	public void updateProfile() throws SQLException {

		UpdateProfileFrame upframe = new UpdateProfileFrame(id);
		upframe.setVisible(true);
	}
	public String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	public String getInstitution() {
		return institution;
	}
	private void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getAge() {
		return age;
	}
	private void setAge(String age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}

}