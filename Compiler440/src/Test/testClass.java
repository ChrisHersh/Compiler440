
package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.variable.impl.InstancePrimitiveVariable;
import symboltable.Class;
import symboltable.Method;
import symboltable.Variable;
import symboltable.VariableScope;
import symboltable.VariableType;


/**
 * The Testclass to test classes 
 * @author Michael Zimmerman
 * 
 */
public class testClass {
	
	/**
	 * Tests to see if instance variables of a superclass are able to be touched
	 */
	@Test
	public void testSuperClassInstanceVariables() 
	{
		ArrayList<Method> methodSet1 = new ArrayList <Method>();
		ArrayList<Method> methodSet2 = new ArrayList <Method>();
		
		ArrayList<InstancePrimitiveVariable> varSet1 = new ArrayList <InstancePrimitiveVariable>();
		ArrayList<InstancePrimitiveVariable> varSet2 = new ArrayList <InstancePrimitiveVariable>();
		
		InstancePrimitiveVariable ipv1 = new InstancePrimitiveVariable("Name1", "cla1", VariableScope.INSTANCE, VariableType.BOOLEAN);
		InstancePrimitiveVariable ipv2 = new InstancePrimitiveVariable("Name2", "cla2", VariableScope.INSTANCE, VariableType.INTEGER);
		
		varSet1.add(ipv1);
		varSet2.add(ipv2);
		
		Class cla1 = new Class("Name1", methodSet1, varSet1 , null );
		Class cla2 = new Class("Name2", methodSet2, varSet2 , cla1);
		
		assertTrue(cla1.getVars().get(0).getName() == "Name1");
		assertTrue(cla2.getVars().get(0).getName() == "Name2");
		assertTrue(cla2.getVars().get(1).getName() == "Name1");
	}
	
	/**
	 * Test the extension when there is no extension
	 * and check the name
	 * @author Shannon Jones 
	 */
	@Test
	public void testExtensionWhenFalse() {
		Class cl = new Class("name", null, null, null);
		assertFalse(cl.checkExtension());
		assertEquals("name", cl.getName());
	}
	
	/**
	 * Test to check that the class is keeping track of what is being extended
	 * and check the name
	 * @author Shannon Jones
	 */
	@Test
	public void testExtensionWhenTrue()
	{
		Class cl = new Class("name", null, null, null);
		Class cl2 = new Class("name2",null, null, cl);
	
		assertFalse(cl.checkExtension());
		assertEquals(null, cl.getExtention());
		assertEquals("name", cl.getName());
		
		assertTrue(cl2.checkExtension());
		assertEquals(cl, cl2.getExtention());
		assertEquals("name2", cl2.getName());
	}
}
