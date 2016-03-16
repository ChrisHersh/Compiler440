public class Renninger 
{
	int data;

	String name;

	public void nameMethod(String value)
	{
		name = value.substring(1);
	}

	public void dataMethod()
	{

	}

	@Override
	public String toString()
	{
		String fancyName = "X "+name+" X";
		return fancyName+" : "+data;
	}
}
