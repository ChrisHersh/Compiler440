package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.AddMainMethod;
import symboltable.Method;
import symboltable.VariableType;
/**
 *  Test Add Main Method.
 * @author Mohammad Alharbi
 *
 */

public class TestMainMethod {
	
	
	ArrayList<Method> methodList = new ArrayList<Method>();
	AddMainMethod amm = new AddMainMethod();
	/** add method name as main */
	 @Test
	    public void testAddMethod1()
	    {
	        
		 	methodList.add(amm.createMethod("main","abstract",VariableType.OBJECT,null));
	        assertEquals(methodList.get(0).getMethodName(), "main");
	    }
}

