package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JTable;

public class Inventory {

	public Object viewInventory(){
		Object[][] data = new Object[10][5];
		try {
			Connection conn = DriverManager.getConnection(AccData.getHost(), "root", "12345");
			Statement s = conn.createStatement();
			String query = "Select * from inventory";
			ResultSet rs = s.executeQuery(query);
			
			int i = 0;
			
			while(rs.next()){
				
				data[i][0] = (String)rs.getString("Name");
				data[i][1] = (String)rs.getString("MaxCap");
				data[i][2] = (String)rs.getString("MinCap");
				data[i][3] = (String)rs.getString("NoOfItems");
				data[i][4] = (String)rs.getString("LastModified");
				
				++i;
			}
			
			
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		return data;
	}
}
