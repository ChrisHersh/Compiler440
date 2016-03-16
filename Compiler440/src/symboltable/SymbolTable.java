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
