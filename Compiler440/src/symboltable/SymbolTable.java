package symboltable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Symbol table that our compiler will use.
 * @author Chris Hersh, Ian Keefer, Mike Zimmerman
 *
 */
public class SymbolTable
{
	
	private static SymbolTable symbolTable;
	
    // Mapping from name to list of all variables with that name.
	private HashMap<String, ArrayList<Variable>> variableTable;
	private HashMap<String, ArrayList<Method>> methodTable;
	//added by Mike Zimmerman to store classes in symbol table
	private HashMap<String, Class> classTable;
	
	/**
	 * Constructor for the symbol table. Initializes the different hashmaps to being empty
	 */
	private SymbolTable() 
	{
		variableTable = new HashMap<String, ArrayList<Variable>>();
		methodTable = new HashMap<String, ArrayList<Method>>();
		classTable = new HashMap<String, Class>();
	}
	
	/**
	 * Checks to see if the variable table is empty
	 * @return true if the variable table is empty, false if it is not empty
	 */
	public boolean variableTableIsEmpty()
	{
		return variableTable.isEmpty();
	}
	
	/**
	 * Checks to see if the method table is empty
	 * @return true if the method table is empty, false if it is not empty
	 */
	public boolean methodTableIsEmpty()
	{
		if(methodTable.isEmpty())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	/**
	 * Checks to see if the class table is empty
	 * @return true if the class table is empty, false if it is not empty
	 */
	public boolean classTableIsEmpty()
	{
		if(classTable.isEmpty())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	
	/**
	 * Add a method to the methodTable of the symboltable
	 * 		NOTE: This ALSO adds the variables from the method parameters if they exist
	 * @param key - the key that refers to the method
	 * @param m - the variable holding the created method
	 */
	public void addMethod(String key, Method m)
	{
		if( methodTable.containsKey(key) )
		{
			methodTable.get(key).add(m);
			for(int i = 0; i<m.getParams().size(); i++)
			{
				addVariable(m.getParams().get(i).getName(), m.getParams().get(i));
			}
		}
		else
		{
			ArrayList<Method> am = new ArrayList<Method>();
			am.add(m);
			methodTable.put(key, am);
			for(int i = 0; i<m.getParams().size(); i++)
			{
				addVariable(m.getParams().get(i).getName(), m.getParams().get(i));
			}
		}
	}
	
	/**
	 * @param key - the key (name) referring to the variable
	 * @return the list of variables with the same name
	 */
	public ArrayList<Variable> getVariableList(String key) 
	{
		return variableTable.get(key);
	}
	
	/**
	 * @param key - the key (name) referring to the method
	 * @return the list of methods with the same name
	 */
	public ArrayList<Method> getMethodList(String key) 
	{
		return methodTable.get(key);
	}
	
	/**
	 * @param key - the key (name) referring to the class
	 * @return the list of classes with the same name
	 */
	public Class getClass(String key) 
	{
		return classTable.get(key);
	}
	
	/**
	 * Add a variable to the variableTable of the symboltable
	 * @param key - the key that refers to the variable
	 * @param v - the variable holding the created Variable
	 */
	public void addVariable(String key, Variable v)
	{
		if( variableTable.containsKey(key) )
		{
			variableTable.get(key).add(v);
		}
		else
		{
			ArrayList<Variable> av = new ArrayList<Variable>();
			av.add(v);
			variableTable.put(key, av);
		}
	}
	
	
	/**
	 * Add a class to the classTable of the symboltable
	 * @param key - the key that refers to the class
	 * @param m - the variable holding the created class
	 */
	public void addClass(String key, Class c)
	{
		if( classTable.containsKey(key) )
		{
			//some sort of exception
		}
		else
		{
			classTable.put(key, c);
		}
	}
	
/**
 * Should not be returning the actual data structures. This way we can avoid accessing
 * them directly in the test
 */


	/**
     * @return singleton of SymbolTable
     */
    public static SymbolTable getInstance() 
    {
    	if(symbolTable == null) 
    	{
    		symbolTable = new SymbolTable();
    	}
    	return symbolTable;
    }
   
    /**
     * 
     * @param varName the name of the variable
     * @param methodName the name of the method
     * @param className the name of the class
     * @return true of false if the variable is in the method
     */
    public boolean checkIfVariableIsInMethod(String varName, String methodName, String className)
    {
    	ArrayList<Variable> varList = variableTable.get(varName);
    	for(Variable v : varList)
    	{
    		if( (v.getMethodName().equals(methodName) && v.getClassName().equals(className)) && 
    				(v.getScope() == VariableScope.METHOD || v.getScope() == VariableScope.LOCAL) )
    		{
    			return true;
    		}
    	}
    	return false;
    }

}
