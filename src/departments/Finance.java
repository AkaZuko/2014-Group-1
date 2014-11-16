package departments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.AccData;

public class Finance extends Department {

	private static int total_amount;

	Object data[][] = null;

	public Finance() throws IOException {
		super();

	}

	private static int totalAmount = 0;

	public Object[][] getFinanceDetails() throws SQLException {
		Connection conn = DriverManager.getConnection(AccData.getHost(),
				"root", "12345");
		Statement s = conn.createStatement();
		String query = "Select * from Finance;";
		ResultSet rs = s.executeQuery(query);

		int i = 0;
		while (rs.next()) {

			data[i][0] = (String) rs.getString("Date");
			data[i][1] = (String) rs.getString("CashInFlow");

			++i;

		}

		return data;

	}

	public String[] getDetails() throws IOException {

		File pub = new File("res/Finance");
		String details[] = new String[10];

		int i = 0;

		BufferedReader br = new BufferedReader(new FileReader(pub));
		String line;
		while ((line = br.readLine()) != null) {

			details[i] = line;
			i++;

		}

		return details;

	}

	public void addPayment() throws SQLException {

		Connection conn = DriverManager.getConnection(AccData.getHost(),
				"root", "12345");
		Statement s = conn.createStatement();
		String query = "SELECT * FROM Finance;";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			total_amount = (int) rs.getInt("CashInFlow");
		}

		total_amount += 1000;

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());

		String query2 = "insert into Finance values ('" + sqlDate + "','"
				+ total_amount + "','" + sqlTime + "');";
		boolean rs2 = s.execute(query2);

	}

}
