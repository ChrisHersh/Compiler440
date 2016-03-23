package symboltable;

import java.util.ArrayList;
import java.util.HashMap;
/**
 *  Add Main Method.
 * @author Mohammad Alharbi
 *
 */
public class AddMainMethod {
	SymbolTable st = SymbolTable.getInstance();
	public Method createMethod(String name, String className, VariableType type, ArrayList<Variable> params)
	{
		Method main = new Method(name,className,type,params);
		return main;
	}
	/**
	 * add Main Method that is inserted into a symbol table.
	 * @author Mohammad Alharbi
	 *
	 */	
	public HashMap<String, ArrayList<Method>> addTable(ArrayList<Method> method,String id)
	{		
		st.add(id, method);
		return st.getMethodTable();
	}
	public HashMap<String, ArrayList<Method>> getTable()
	{
		return st.getMethodTable();
	}
	
}
