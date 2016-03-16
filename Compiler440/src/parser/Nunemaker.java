package parser;
public class Nunemaker {
	int data;
	String name;

	public void nameMethod(String value)
	{
	    name = value.substring(1);
	}

	public int dataMethod() {
		
		for (int x = 0; x < name.length(); x++)
		{
			data = name.charAt(x) + data;
		}
		data = data % name.length();
		return data;
	}

	@Override
	public String toString() {
		String fancyName = "X " + name + " X";
		return fancyName + " : " + data;
	}
}
