package participant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import common.AccData;
import common.Admin;
import common.DashboardFrame;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import registration.EventRegisterationFrame;

public class Participant {

	private String name;
	private String id;
	private String password;
	private String age;

	private String institution;
	private String email;

	public Participant(String Id) {
		try{
		Connection conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
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
	public void displayDash() {
		DashboardFrame dashFrame = new DashboardFrame();// Add attributes to the constructor
		// eveFrame.setVisible(true);
	}

	public void doEventRegPar() {

		EventRegisterationFrame eveFrame = new EventRegisterationFrame(id,institution);// Add attributes to the constructor
		// eveFrame.setVisible(true);
	}

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