package participant;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.AccData;

public class ParticipantTest extends TestCase {

	Connection conn;
	Statement s;
	Participant p;
	
	public void setUp() throws SQLException{
		conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
		s = conn.createStatement();
		
		String query1 = "INSERT INTO participantdata VALUES('Ayush Kasturi','T_1','12345','ayush.kasturi@gmail.com','"+Integer.valueOf(18)+"','BITS Goa','NULL','NULL','NULL','NULL','True','True','True','True');";
		boolean rs=s.execute(query1);
		p=new Participant("T_1");
		

		
		
	}	
	
	@Test
	public void testGetEmail(){
		assertEquals("ayush.kasturi@gmail.com",p.getEmail());
		
	}
	@Test
	public void testGetAge(){
		assertEquals("18",p.getAge());
	}
	
	@Test
	public void testGetInstitution(){
		
		assertEquals("BITS Goa",p.getInstitution());
		
	}
	
	@Test
	public void testGetName(){
		
		assertEquals("Ayush Kasturi",p.getName());
	}
	
	@Test
	public void testGetPassword(){
		
		assertEquals("12345",p.getPassword());
	}
	
	
	public void tearDown() throws SQLException{
		
		
		
		 String sql=" DELETE FROM participantdata WHERE id='T_1'";
		 s.execute(sql);
		
		 conn.close();
		 s.close();
		 
	}
}
