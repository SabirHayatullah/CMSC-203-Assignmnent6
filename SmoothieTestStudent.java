import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SmoothieTestStudent {

	Smoothie S1,S2,S3,S4;
	@Before
	public void setUp() throws Exception {
		S1 = new  Smoothie ("s1Name", Size.SMALL, 1,false );
		S2 = new  Smoothie ("s2NAme", Size.MEDIUM, 2,true );
		S3 = new  Smoothie ("s3NAme", Size.LARGE, 3, true );
		S4 = new  Smoothie ("s4NAme", Size.SMALL, 4, false );
		
	}

	@After
	public void tearDown() throws Exception {
		S1=S2=S3=S4=null;
	}
	
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2.0,S1.getBasePrice(), .01);
		assertEquals(2.0,S2.getBasePrice(), .01);
		assertEquals(2,S3.getBasePrice(), .01);
		assertEquals(2,S4.getBasePrice(), .01);
	}
 
	@Test
	public void testCalPrice() {
		
		assertEquals(2.5,S1.calcPrice(), .01 );
		assertEquals(5.5,S2.calcPrice(), .01 );
		assertEquals(7,S3.calcPrice(), .01 );
		assertEquals(4,S4.calcPrice(), .01 );
		 
	}
	@Test
	public void testToString() {
		
		assertTrue(S1.toString().contains(S1.getBevName()));
		assertTrue(S1.toString().contains(String.valueOf(S1.calcPrice()) ));
		assertTrue(S1.toString().contains(S1.getSize().toString() ));
		assertTrue(S1.toString().contains( String.valueOf(S1.getNumOfFruits()) ));
  
	}
}