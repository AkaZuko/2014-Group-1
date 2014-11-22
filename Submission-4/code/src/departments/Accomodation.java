package departments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import common.AccData;

/**
* <h1>Accomodation</h1>
* This class defines the functionality of the Accomodation department.<p>
* 
* @author  Group_1 spree
* @version 1.0
*/

//500 is the cost of one room acquired upon accepting accommodation
public class Accomodation extends Department {

	final static int max_acco_slots = 0;
	static int count;


	public Accomodation() throws IOException {
		super();
		
		
	}

	
	/**
	   * This is the fillAccoSlots() method which increments the count of accomodated participants if
	   * the count is within the maximum number of students. 
	   * 
	   * @param none
	   * @return void
	   * @exception IO Exception On file manipulation error.
	   * @see IO Exception
	   */
	
	public Boolean fillAccoSlots(String ID) throws IOException {
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			Statement s = conn.createStatement();
			String query = "Select COUNT(*) FROM accomodationdata;";
			ResultSet rs = s.executeQuery(query);
			while(rs.next()) count = rs.getInt("COUNT(*)"); 
			if(count < max_acco_slots){	
			String query1 = "INSERT INTO accomodationdata Values (\""+ID+"\");";
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String data = dateFormat.format(date);
			DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
			Date date2 = new Date();
			String data2 = dateFormat2.format(date2);
			String query2 = "INSERT INTO finance Values(\"" + data + "\",500,\"" + data2 +"\");";
			s.execute(query1);
			s.execute(query2);
			return true;
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	   * This is the getDetail() method which returns the details of members of the 
	   * Accomodation department
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
			String query = "Select Name from deptdata WHERE Dept=\"Accomodation\";";
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
