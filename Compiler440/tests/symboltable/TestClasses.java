package symboltable;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.sun.java.util.jar.pack.Package.Class.Method;

import symboltable.variable.impl.InstancePrimitiveVariable;

/**
 * The Testclass to test classes 
 * @author Michael Zimmerman
 *
 */
public class TestClasses {
	
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
}
