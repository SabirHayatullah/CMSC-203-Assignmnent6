import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrderTestStudent {

	Order O1,O2,O3,O4;
	@Before
	public void setUp() throws Exception {
		O1 = new Order (8, Day.MONDAY, new Customer ("Alex", 22));// I see
		O2 = new Order (12, Day.SATURDAY, new Customer ("Steve", 45));
		O3 = new Order (10, Day.SUNDAY, new Customer ("Kevin", 21));
	}

	@After
	public void tearDown() throws Exception {
		O1=O2=O3=null;
	}
	
	@Test 
	public void testGetBeverage( )
	{
		Coffee cf = new Coffee("usual size Coffee", Size.SMALL, false,false);
		Alcohol al = new Alcohol ("Makiato", Size.SMALL, false);
		Smoothie sm1 = new Smoothie("Detox", Size.MEDIUM,1,false);
		Smoothie sm2 = new Smoothie("Detox", Size.LARGE,1,false);
		
		O1.addNewBeverage("usual size Coffee", Size.SMALL, false,false);
		O1.addNewBeverage("Makiato", Size.SMALL); 
		O1.addNewBeverage("Detox", Size.MEDIUM,1,false); 
		assertTrue(O1.getBeverage(0).equals(cf) );
		assertTrue(O1.getBeverage(1).equals(al) );
		assertTrue(O1.getBeverage(2).equals(sm1) );
		assertFalse(O1.getBeverage(2).equals(sm2) );
	}

	@Test
	public void testAddNewBeverage() throws NullPointerException   {
		
		assertTrue(O1.getTotalItems() == 0);
		O1.addNewBeverage("usual size Coffee", Size.SMALL, false,false);
	 	assertTrue(O1.getBeverage(0).getType().equals(Type.COFFEE));
		O1.addNewBeverage("Makiato", Size.SMALL); 
		assertTrue(O1.getBeverage(1).getType().equals(Type.ALCOHOL));
		O1.addNewBeverage("Detox", Size.MEDIUM,1,false); 
		assertTrue(O1.getBeverage(2).getType().equals(Type.SMOOTHIE));
		assertTrue(O1.getTotalItems() == 3);
		
		O2.addNewBeverage("Detox", Size.MEDIUM,4,true); 
		assertTrue(O2.getBeverage(0).getType().equals(Type.SMOOTHIE));
		O2.addNewBeverage("Makiato", Size.SMALL); 
		assertTrue(O2.getBeverage(1).getType().equals(Type.ALCOHOL));
		O2.addNewBeverage("regular Coffee", Size.MEDIUM, true,false);
		assertTrue(O2.getBeverage(2).getType().equals(Type.COFFEE));
		assertTrue(O2.getTotalItems() == 3);
		 
	}
	 
	@Test
	public void testisWeekend()   {
		
		assertFalse(O1.isWeekend());
		assertTrue(O2.isWeekend());
		assertTrue(O3.isWeekend());
		 
	}
	
	@Test
	public void testCalcOrderTotal()   {
		O1.addNewBeverage("usual size Coffee", Size.SMALL, false,false);
	 	O1.addNewBeverage("Makiato", Size.SMALL); 
		O1.addNewBeverage("Detox", Size.MEDIUM,1,false); 
	 
		assertEquals(7.5,O1.calcOrderTotal(),.01);
		
		O2.addNewBeverage("usual size Coffee", Size.MEDIUM, true,false);
	 	O2.addNewBeverage("Makiato", Size.SMALL); 
		O2.addNewBeverage("Detox", Size.MEDIUM,4,true); 
		
		assertEquals(12.6,O2.calcOrderTotal(),.01);
		 
	}
	
	@Test
	public void testFindNumOfBeveType()
	{
		O1.addNewBeverage("usual size Coffee", Size.SMALL, false,false);
	 	O1.addNewBeverage("Makiato", Size.SMALL); 
		O1.addNewBeverage("Detox", Size.MEDIUM,1,false); 
		O1.addNewBeverage("French Hazelnut", Size.LARGE, true,true);
		assertEquals(2, O1.findNumOfBeveType(Type.COFFEE));
		assertEquals(1, O1.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(1, O1.findNumOfBeveType(Type.ALCOHOL));
		
		O2.addNewBeverage("usual size Coffee", Size.MEDIUM, true,false);
	 	O2.addNewBeverage("Makiato", Size.SMALL); 
	 	assertEquals(0, O2.findNumOfBeveType(Type.SMOOTHIE));
	}
	@Test
	public void testToString() {
		
		O1.addNewBeverage("usual size Coffee", Size.SMALL, false,false);
	 	O1.addNewBeverage("Makiato", Size.LARGE); 
		 
		assertTrue(O1.toString().contains( String.valueOf(O1.getOrderNo()) ));
		assertTrue(O1.toString().contains( O1.getCustomer().getName()) );
		assertTrue(O1.toString().contains(O1.getBeverage(0).getSize().toString()) )  ;
		assertTrue(O1.toString().contains(O1.getBeverage(0).getBevName()) );
		
	 	 
		assertTrue(O1.toString().contains(O1.getBeverage(1).getSize().toString()))  ;
		assertTrue(O1.toString().contains(O1.getBeverage(1).getBevName()) );
		assertTrue(O1.toString().contains( String.valueOf(O1.getBeverage(1).calcPrice()) ));
		
		assertTrue(O1.toString().contains( String.valueOf(O1.calcOrderTotal() )  ));
		 
	 
	 
	}

}