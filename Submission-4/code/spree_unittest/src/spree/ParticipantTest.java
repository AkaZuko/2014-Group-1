package spree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;

import org.easymock.*;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import participant.Participant;

import common.AccData;

@SuppressWarnings("unused")
public class ParticipantTest extends TestCase {
	
	/*public ParticipantInt p1 = null;
	public UpdateProfileFrameInt p2 = null;
	public DashboardInt p3 = null;
	public Participant pp = null;
	public EventRegInt p4 = null;
	
	
	@Before
	  public void setUp() throws Exception {
	   
			   // NiceMocks return default values for
	    // unimplemented methods
	    p1 = createNiceMock(ParticipantInt.class);
	    p2 = createNiceMock(UpdateProfileFrameInt.class);
	    p3 = createNiceMock(DashboardInt.class);
	    p4 = createNiceMock(EventRegInt.class);
	    pp = new Participant();
	  }
	
	@Test
	  public void testLogOut() {
	    // Setting up the expected value of the method
	    expect(p1.logOut()).andReturn(p1);
	    replay(p1);
  
	    try {
	      p1.logOut();
	  //    fail("Exception did not occur");
	    } catch (RuntimeException e) {
	    	System.out.println(e.toString());
	    }
	 
	    verify(p1);
	  }
public void testDisplayDash(){
		replay(p3);
		verify(p3);
	}
	public void testDoEventRegPar(){
		replay(p4);
		verify(p4);
	}
	
	public void testUpdateProfile(){
		replay(p2);
		verify(p2);
	}
	*/
		Connection conn;
		Statement s;
		Participant p;
		
		public void setUp() throws SQLException{
			conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			s = conn.createStatement();
			
			String query1 = "INSERT INTO participantdata VALUES('Ayush Kasturi','T_1','12345','ayush.kasturi@gmail.com','"+Integer.valueOf(18)+"','BITS Goa','NULL','NULL','NULL','NULL');";
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
