public class Renninger 
{
	int data;

	String name;

	public void nameMethod()
	{

	}

	public int dataMethod()
	{
		int result = 0;
		for (int x=0;x<name.length();x++)
		{
			result = name.charAt(x) + result;
		}
		data = result % name.length();
		return result;
	}

	@Override
	public String toString()
	{
		return name + data;
	}
}
