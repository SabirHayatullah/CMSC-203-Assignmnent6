public class Coffee extends Beverage
{
	private final double extraCoffeeShot = 0.50;
	private final double extraCoffeeSyrup = 0.50;
	private final boolean extraShot;
	private final boolean extraSyrup;
	
	public Coffee(String name, Size size, boolean shot, boolean syrup)
	{
		super(name, Type.COFFEE, size);
		this.extraShot = shot;
		this.extraSyrup = syrup;
	}

	@Override
	public String toString()
	{
		String str = "Beverage Name: " + this.getBevName() + "\n";
		str += "Beverage Type: " + this.getType() + "\n";
		str += "Beverage Size: " + this.getSize() + "\n";
		if(extraShot == true)
		{
			str += "\nExtra shot.";
		}
		if(extraSyrup == true)
		{
			str += "\nExtra syrup.";
		}
		else
		{
			str += "\nNo extras.";
		}
		str += "Beverage Price: " + this.calcPrice();
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
		
		if(extraShot == true)
		{
			price += extraCoffeeShot;
		}
		if(extraSyrup == true)
		{
			price += extraCoffeeSyrup;
		}
		return price;
	}
	*/
	
	public double calcPrice(){
		
		double price = this.addSizePrice();
		
		if(this.extraShot) {
			price += this.extraCoffeeShot;
		}
		if(this.extraSyrup) {
			price += this.extraCoffeeSyrup;
		}
		return price;
	}
	
	
	@Override
	public boolean equals(Beverage c)
	{
	
		if(c instanceof Coffee && super.equals(c)
				&& extraShot==((Coffee)c).getExtraShot()&& extraSyrup==((Coffee)c).getExtraSyrup())
		{
			return true;
		}
		return false;
	}
	

	public boolean getExtraShot()
	{
		return this.extraShot;
	}
	public boolean getExtraSyrup()
	{
		return this.extraSyrup;
	}
}