package symboltable.method.impl;

import symboltable.Class;
import symboltable.Method;
/**
 * Main Method
 * @author Jared Good
 *
 */
public class MainMethod extends Method
{
	private static MainMethod mainMethod;
	
	/**
	 * @param className the name of the class in which main method is located
	 * @param params the parameters of main method
	 */
	private MainMethod(Class className)
	{
		super("main", className, null, null);
	}
	
	/**
	 * If there is no main method it is created with the given Class, 
	 * otherwise it returns the already existing main method
	 * @param className the name of the class in which main method is located
	 * @param params the parameters of main method
     * @return singleton of SymbolTable
     */
	public static MainMethod getInstance(Class className) 
    {
    	if(mainMethod == null) 
    	{
    		mainMethod = new MainMethod(className);
    	}
    	return mainMethod;
    }
	
}
