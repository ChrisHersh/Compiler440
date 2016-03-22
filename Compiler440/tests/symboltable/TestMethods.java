package tests.symboltable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.VariableScope;
import symboltable.VariableType;
import symboltable.method.impl.PublicMethod;
import symboltable.variable.impl.InstancePrimitiveVariable;
import symboltable.variable.impl.MethodObjectVariable;
import symboltable.variable.impl.MethodPrimitiveVariable;


/**
 * /**
 * Tests the children of the abstract object Method.
 * @author Curtis Rabe
 *
 */
public class TestMethods
{

	/**
	 * Tests the initialization of a method object.
	 */
	@Test
	public void testMethodChildrenInitialization()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);
		MethodObjectVariable mov3 = new MethodObjectVariable("Name", "ClassName", "id", "MethodName", VariableScope.METHOD, VariableType.OBJECT);

		ArrayList<Variable> params = new ArrayList <Variable>();
		params.add(mpv1);
		params.add(mpv2);
		params.add(mov3);

		Class cl1 = new Class("Class",null, null, null);
		PublicMethod pm = new PublicMethod("Name", cl1, VariableType.INTEGER, params);
		assertTrue(pm.getParams().contains(mpv1));
		assertTrue(pm.getParams().contains(mpv2));
		assertTrue(pm.getParams().get(2).equals(mov3));

	}
	/**
	 * Test that the return type for methods works
	 * @author Daniel Breitigan
	 */
	@Test
	public void testMethodReturnType()
	{
	    MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
        MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);  
        assertTrue(mpv1.getType() == VariableType.INTEGER);
        assertTrue(mpv2.getType() == VariableType.BOOLEAN);
	}
	
	/**
	 * Tests that the parameters are in order ( Mike says its not needed (really, its superfluous) )
	 */
	@Test
	public void testMethodParamOrder()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);

		ArrayList<Variable> params = new ArrayList <Variable>();
		params.add(mpv1);
		params.add(mpv2);
		Class cl1 = new Class("Class",null, null, null);
		PublicMethod pm = new PublicMethod("Name", cl1, VariableType.INTEGER, params);
		assertTrue(pm.getParams().get(0).equals(mpv1));
		assertTrue(pm.getParams().get(1).equals(mpv2));
		
	}
	
	/**
	 * Tests to make sure method inheritance works
	 */
	@Test
	public void testMethodInheritance()
	{
		/*
		 * Method has no grandparents
		 */
		ArrayList<InstancePrimitiveVariable> v = new ArrayList<InstancePrimitiveVariable>();
		InstancePrimitiveVariable ipv = new InstancePrimitiveVariable("Name", "ClassName", VariableScope.INSTANCE, VariableType.BOOLEAN);
		v.add(ipv);
		
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);
		ArrayList<Variable> params = new ArrayList <Variable>();
		params.add(mpv1);
		params.add(mpv2);
		
		ArrayList<Method> m = new ArrayList<Method>();
		Class cl = new Class("TestClass",m,v,null);
		PublicMethod m1 = new PublicMethod("TestMethod",cl,VariableType.INTEGER,null);
		m.add(m1);
		
		assertEquals(null,m1.getGrandParent());
		
		/*
		 * Method has a grandparent
		 */
		Class cl1 = new Class("Parent", m, v, null);
		Class cl2 = new Class("ClassWithGP",null, null, cl1);
		cl2.setExtention(cl1);	//This should be removed after Class revisions
		m = new ArrayList<Method>();
		PublicMethod m2 = new PublicMethod("TestMethod22",cl2,VariableType.INTEGER,null);
		m.add(m2);
		
		assertEquals(cl1,m2.getGrandParent());
	}
	
	/**
	 * Tests that parameter validation handles comparison of parameters
	 */
	@Test
	public void testValidParameters()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);
		
		ArrayList<Variable> params = new ArrayList <Variable>();
		params.add(mpv1);
		params.add(mpv2);
		Class cl1 = new Class("Class",null, null, null);
		PublicMethod pm = new PublicMethod("Name", cl1, VariableType.INTEGER, params);
		
		ArrayList<Variable> params2 = new ArrayList <Variable>();
		params2.add(mpv1);
		params2.add(mpv2);
		
		assertTrue(pm.validParameters(params));
	}
	
	/**
	 * Tests that parameter validation handles incorrect parameter count
	 */
	@Test
	public void testInvalidParameterCount()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);
		MethodPrimitiveVariable mpv3 = new MethodPrimitiveVariable("Name3", "ClassName", "MethodName", VariableScope.METHOD, VariableType.OBJECT);
		
		ArrayList<Variable> params1 = new ArrayList <Variable>();
		params1.add(mpv1);
		params1.add(mpv2);
		Class cl1 = new Class("Class",null, null, null);
		PublicMethod pm1 = new PublicMethod("Name", cl1, VariableType.INTEGER, params1);
		
		ArrayList<Variable> params2 = new ArrayList <Variable>();
		params2.add(mpv3);
		
		assertFalse(pm1.validParameters(params2));
	}
	
	/**
	 * Tests that parameter validation handles incorrect parameter ordering
	 */
	@Test
	public void testInvalidParameterOrder()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);
		
		ArrayList<Variable> params1 = new ArrayList <Variable>();
		params1.add(mpv1);
		params1.add(mpv2);
		Class cl1 = new Class("Class",null, null, null);
		PublicMethod pm1 = new PublicMethod("Name", cl1, VariableType.INTEGER, params1);
		
		ArrayList<Variable> params2 = new ArrayList <Variable>();
		params2.add(mpv2);
		params2.add(mpv1);

		assertFalse(pm1.validParameters(params2));
	}
	
	/**
	 * Tests that parameter validation handles incorrect parameter type
	 */
	@Test
	public void testInvalidParameters()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);
		MethodPrimitiveVariable mpv3 = new MethodPrimitiveVariable("Name3", "ClassName", "MethodName", VariableScope.METHOD, VariableType.OBJECT);
		MethodPrimitiveVariable mpv4 = new MethodPrimitiveVariable("Name4", "ClassName", "MethodName", VariableScope.METHOD, VariableType.OBJECT);
		
		ArrayList<Variable> params1 = new ArrayList <Variable>();
		params1.add(mpv1);
		params1.add(mpv2);
		Class cl1 = new Class("Class",null, null, null);
		PublicMethod pm1 = new PublicMethod("Name", cl1, VariableType.INTEGER, params1);
		
		ArrayList<Variable> params2 = new ArrayList <Variable>();
		params2.add(mpv3);
		params2.add(mpv4);

		assertFalse(pm1.validParameters(params2));
	}

    /**
     * Tests whether the getter well gets the name
     */
    @Test
    public void testMethodParamOrder()
    {
        String test = "Name";
        PublicMethod pm = new PublicMethod("Name", "Class", VariableType.INTEGER, params);
        assertTrue(test.equals(pm.getMethodName()));
    }

    /**
     * Tests whether the setter well sets the name
     */
    @Test
    public void testMethodParamOrder()
    {
        String test = "TestName";
        PublicMethod pm = new PublicMethod("Name", "Class", VariableType.INTEGER, params);
        pm.setMethodName("TestName");
        assertTrue(test.equals(pm.getMethodName()));
    }

}

//Mike Zimmerman added a comment
//I am Curtis Rabe, and I approve of this message.