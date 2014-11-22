package eventManager;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import organizer.EventHead;
import common.AccData;

public class EventManagerTest {

	EventManager em;
	Connection conn;
	Statement s;
	
	@Before
	public void setUp() throws Exception {
		
		conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		s = conn.createStatement();
		
		String query1 = "INSERT INTO emdata VALUES('T_1','Rumana Kasturi','rumana.kasturi@gmail.com','Basketball')";
		boolean rs=s.execute(query1);
		em=new EventManager("T_1");
	}

	@After
	public void tearDown() throws Exception {
		
		String sql=" DELETE FROM emdata WHERE id='T_1'";
		 s.execute(sql);
		
		 conn.close();
		 s.close();
	}

	

	@Test
	public void testGetEmail(){
		assertEquals("rumana.kasturi@gmail.com",em.getEmailID());
		
	}
	@Test
	public void testGetID(){
		assertEquals("T_1",em.getID());
	}
	
	
	@Test
	public void testGetName(){
		
		assertEquals("Rumana Kasturi",em.getName());
	}
	
	@Test
	public void testGetGame(){
		
		assertEquals("Basketball",em.getGame());
	}
	
	

}
