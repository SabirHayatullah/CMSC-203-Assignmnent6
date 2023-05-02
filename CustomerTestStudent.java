import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTestStudent {

	Customer C1,C2;
	@Before
	public void setUp() throws 
	Exception {
		 C1 = new Customer("NAME1", 10);
	 
	}

	@After
	public void tearDown() throws Exception {
		
		C1=null;
	}

	@Test
	public void testConstructor() {
		
		Customer c2  = new Customer(C1);
		
		assertFalse(C1 == c2);
		c2.setName("NAME2");
		c2.setAge(20);
		assertFalse(c2.getName().equals(C1.getName()));
		assertFalse(c2.getAge() == C1.getAge());
		 
	}

	 
		


}