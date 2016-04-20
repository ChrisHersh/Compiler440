package symboltable;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.method.impl.PublicMethod;
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
	public void testMethodVariableTypes()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);
		MethodObjectVariable mov3 = new MethodObjectVariable("Name", "ClassName", "id", "MethodName", VariableScope.METHOD, VariableType.OBJECT);

		ArrayList<Variable> params = new ArrayList <Variable>();
		params.add(mpv1);
		params.add(mpv2);
		params.add(mov3);

		Class cl1 = new Class("Class", null, null);
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
		Class cl1 = new Class("Class", null, null);
		PublicMethod pm = new PublicMethod("Name", cl1, VariableType.INTEGER, params);
		assertTrue(pm.getParams().get(0).equals(mpv1));
		assertTrue(pm.getParams().get(1).equals(mpv2));
		
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
		Class cl1 = new Class("Class", null, null);
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
		Class cl1 = new Class("Class",null, null);
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
		Class cl1 = new Class("Class", null, null);
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
		Class cl1 = new Class("Class",null, null);
		PublicMethod pm1 = new PublicMethod("Name", cl1, VariableType.INTEGER, params1);
		
		ArrayList<Variable> params2 = new ArrayList <Variable>();
		params2.add(mpv3);
		params2.add(mpv4);

		assertFalse(pm1.validParameters(params2));
	}

    /**
     * Tests whether the getter well gets the name
     * Method name changed by Curtis Rabe to eliminate errors
     * 			Also, changed test to run properly - added arrayList "params" and class "cl1"
     */
    @Test
    public void testGetMethodName()
    {
    	ArrayList<Variable> params = new ArrayList <Variable>();
    	Class cl1 = new Class("Class", null, null);
        String test = "Name";
        PublicMethod pm = new PublicMethod("Name", cl1, VariableType.INTEGER, params);
        assertTrue(test.equals(pm.getMethodName()));
    }

//TODO: Test method params with not initial variable, but same type
}
