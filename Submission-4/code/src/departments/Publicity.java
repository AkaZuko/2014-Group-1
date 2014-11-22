package departments;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.AccData;


/**
* <h1>Publicity</h1>
* This class defines the functionality of the Publicity department.<p>
* 
* @author  Group_1 spree
* @version 1.0
*/



public class Publicity extends Department {

	public Publicity() throws IOException{
		super();

	}

	/**
	   * This is the getDetail() method which returns the details of members of the 
	   * Publicity department
	   * @param none
	   * @return String[]  the returned value is of an array of member names
	   * @exception IO Exception On file manipulation error.
	   * @see IO Exception
	   */
	
	public String[] getDetails(){

		String details[] = new String[10];
		try{
			Connection conn = DriverManager.getConnection(AccData.getHost(),AccData.getUser(),AccData.getPass());
			Statement s = conn.createStatement();
			String query = "Select Name from deptdata WHERE Dept=\"Publicity\";";
			ResultSet rs = s.executeQuery(query);
			int i= 0;
			while(rs.next()){
				details[i] = rs.getString("Name");
				i = i+1;
			}
		}catch(SQLException e){
			System.out.println(e.toString());
		}
		return details;

	}

}
