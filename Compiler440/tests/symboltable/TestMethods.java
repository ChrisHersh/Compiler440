package symboltable;
import static org.junit.Assert.*;

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

}

//Mike Zimmerman added a comment
//I am Curtis Rabe, and I approve of this message.