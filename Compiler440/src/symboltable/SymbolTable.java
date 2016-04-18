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
	private HashMap<String, ArrayList<Class>> classTable;
	
	private SymbolTable() 
	{
		variableTable = new HashMap<String, ArrayList<Variable>>();
		methodTable = new HashMap<String, ArrayList<Method>>();
		classTable = new HashMap<String, ArrayList<Class>>();
	}
	
	/**
	 * Adds method to symboltable
	 */
	public void addMethod(String key, ArrayList<Method> m)
	{
		methodTable.put(key,m);
	}
	
	public void addMethod(String key, Method m)
	{
		if( methodTable.containsKey(key) )
		{
			methodTable.get(key).add(m);
		}
		else
		{
			ArrayList<Method> am = new ArrayList<Method>();
			am.add(m);
			methodTable.put(key, am);
		}
	}
	/**
	 * Adds variable to symboltable
	 */
	public void addVariable(String key, ArrayList<Variable> v)
	{
		variableTable.put(key,v);
	}
	
	/**
	 * Adds class to symboltable
	 */
	public void addClass(String key, ArrayList<Class> c)
	{
		classTable.put(key,c);
	}
    /**
	 * @return the table
	 */
	public HashMap<String, ArrayList<Variable>> getVariableTable() 
	{
		return variableTable;
	}
	
	 /**
	 * @return the table
	 */
	public HashMap<String, ArrayList<Method>> getMethodTable() 
	{
		return methodTable;
	}

	/**
	 * By Mike Zimmerman
	 * @return the table
	 */
	public HashMap<String, ArrayList<Class>> getClassTable()
	{
		return classTable;
	}

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
