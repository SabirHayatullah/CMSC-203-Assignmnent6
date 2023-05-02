import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CoffeeTestStudent {

	Coffee Cf1,Cf2,Cf3,Cf4;
	@Before
	public void setUp() throws Exception {
		Cf1 = new  Coffee ("Alexa", Size.SMALL, false,false );
		Cf2 = new  Coffee ("namec2", Size.MEDIUM, true,true );
		Cf3 = new  Coffee ("Namec3", Size.LARGE, false, true );
		Cf4 = new  Coffee ("Cf4NAme", Size.SMALL, true, false );
		
	}

	@After
	public void tearDown() throws Exception {
		Cf1=Cf2=Cf3=Cf4=null;
	}
	
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2.0,Cf1.getBasePrice(), .01);
		assertEquals(2.0,Cf2.getBasePrice(), .01);
		assertEquals(2,Cf3.getBasePrice(), .01);
		assertEquals(2,Cf4.getBasePrice(), .01);
	}

	@Test
	public void testCalPrice() {
		
		assertEquals(2,Cf1.calcPrice(), .01 );
		assertEquals(4,Cf2.calcPrice(), .01 );
		assertEquals(4.5,Cf3.calcPrice(), .01 );
		assertEquals(2.5,Cf4.calcPrice(), .01 );
		 
	}
	@Test
	public void testToString() {
		
		assertTrue(Cf1.toString().contains(Cf1.getBevName()));
		assertTrue(Cf1.toString().contains(String.valueOf(Cf1.calcPrice()) ));
		assertTrue(Cf1.toString().contains(Cf1.getSize().toString() ));
	 
	 
	}
}