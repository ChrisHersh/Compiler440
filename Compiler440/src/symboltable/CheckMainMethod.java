package symboltable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import symboltable.AddMainMethod;
import symboltable.Method;
import symboltable.VariableType;
/**
 *  Check for Main Method ... 
 * @author Manal Ibrahim
 *
 */

public class CheckMainMethod{

	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		ArrayList<Method> methodList = new ArrayList<Method>();
		AddMainMethod amm = new AddMainMethod();
		
		/**
		 * uncomment below code to see error 
		 * 
		 *  @ methodList.add(amm.createMethod("main","abstract",VariableType.VOID,null));
 		 *  @ amm.addTable(methodList,"1");
 		 *  @ methodList.add(amm.createMethod("main","abstract",VariableType.VOID,null));
 		 *  @ amm.addTable(methodList,"1");
 		 *  
 		 ***/
		
		
		HashMap<String, ArrayList<Method>> map = amm.getTable();// get symbol table
	 	int counter = 0;
	 	boolean result = true;
	 	
	 	         /** get symbol table map */
	 	
	 	 for (Entry<String, ArrayList<Method>> entry : map.entrySet()) {
	 		    
	 		    /** get method list */
	 		 
	        	ArrayList<Method> var = entry.getValue();
	        	 for (Method vari : var){
	            if (vari.getMethodName().equalsIgnoreCase("main"))
	            	
	            	/** count how many "main" method in symbol table..
	            	 *  if there will more than one main method then 
	            	 *  "counter" will be increase
	            	 *  if more than one main method, checking print error massage
	            	 *  if there is no Main method, add Main Method + add it to symbol table + print added massage
	            	 *  if is one main method, print it is already exist
	            	 * */
	            	counter++;
	        	 }
	        	 
	        }
	 	 			/** if more than one main method, test will be fail*/
	 	 		
	 	 		if(counter > 1)
	 		          System.out.println("Error.");
	            else if(counter == 0)
				 	{
				 		methodList.add(amm.createMethod("main","abstract",VariableType.OBJECT,null));
				 		amm.addTable(methodList,"1");
				 		System.out.println("Main Method has been Added.");
				 	}
			 	else if(counter  == 1)
			 	{
			 		System.out.println("The main method already exist.");
			 	}
	 	
	}
}
