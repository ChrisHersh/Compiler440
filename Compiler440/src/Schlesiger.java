
public class Schlesiger {
	int data;
	String name;
	
	public void nameMethod(String value) {
		name = value.substring(1);
	}
	public void dataMethod() {
	
	}
	
	@Override
	public String toString() {
		return name+data;
	}
}
