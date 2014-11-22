package spree;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import junit.framework.TestCase;

import org.easymock.*;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.AccData;
import organizer.Convenor;

@SuppressWarnings("unused")
public class ConvenorTest extends TestCase {

	//public AccData ai=null;
	//private Convenor convenor=null;
	
	Convenor c;
	Connection conn;
	Statement s;
	
	  public void setUp() throws Exception {
		  
		    //ai = createNiceMock(AccData.class);
		    //convenor = new Convenor();
		  
		  	conn = DriverManager.getConnection(AccData.getHost(), AccData.getUser(), AccData.getPass());
			s = conn.createStatement();
			
			String query1 = "INSERT INTO organizerdata VALUES('T_1','Rumana Kasturi','rumana.kasturi@gmail.com')";
			boolean rs=s.execute(query1);
			c=new Convenor("T_1");
		    
		  }
	  
		 /*public void testViewDepartmentDetails(String DeptName){
			 replay(ai);
			 verify(ai);
			 
		 }*/
	  
		/*public void testViewFinances(){
						
			convenor.setAccData(ai);
			 expect(ai.viewFinances()).andReturn(0);
			 replay(ai);
			 assertEquals(convenor.viewFinances(),0);
			 verify(ai);
		 }*/
		
		@After
		public void tearDown() throws Exception {
			
			 String sql=" DELETE FROM organizerdata WHERE id='T_1'";
			 s.execute(sql);
			
			 conn.close();
			 s.close();
			
		}

		
		@Test
		public void testGetEmailID() {
			assertEquals("rumana.kasturi@gmail.com",c.getEmailID());
		}
		
		@Test
		public void testGetName() {
			assertEquals("Rumana Kasturi",c.getName());
			
		}

}
