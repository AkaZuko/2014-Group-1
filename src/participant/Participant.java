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
	private int age;
	private Admin admin;
	private String institution;
	private String email;

	public Participant(String Id) {
		this.name = name;
		id = Id;
		this.password = password;
		this.admin = admin;
		this.age = age;
		this.institution = institution;
		this.email = email;
	}

	public int getAge() throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		boolean flag = false;
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();
		String query = "Select * from participant";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			String Id = rs.getString("id");
			if (Id.equals(this.id)) {
				flag = true;
				return rs.getInt("age");
			}
			if (flag) {
				rs.close();
				s.close();
				conn.close();
				break;
			}
		}
		rs.close();
		s.close();
		conn.close();
		return 0;
	}

	public void setAge(int Age) throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();

		
		String sql = "UPDATE participant " +
                "SET age ="+ Age+  " WHERE id =\"" + this.id + "\"";
   s.executeUpdate(sql);
		
		s.close();
		conn.close();
	}

	public String getInstitution() throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		boolean flag = false;
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();
		String query = "SELECT * from participant";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			String Id = rs.getString("id");
			if (Id.equals(this.id)) {
				flag = true;
				return rs.getString("institution");
			}
			if (flag) {
				rs.close();
				s.close();
				conn.close();
				break;
			}
		}
		rs.close();
		s.close();
		conn.close();
		return null;
	}

	public void setInstitution(String institution) throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();

		

		String sql = "UPDATE participant " +
                "SET institution =\""+ institution + "\"" + " WHERE id =\"" + this.id + "\"";
   s.executeUpdate(sql);
		
		
		s.close();
		conn.close();
	}

	public String getEmail() throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		boolean flag = false;
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();
		String query = "SELECT * from participant";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			String Id = rs.getString("id");
			if (Id.equals(this.id)) {
				flag = true;
				return rs.getString("email");
			}
			if (flag) {
				rs.close();
				s.close();
				conn.close();
				break;
			}
		}
		rs.close();
		s.close();
		conn.close();
		return null;
	}

	public void setEmail(String email) throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();

		
		String sql = "UPDATE participant " +
                "SET email =\""+ email + "\"" + " WHERE id =\"" + this.id + "\"";
   s.executeUpdate(sql);
		
		s.close();
		conn.close();
	}

	public void displayDash() {
		DashboardFrame dashFrame = new DashboardFrame();// Add attributes to the constructor
		// eveFrame.setVisible(true);
	}

	public void doEventRegPar() {

		EventRegisterationFrame eveFrame = new EventRegisterationFrame();// Add attributes to the constructor
		// eveFrame.setVisible(true);
	}

	public void updateProfile() throws SQLException {

		UpdateProfileFrame upframe = new UpdateProfileFrame(id);
		upframe.setVisible(true);
	}

	public String getName() throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		boolean flag = false;
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();
		String query = "SELECT * from participant";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			String Id = rs.getString("id");
			
	         int age = rs.getInt("age");      
	         
	         //Display values
	         
			if (Id.equals(this.id)) {
				flag = true;
				return rs.getString("name");
			}
			if (flag) {
				rs.close();
				s.close();
				conn.close();
				break;
			}
		}
		rs.close();
		s.close();
		conn.close();
		return null;
	}

	public void setName(String name) throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();

		

		String sql = "UPDATE participant " +
                "SET name =\""+ name + "\"" + " WHERE id =\"" + this.id + "\"";
   s.executeUpdate(sql);
		
		
		s.close();
		conn.close();
	}

	public String getId() throws SQLException {

		final String url = "jdbc:mysql://localhost:3306/spree";
		boolean flag = false;
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();
		String query = "SELECT * from participant";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			String Id = rs.getString("id");
			if (Id.equals(this.id)) {
				flag = true;
				return rs.getString("id");
			}
			if (flag) {
				rs.close();
				s.close();
				conn.close();
				break;
			}
		}
		rs.close();
		s.close();
		conn.close();
		return null;
	}

	public void setId(String id) throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();

		

		String sql = "UPDATE participant " +
                "SET id =\""+ id + "\"" + " WHERE id =\"" + this.id + "\"";
   s.executeUpdate(sql);
		
		s.close();
		conn.close();
	}

	public String getPassword() throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		boolean flag = false;
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();
		String query = "SELECT * from participant";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			String Id = rs.getString("id");
			if (Id.equals(this.id)) {
				flag = true;
				return rs.getString("password");
			}
			if (flag) {
				rs.close();
				s.close();
				conn.close();
				break;
			}
		}
		rs.close();
		s.close();
		conn.close();
		return null;
	}

	public void setPassword(String password) throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/spree";
		Connection conn = DriverManager.getConnection(url, "root", "12345");
		Statement s = conn.createStatement();

		

		String sql = "UPDATE participant " +
                "SET password =\""+ password + "\"" + " WHERE id =\"" + this.id + "\"";
   s.executeUpdate(sql);
		
		
		s.close();
		conn.close();
	}

}