package tests.symboltable;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import symboltable.Class;
import symboltable.Method;
import symboltable.Variable;
import symboltable.VariableScope;
import symboltable.VariableType;
import symboltable.method.impl.PublicMethod;
import symboltable.variable.impl.InstanceObjectVariable;
import symboltable.variable.impl.InstancePrimitiveVariable;
import symboltable.variable.impl.LocalObjectVariable;
import symboltable.variable.impl.LocalPrimitiveVariable;
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

		PublicMethod pm = new PublicMethod("Name", "Class", VariableType.INTEGER, params);
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
		PublicMethod pm = new PublicMethod("Name", "Class", VariableType.INTEGER, params);
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

}

//Mike Zimmerman added a comment
//I am Curtis Rabe, and I approve of this message.