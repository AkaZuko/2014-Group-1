package registration;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.AccData;
import participant.Participant;

public class RegistrationTest extends TestCase {

	
	Connection conn;
	Statement s;
	Registeration r;
	
	@Before
	public void setUp() throws Exception {
		
		conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		s = conn.createStatement();
		
		String query1 = "INSERT INTO logindata VALUES('Ayush Kasturi','ayush.kasturi@gmail.com','12345','T_1');";
		boolean rs=s.execute(query1);
		r=new Registeration();
		
	}

	@After
	public void tearDown() throws Exception {
		r.totalParticipants--;
		String sql=" DELETE FROM logindata WHERE id='T_1'";
		s.execute(sql);
		conn.close();
		s.close();
		
	}
	
	

	@Test
	public void testValidateData() {
		
		assertEquals(Boolean.valueOf(true),Registeration.validateData("12345","T_1"));
		assertEquals(Boolean.valueOf(false),Registeration.validateData("password","T_1"));
	}

}
