import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Order implements OrderInterface, Comparable<Order>
{
	private int orderNum;
	private int orderTime;
	private Day orderDay;
	private Customer orderCustomer;
	ArrayList<Beverage> bevList;
	

	public Order(int time, Day day, Customer customer)
	{
		this.orderNum = generateOrder();
		this.orderTime = time;
		this.orderDay = day;
		this.orderCustomer = customer;
		this.bevList = new ArrayList<Beverage>();
	}
	
	public int generateOrder()
	{
		//int num = 0;
		//final int MIN = 10000;
		//final int MAX = 90000;
		
		//Random rand = new Random(MIN);
		//num = rand.nextInt(MAX - MIN) + 1;
		
		return ThreadLocalRandom.current().nextInt(10000, 90001);
	}
	
	@Override
	public boolean isWeekend()
	{
		boolean endOfWeek = false;
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
		{
			endOfWeek = true;
		}
		return endOfWeek;
	}
	
	public int getOrderNo()
	{
		return this.orderNum;
	}
	
	public int getOrderTime()
	{
		return this.orderTime;
	}
	
	public Day getOrderDay()
	{
		return this.orderDay;
	}
	
	public Customer getCustomer()
	{
		return new Customer(orderCustomer);
	}
	
	public int getTotalItems()
	{
		return this.bevList.size();
	}
	
	@Override
	public int compareTo(Order O)
	{
		int value = 0;
		if(this.getOrderNo() == O.getOrderNo())
		{
			value = 0;
		}
		else if(this.getOrderNo() > O.getOrderNo())
		{
			value = 1;
		}
		else if(this.getOrderNo() < O.getOrderNo())
		{
			value = -1;
		}
		return value;
	}

	@Override
	public Beverage getBeverage(int itemNo)
	{
		return bevList.get(itemNo);
	}


	public void addNewBeverage(String bevName, Size size)
	{
		Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
		bevList.add(alcohol);
	}

	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addPRotien) 
	{
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addPRotien);
		bevList.add(smoothie);
	}

	@Override
	public double calcOrderTotal() 
	{
		double orderTotal = 0.0;
		for(int i = 0; i < bevList.size(); i++)
		{
			orderTotal += bevList.get(i).calcPrice();
		}
		return orderTotal;
	}

	public int findNumOfBeveType(Type type)
	{
		int bevNum = 0;
		for(int i = 0; i < bevList.size(); i++)
		{
			if(bevList.get(i).getType() == type)
			{
				bevNum++;
			}
		}
		return bevNum;
	}
	
	public String toString()
	{
		String str = "Order Number: " + getOrderNo();
		str += "\nCustomer Name: " + getCustomer().getName();
		str += "\nCustomer Age: " + getCustomer().getAge();
		str += "\nOrder Size: " + bevList.size();
		str += "\nOrder Time: " + getOrderTime();
		str += "\nOrder Day: " + getOrderDay();
		str += "\nBeverage Name: " + "\n"; 
		for(int i = 0; i < bevList.size(); i++)
		{
			str += bevList.get(i) + "\n";
		}
		str += "\nOrder Total: " + this.calcOrderTotal(); 

		return str;
		
	}

	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		this.bevList.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	@Override
	public void addNewBeverage(String bevName, javafx.css.Size size, boolean extraShot, boolean extraSyrup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewBeverage(String bevName, javafx.css.Size size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewBeverage(String bevName, javafx.css.Size size, int numOfFruits, boolean addProtein) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findNumOfBeveType(java.awt.Window.Type type) {
		// TODO Auto-generated method stub
		return 0;
	}
}