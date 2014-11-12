package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccData {
	private static String url = "jdbc:mysql://localhost:3306/Spree";

	public static String getHost() {
		return url;
	}
	public static void main(String[] args){
		
		try {
			Connection conn = DriverManager.getConnection(url, "root", "12345");
			Statement s = conn.createStatement();
			String query = "Select * from inventory";
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){
				String Name = rs.getString("Name");
				System.out.println("Name : " + Name );
			}
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
	}
}
