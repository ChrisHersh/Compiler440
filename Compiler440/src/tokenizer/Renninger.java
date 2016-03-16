package tokenizer;
public class Renninger 
{
	int data;

	String name;

	public void nameMethod(String value)
	{
		name = value.substring(1);
	}

	public int dataMethod()
	{
		int x = 0;
		int result = 0;
		while(x<name.length())
		{
			result = name.charAt(x) + result;
			x++;
		}
		data = result % name.length();
		return result;
	}

	@Override
	public String toString()
	{
		String fancyName = "X "+name+" X";
		return fancyName+" : "+data;
	}
}
