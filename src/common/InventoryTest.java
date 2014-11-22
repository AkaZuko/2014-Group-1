package common;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import organizer.EventHead;

public class InventoryTest {

	Connection conn;
	Statement s;
	Inventory i1;
	ResultSet rs;
	 Object[][] data = new Object[10][5];

	
	@Before
	public void setUp() throws Exception {
		conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		s = conn.createStatement();
		String query1 = "INSERT INTO inventory VALUES('ImaginaryItem','30','10','24','2014-06-10')";
		boolean r1=s.execute(query1);
		 rs=s.executeQuery("SELECT * from inventory");
		 int i=0;
		while(rs.next()){
				
				data[i][0] = (String)rs.getString("Name");
				data[i][1] = (String)rs.getString("MaxCap");
				data[i][2] = (String)rs.getString("MinCap");
				data[i][3] = (String)rs.getString("NoOfItems");
				data[i][4] = (String)rs.getString("LastModified");
				
				++i;
			}
		i1=new Inventory();
	}

	@After
	public void tearDown() throws Exception {
		
		String sql=" DELETE FROM inventory WHERE name='ImaginaryItem'";
		 s.execute(sql);
		
		 conn.close();
		 s.close();
	}
	
	
	//Object[][] k
	@Test
	public void testViewInventory() throws IOException {
		assertEquals(data.getClass(),i1.viewInventory().getClass());
		
	}

}
