public class Alcohol extends Beverage
{
	private boolean isWeekend;
	private final double weekEndPrice = 0.60;
	
	public Alcohol(String bevName, Size size, boolean weekEnd)
	{
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = weekEnd;
	}
	
	@Override
	public String toString()
	{
		String str = "Beverage Name: " + this.getBevName() + "\n";
		str += "Beverage Type: " + this.getType() + "\n";
		str += "Beverage Size: " + this.getSize() + "\n";
		if(isWeekend == true)
		{
			str += "\nServed on Weekends.";
		}
		else
		{
			str += "\nNot Served on Weekends.";
		}
		str += "\nBeverage Price: " + this.calcPrice();
		return str;
	}
	
	/*
	@Override
	public double calcPrice()
	{
		double price = getBasePrice(); // SMALL is Base Price, i.e. 2.0.
		if(getSize() == Size.MEDIUM)
		{
			price += getBasePrice();
		}
		else if(getSize() == Size.LARGE)
		{
			price += (getBasePrice() * 2);
		}
		
		if(isWeekEnd == true)
		{
			price += weekEndPrice;
		}
		return price;
	}
	*/
	
	@Override
	public double calcPrice(){
		if(this.isWeekEnd()) {
			return this.addSizePrice() + this.weekEndPrice;
		}
		return this.addSizePrice();
	}
	
	@Override
	public boolean equals(Beverage  a)
	{
		//a = new Alcohol(getBevName(), getSize(), isWeekEnd);
		if(a instanceof Alcohol && super.equals(a))
		{
			 return true;
		}
		return false;
	}

	public boolean isWeekEnd() {
		return isWeekend;
	}

	public void setWeekEnd(boolean isWeekEnd) {
		this.isWeekend = isWeekEnd;
	}
	
}