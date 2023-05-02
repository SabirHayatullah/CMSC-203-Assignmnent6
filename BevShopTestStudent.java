import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BevShopTestStudent {

	BevShop bevShop;
	@Before
	public void setUp() throws Exception {
		bevShop = new BevShop();
	}

	@After
	public void tearDown() throws Exception {
		bevShop = null;
	}

	@Test
	public void testValidTime()
	{
		assertTrue(bevShop.isValidTime(8));
		assertTrue(bevShop.isValidTime(23));
		assertFalse(bevShop.isValidTime(7));
		assertFalse(bevShop.isValidTime(24));
	}

	@Test
	public void testValidAge()
	{
		assertFalse(bevShop.isValidAge(20));
		assertTrue(bevShop.isValidAge(27));
	}

	@Test
	public void testStartNewOrder()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"Malik", 30);
		assertEquals(8, bevShop.getCurrentOrder().getOrderTime());
		assertEquals(Day.MONDAY, bevShop.getCurrentOrder().getOrderDay());
		assertEquals(8, bevShop.getCurrentOrder().getOrderTime());
		assertEquals("Malik", bevShop.getCurrentOrder().getCustomer().getName());
		assertEquals(30, bevShop.getCurrentOrder().getCustomer().getAge());
		assertEquals(0, bevShop.getNumOfAlcoholDrink());
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 0);

	}

	@Test
	public void testProcessAlcoholOrder()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"Malik", 30);

		bevShop.processAlcoholOrder("Makiato", Size.LARGE);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Makiato"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.ALCOHOL));
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("SoftD", Size.MEDIUM);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("SoftD"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.MEDIUM));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.ALCOHOL));
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("V", Size.SMALL);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 3);
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getBevName().equals("V"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(2).getType().equals(Type.ALCOHOL));
		assertEquals(1,bevShop.totalNumOfMonthlyOrders());

	}

	@Test
	public void testProcessSmoothieOrder()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"Malik", 30);
		assertTrue ( bevShop.isMaxFruit(6));
		assertFalse ( bevShop.isMaxFruit(5));
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems()== 1);

		Smoothie sm = (Smoothie) bevShop.getCurrentOrder().getBeverage(0);

		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Detox"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.SMOOTHIE));


		assertTrue(sm.getNumOfFruits() == 1);
		assertFalse(sm.getAddProtein());


		bevShop.processSmoothieOrder("Earth Quake", Size.LARGE, 4, true);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);

		sm =  (Smoothie) bevShop.getCurrentOrder().getBeverage(1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Earth Quake"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.SMOOTHIE));

		assertTrue(sm.getNumOfFruits() == 4);
		assertTrue(sm.getAddProtein());
		assertEquals(1,bevShop.totalNumOfMonthlyOrders());

	}

	@Test
	public void testProcessCoffeeOrder()
	{
		Coffee cf;
		bevShop.startNewOrder(8,Day.MONDAY,"Kyle", 20);
		bevShop.processCoffeeOrder("Latin", Size.SMALL, true, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);

		cf = (Coffee) bevShop.getCurrentOrder().getBeverage(0);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Latin"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.COFFEE));
		assertTrue(cf.getExtraShot());
		assertFalse(cf.getExtraSyrup());

		bevShop.processCoffeeOrder("Sprice", Size.LARGE, false, false);
		cf = (Coffee) bevShop.getCurrentOrder().getBeverage(1);

		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);

		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Sprice"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.COFFEE));
		assertFalse(cf.getExtraShot());
		assertFalse(cf.getExtraSyrup());

	}

	@Test
	public void testFindOrder()
	{

		int orderNum;
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("Latin", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		bevShop.processSmoothieOrder("EarthQuake", Size.LARGE, 4, true);

		orderNum = bevShop.getCurrentOrder().getOrderNo();

		bevShop.startNewOrder(8,Day.SUNDAY,"Malik", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);

		assertEquals(0, bevShop.findOrder(orderNum));

		orderNum = bevShop.getCurrentOrder().getOrderNo();
		assertEquals(1,bevShop.findOrder(orderNum));

	}
	@Test
	public void testTotalOrderPrice()
	{
	 	int orderNum1,orderNum2;

		bevShop.startNewOrder(8,Day.MONDAY,"Kyle", 20);
		bevShop.processCoffeeOrder("Latin", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Sprice", Size.LARGE, false, false);
		bevShop.processCoffeeOrder("Lettuce", Size.LARGE,true, true);

		orderNum1 = bevShop.getCurrentOrder().getOrderNo();

		bevShop.startNewOrder(8,Day.SUNDAY,"Malik", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);

		orderNum2 = bevShop.getCurrentOrder().getOrderNo();

		assertEquals(11.5,bevShop.totalOrderPrice(orderNum1),.01);
		assertEquals(2.5,bevShop.totalOrderPrice(orderNum2),.01);

	}
	@Test
	public void testTotalMonthlySale()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"Kyle", 20);
		bevShop.processCoffeeOrder("Latin", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Sprice", Size.LARGE, false, false);
		bevShop.processCoffeeOrder("Lettuce", Size.LARGE,true, true);

		bevShop.startNewOrder(8,Day.SUNDAY,"Malik", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);
		bevShop.processAlcoholOrder("Makiato", Size.SMALL);

		bevShop.startNewOrder(12,Day.SATURDAY,"Amy", 43);
		bevShop.processSmoothieOrder("Detox", Size.MEDIUM, 4, true);
		bevShop.processCoffeeOrder("Lettuce", Size.SMALL,false, false);


		assertEquals(25.1, bevShop.totalMonthlySale(), .01);

	}

	@Test
	public void testSortOrders()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"Kyle", 20);
		bevShop.startNewOrder(8,Day.SUNDAY,"Malik", 30);
		bevShop.startNewOrder(12,Day.SATURDAY,"Alex", 43);

		bevShop.sortOrders();
		assertTrue(bevShop.getOrderAtIndex(0).getOrderNo()< bevShop.getOrderAtIndex(1).getOrderNo());
		assertTrue(bevShop.getOrderAtIndex(1).getOrderNo()< bevShop.getOrderAtIndex(2).getOrderNo());

	}@Test
	public void testToString() {

		bevShop.startNewOrder(8,Day.MONDAY,"Kyle", 20);
		bevShop.processCoffeeOrder("Latin", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Sprice", Size.LARGE, false, false);


		bevShop.startNewOrder(8,Day.SUNDAY,"Malik", 30);
		bevShop.processSmoothieOrder("Detox", Size.SMALL, 1, false);


		assertTrue(bevShop.toString().contains( String.valueOf(bevShop.getOrderAtIndex(0).getOrderNo())));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getCustomer().getName()));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getBeverage(0).getSize().toString()));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getBeverage(0).getBevName()) );


		assertTrue(bevShop.toString().contains( String.valueOf(bevShop.getOrderAtIndex(1).getOrderNo())));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getCustomer().getName()));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getBeverage(0).getSize().toString()));
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getBeverage(0).getBevName()));

		assertTrue(bevShop.toString().contains( String.valueOf(bevShop.totalMonthlySale())));



	}
}