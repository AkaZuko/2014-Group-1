package common;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdminTest {

	Admin ad;
	Connection conn;
	Statement s;
	
	@Before
	public void setUp() throws Exception {
		conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		s = conn.createStatement();
		
		String query1 = "INSERT INTO logindata VALUES('Ayush Kasturi','ayush.kasturi@gmail.com','12345','T_1');";
		boolean rs=s.execute(query1);
		
		ad = new Admin("T_1","12345");
		
		
		conn.close();
		s.close();
		
		
	}

	@After
	public void tearDown() throws Exception {
		conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		s = conn.createStatement();
		String sql="DELETE FROM logindata WHERE id=\'T_1\'";
		s.execute(sql);
		conn.close();
		s.close();
	}

	@Test
	public void testAuthenticateLogin() {
		
		assertEquals(Boolean.valueOf(true),ad.authenticateLogin( "T_1","12345"));
	}

}