package symboltable;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.variable.impl.InstancePrimitiveVariable;


/**
 * The Testclass to test classes 
 * @author Michael Zimmerman
 * 
 */
public class TestClasses {
	
	/**
	 * Tests to see if instance variables of a superclass are able to be touched
	 * Curtis Rabe - Not sure if this test is required. If so, it must be restructured
	 * because we are going toward a one way (bottom up) visibility approach
	 */
	@Test
	public void testSuperClassInstanceVariables()
	{		
		ArrayList<Variable> varSet1 = new ArrayList <Variable>();
		ArrayList<Variable> varSet2 = new ArrayList <Variable>();
		
		InstancePrimitiveVariable ipv1 = new InstancePrimitiveVariable("Name1", "cla1", VariableScope.INSTANCE, VariableType.BOOLEAN);
		InstancePrimitiveVariable ipv2 = new InstancePrimitiveVariable("Name2", "cla2", VariableScope.INSTANCE, VariableType.INTEGER);
		
		varSet1.add(ipv1);
		varSet2.add(ipv2);
		
		Class cla1 = new Class("Name1", varSet1, null );
		Class cla2 = new Class("Name2", varSet2, cla1);
		
		assertTrue(cla1.getInstanceVars().get(0).getName().equals("Name1"));
		assertTrue(cla2.getInstanceVars().get(0).getName().equals("Name2"));
		assertTrue(cla2.getInstanceVars().get(1).getName().equals("Name1"));
	}
	
	
	/**
	 * Test to check that the class is keeping track of what is being extended
	 * and check the name
	 * @author Shannon Jones, Curtis Rabe (edits)
	 */
	@Test
	public void testExtensionWhenTrue()
	{
		Class cl = new Class("name",null, null);
		Class cl2 = new Class("name2", null, cl);
		assertNull(cl.getExtention());
		assertEquals(null, cl.getExtention());
		assertEquals("name", cl.getName());
		
		assertEquals(cl, cl2.getExtention());
		assertEquals("name2", cl2.getName());
	}
	
	/**
	 * Test to make sure class name can be gotten
	 */
	@Test
	public void testClassName()
	{
		Class cl = new Class("name",null, null);
		assertEquals("name", cl.getName());
	}
}
