package parser.states;

public class Schlesiger { 
	int data;
	String name;
	public void nameMethod(String value) {
		name = value.substring(1);
	}
	
	public int dataMethod() {
		int result = 0;
		int x=0;
		while(x<name.length()) {
			data = name.charAt(x) * result;
			x++;
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
