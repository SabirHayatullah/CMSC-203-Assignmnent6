public class Customer
{
	private String name;
	private int age;
	
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public Customer(Customer obj)
	{
		this.name = obj.name;
		this.age = obj.age;
	}
	
	public String toString()
	{
		String str = "Name: " + getName();
		str += "\nAge: " + getAge();
		return str;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getAge()
	{
		return this.age;
	}
}