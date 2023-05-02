public abstract class Beverage
{
	private String name;
	private Type type;
	private Size size;
	private final double basePrice = 2.0;
	private final double sizeUpPrice = 1.0;
	
	public Beverage(String name, Type type, Size size)
	{
		this.name = name;
		this.type = type;
		this.size = size;
	}
		
	public abstract double calcPrice();
	
	@Override
	public String toString()
	{
		//String str = "Beverage Name: " + this.getBevName() + "\n";
		//str += "Beverage Type: " + this.getType() + "\n";
		//str += "Beverage Size: " + this.getSize() + "\n";
		//str += "Beverage Price: " + this.calcPrice();
		//return str;
		return this.getBevName() + "," + this.size;
	}
	
	public boolean equals(Beverage bevObj)
	{
		
		if(this.name.equalsIgnoreCase(bevObj.getBevName())
				&& (this.type == bevObj.getType())
				&& (this.size == bevObj.getSize()))
		{
			return true;
		}
		return false;
	}
	
	//Accessors
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setType(Type type)
	{
		this.type = type;
	}
	
	public void setSize(Size size)
	{
		this.size = size;
	}
	
	public String getBevName()
	{
		return this.name;
	}
	
	public Type getType()
	{
		return this.type;
	}
	
	public Size getSize()
	{
		return this.size;
	}
	
	public double getBasePrice()
	{
		return this.basePrice;
	}
	
	public double getSizeUpPrice()
	{
		return sizeUpPrice;
	}
	public double addSizePrice() {
		if(getSize() == Size.MEDIUM){
			return basePrice + sizeUpPrice;
		}else if(getSize() == Size.LARGE) {
			return basePrice + sizeUpPrice*2;
		}
		
		return basePrice;
	}
}