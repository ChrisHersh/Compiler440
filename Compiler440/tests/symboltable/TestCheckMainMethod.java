
 import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

import symboltable.AddMainMethod;
import symboltable.Method;
public class TestCheckMainMethod{
	/**
	 * Test Check for Main Method ... 
	 * @author Manal Ibrahim
	 *
	 */	
	
	ArrayList<Method> methodList = new ArrayList<Method>();
	AddMainMethod amm = new AddMainMethod();
	/*****
	 * check Main Method in symbol table
	 **/
	
	 @Test
	    public void testMainMethod()
	    {
		   /***** 
		     * add method list to symbol table
             **/
		 
		 	HashMap<String, ArrayList<Method>> map = amm.addTable(methodList,"1");
		 	int counter = 0;
		 	boolean result = true;
		 	/**
		 	 * get symbol table map 
		 	 **/
		 	
		 	 for (Entry<String, ArrayList<Method>> entry : map.entrySet()) {
		 		 /**
		 		  * get method list
		 		  * */
		 		 
		        	ArrayList<Method> var = entry.getValue();
		        	 for (Method vari : var){
		        		/**
		        		 * Count how many "main" method in symbol table
		        		 */
		        	       
		            if (vari.getMethodName().equalsIgnoreCase("main"))
		            	/**
		            	 *  if there will more than one main method then "counter" will be increase
		            	 */
		            	counter++; 
		        	 }
		        	 
		        }
		 	 /**
		 	  * if more than one main method, test will be fail
		 	  */
		 	if(counter > 1)
		 		result = false;
	        assertEquals(result, true);
	    }
}
	 