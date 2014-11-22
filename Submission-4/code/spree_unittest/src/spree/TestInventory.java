package spree;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.Inventory;

public class TestInventory {
	Inventory inv;
	@Before
	public void setUp() throws Exception {
	 inv = new Inventory();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testViewInventory() {
		
		//assertArrayEquals(new Object[][] = {{"","","","",""}};, inv.viewInventory());
	}

}
