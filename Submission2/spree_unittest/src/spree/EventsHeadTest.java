package spree;
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

@SuppressWarnings("unused")
public class EventsHeadTest extends TestCase {

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
	}
	
	}
