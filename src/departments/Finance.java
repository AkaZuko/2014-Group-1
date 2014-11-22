package departments;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.AccData;


/**
* <h1>Finance</h1>
* This class defines the functionality of the Finance department.<p>
* 
* @author  Group_1 spree
* @version 1.0
*/

public class Finance extends Department {

	private static int total_amount;

	Object data[][] = null;

	public Finance() throws IOException {
		super();
		try{
		Connection conn = DriverManager.getConnection(AccData.getHost(),
				AccData.getUser(), AccData.getPass());
		Statement s = conn.createStatement();
		String query = "SELECT SUM(CashInFlow) FROM finance;";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			total_amount = (int) rs.getInt("SUM(CashInFlow)");
		}
		}catch(SQLException e){
			System.out.println(this.getClass().toString() + " ERROR : " + e.toString());
		}

	}
	
	
	
	/**
	   * This is the getFinance() method which returns the details of the date and time of Cash in flow , 
	   * and total amount after every such transcation.
	   * @param none
	   * @return Object[][]  the returned value is date,cash and time values
	   * @exception SQL Exception On database error.
	   * @see SQL Exception
	   */
	
	public Object[][] getFinanceDetails() throws SQLException {
		Connection conn = DriverManager.getConnection(AccData.getHost(),
				AccData.getUser(), AccData.getPass());
		Statement s = conn.createStatement();
		String query = "Select * from finance;";
		ResultSet rs = s.executeQuery(query);

		int i = 0;
		while (rs.next()) {

			data[i][0] = (String) rs.getString("Date");
			data[i][1] = (String) rs.getString("CashInFlow");
			data[i][2] = (String) rs.getString("Time");
			++i;

		}

		return data;

	}
	
	
	/**
	   * This is the getDetail() method which returns the details of members of the 
	   * Finance department
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
			String query = "Select Name from deptdata WHERE Dept = \"Finance\";";
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

	
	/**
	   * This is the addPayment() method which updates the Finance table
	   * whenever a student registers
	   * @param none
	   * @return void  the returned value is void
	   * @exception SQL Exception On database error.
	   * @see SQL Exception
	   */
	
	public void addPayment(String amt) throws SQLException {

		Connection conn = DriverManager.getConnection(AccData.getHost(),
				AccData.getUser(), AccData.getPass());
		Statement s = conn.createStatement();
		String query = "SELECT SUM(CashInFlow) FROM finance;";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			total_amount = (int) rs.getInt("SUM(CashInFlow)");
		}
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());

		String query2 = "insert into finance values ('" + sqlDate + "','"
				+ amt + "','" + sqlTime + "');";
		boolean rs2 = s.execute(query2);

	}

}
