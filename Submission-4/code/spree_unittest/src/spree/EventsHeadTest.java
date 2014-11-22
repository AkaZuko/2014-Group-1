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
import organizer.EventHead;

import common.AccData;

@SuppressWarnings("unused")
public class EventsHeadTest extends TestCase {

	/*
	InventoryInt i;
	ViewResultsFrameInt v;
	SendMessageFrameInt s;
	EventsHead h;
	
	public void setUp(){
		h=new EventsHead();
		i=createNiceMock(InventoryInt.class);
		v=createNiceMock(ViewResultsFrameInt.class);
		s=createNiceMock(SendMessageFrameInt.class);
		
	}
	
	@Test
	public void testApproveInventoryRequest(){
		
		h.setInventory(i);
		
		expect(i.pushItem()).andReturn(1).times(2);
		replay(i);
		
		assertEquals(h.approveInventoryRequest(),1);
		assertEquals(h.approveInventoryRequest(),1);
		verify(i);
	}*/
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
