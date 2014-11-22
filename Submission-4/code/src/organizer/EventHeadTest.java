package organizer;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import participant.Participant;
import common.AccData;

public class EventHeadTest {

	
	EventHead eh;
	Connection conn;
	Statement s;
	
	
	@Before
	public void setUp() throws Exception {
		
		conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		s = conn.createStatement();
		
		String query1 = "INSERT INTO organizerdata VALUES('T_1','Rumana Kasturi','rumana.kasturi@gmail.com')";
		boolean rs=s.execute(query1);
		eh=new EventHead("T_1");
		
	}

	@After
	public void tearDown() throws Exception {

		 String sql=" DELETE FROM organizerdata WHERE id='T_1'";
		 s.execute(sql);
		
		 conn.close();
		 s.close();
	}
	
	

	@Test
	public void testGetID() {
		assertEquals("T_1",eh.getID());
		
	}

	@Test
	public void testGetEmailID() {
		assertEquals("rumana.kasturi@gmail.com",eh.getEmailID());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Rumana Kasturi",eh.getName());
		
	}
}
