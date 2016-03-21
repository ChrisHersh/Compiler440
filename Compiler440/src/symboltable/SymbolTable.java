package symboltable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Symbol table that our compiler will use.
 * @author Chris Hersh, Ian Keefer
 *
 */
public class SymbolTable
{
	
	private static SymbolTable symbolTable;
	
    // Mapping from name to list of all variables with that name.
	private HashMap<String, ArrayList<Variable>> table;
	private HashMap<String, ArrayList<Method>> tableMethod;
	
	private SymbolTable() 
	{
		table = new HashMap<String, ArrayList<Variable>>();
		tableMethod = new HashMap<String, ArrayList<Method>>();
	}
	
    /**
	 * @return the table
	 */
	public HashMap<String, ArrayList<Variable>> getTable() 
	{
		return table;
	}
	
	 /**
	 * @return the table
	 */
	public HashMap<String, ArrayList<Method>> getTableMethod() 
	{
		return tableMethod;
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
   

}
