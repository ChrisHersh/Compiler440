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
	
	private SymbolTable symbolTable;
	
    // Mapping from name to list of all variables with that name.
	private HashMap<String, ArrayList<Variable>> table;
	
	private SymbolTable() 
	{
		table = new HashMap<String, ArrayList<Variable>>();
	}

    /**
     * Add a variable list to the hash table.
     * @param key
     * @param list
     */
    public void addToTable(String key, ArrayList<Variable> list) 
    {
    	table.put(key, list);
    }
    
    /**
     * Remove a variable list from the hash table.
     * @param key
     */
    public void removeFromTable(String key) 
    {
    	table.remove(key);
    }
    
    /**
     * Update a variable list in the hash table.
     * @param key
     * @param list
     */
    public void updateObjectInTable(String key, ArrayList<Variable> list) 
    {
    	table.replace(key, list);
    }
    
    /**
     * @return singleton of SymbolTable
     */
    public SymbolTable getInstance() 
    {
    	if(symbolTable == null) 
    	{
    		symbolTable = new SymbolTable();
    	}
    	return symbolTable;
    }
   

}
