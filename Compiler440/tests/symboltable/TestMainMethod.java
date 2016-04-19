package symboltable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import symboltable.method.impl.MainMethod;
/**
 * Test main method
 * @author Jared Good
 *
 */

public class TestMainMethod {
	
	/**
	 * Tests creating the main method
	 */
	@Test
	public void testMainMethod()
    {
		
		Class testClass = new Class("Test", null);
		
		//Tests that the main method is created properly
		assertNotNull(MainMethod.getInstance(testClass));
		
		MainMethod mainMethod = MainMethod.getInstance(testClass);
		
		//Tests that the class of the main method is in the class it is supposed to be in
		assertEquals( testClass.getName(), mainMethod.getClassName() );
		
		//Tests that main method is named as such
		assertEquals( "main", mainMethod.getMethodName() );

    }
	
}

