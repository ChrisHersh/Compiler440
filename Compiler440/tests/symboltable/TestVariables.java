package symboltable;

import static org.junit.Assert.*;

import org.junit.Test;

import symboltable.variable.impl.InstanceObjectVariable;
import symboltable.variable.impl.InstancePrimitiveVariable;
import symboltable.variable.impl.LocalObjectVariable;
import symboltable.variable.impl.LocalPrimitiveVariable;
import symboltable.variable.impl.MethodObjectVariable;
import symboltable.variable.impl.MethodPrimitiveVariable;

/**
 * Tests the children of the abstract object Variable.
 * @author Ian Keefer (and Curtis Rabe)
 */
public class TestVariables {
	
	/**
	 * Tests the initialization of a variable object.
	 */
	@Test
	public void testVariableChildrenInitialization() {
		LocalPrimitiveVariable lpv = new LocalPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.INTEGER);
		LocalObjectVariable lov = new LocalObjectVariable("Name", "ClassName", "id", "MethodName", VariableScope.LOCAL, VariableType.OBJECT);
		InstancePrimitiveVariable ipv = new InstancePrimitiveVariable("Name", "ClassName", VariableScope.INSTANCE, VariableType.BOOLEAN);
		InstanceObjectVariable iov = new InstanceObjectVariable("Name", "ClassName", "id", VariableScope.INSTANCE, VariableType.OBJECT);
		//added by Curtis Rabe
		MethodPrimitiveVariable mpv = new MethodPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodObjectVariable mov = new MethodObjectVariable("Name", "ClassName", "id", "MethodName", VariableScope.METHOD, VariableType.OBJECT);

		
		assertEquals(lpv.getName(), "Name");
		assertEquals(lpv.getClassName(), "ClassName");
		assertEquals(lpv.getMethodName(), "MethodName");
		assertEquals(lpv.getId(), "");
		assertEquals(lpv.getScope(), VariableScope.LOCAL);
		assertEquals(lpv.getType(), VariableType.INTEGER);
		
		assertEquals(lov.getName(), "Name");
		assertEquals(lov.getClassName(), "ClassName");
		assertEquals(lov.getMethodName(), "MethodName");
		assertEquals(lov.getId(), "id");
		assertEquals(lov.getScope(), VariableScope.LOCAL);
		assertEquals(lov.getType(), VariableType.OBJECT);
		
		assertEquals(ipv.getName(), "Name");
		assertEquals(ipv.getClassName(), "ClassName");
		assertEquals(ipv.getMethodName(), "");
		assertEquals(ipv.getId(), "");
		assertEquals(ipv.getScope(), VariableScope.INSTANCE);
		assertEquals(ipv.getType(), VariableType.BOOLEAN);
		
		assertEquals(iov.getName(), "Name");
		assertEquals(iov.getClassName(), "ClassName");
		assertEquals(iov.getMethodName(), "");
		assertEquals(iov.getId(), "id");
		assertEquals(iov.getScope(), VariableScope.INSTANCE);
		assertEquals(iov.getType(), VariableType.OBJECT);
		
		//Tests and fragrance by Curtis Rabe
		assertEquals(mpv.getName(), "Name");
		assertEquals(mpv.getClassName(), "ClassName");
		assertEquals(mpv.getMethodName(), "MethodName");
		assertEquals(mpv.getId(), "");
		assertEquals(mpv.getScope(), VariableScope.METHOD);
		assertEquals(mpv.getType(), VariableType.INTEGER);
		
		assertEquals(mov.getName(), "Name");
		assertEquals(mov.getClassName(), "ClassName");
		assertEquals(mov.getMethodName(), "MethodName");
		assertEquals(mov.getId(), "id");
		assertEquals(mov.getScope(), VariableScope.METHOD);
		assertEquals(mov.getType(), VariableType.OBJECT);
	}
	
	
	/**
	 * Tests for allowable values to be assigned.
	 */
	@Test
	public void testVariableTypeForAssignment() {
		LocalPrimitiveVariable lpv = new LocalPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.INTEGER);
		lpv.setValue("1");
		assertEquals(lpv.getValue(), "1");
		lpv.setValue("2");
		assertEquals(lpv.getValue(), "2");
		lpv.setValue("true");
		assertEquals(lpv.getValue(), "2");
		
		LocalPrimitiveVariable lpv2 = new LocalPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.BOOLEAN);
		lpv2.setValue("true");
		assertEquals(lpv2.getValue(), "true");
		lpv2.setValue("1");
		assertEquals(lpv2.getValue(), "true");
		lpv2.setValue("false");
		assertEquals(lpv2.getValue(), "false");
	}

	
	/**
	 * Tests datatypes with valid/invalid operators
	 * If an invalid operator is entered it will default to false
	 * If a data type other than INTEGER, BOOLEAN or OBJECT is entered, it will default to false
	 * @author Jessica Schlesiger
	 */
	@Test
	public void testOperators() {
		
		// Integers
		LocalPrimitiveVariable lpv = new LocalPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.INTEGER);
		assertTrue(lpv.validOperator("+"));
		assertTrue(lpv.validOperator("-"));
		assertTrue(lpv.validOperator("/"));
		assertTrue(lpv.validOperator("*")); 
		assertTrue(lpv.validOperator(">"));
		assertTrue(lpv.validOperator("<"));
		assertTrue(lpv.validOperator(">="));
		assertTrue(lpv.validOperator("<="));
		assertTrue(lpv.validOperator("=="));
		assertTrue(lpv.validOperator("!="));

		assertFalse(lpv.validOperator("&&"));
		assertFalse(lpv.validOperator("!"));
		assertFalse(lpv.validOperator("||"));
		
		// Boolean
		lpv = new LocalPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.BOOLEAN);
		assertTrue(lpv.validOperator("||"));
		assertTrue(lpv.validOperator("&&"));
		assertTrue(lpv.validOperator("!"));
		
		assertFalse(lpv.validOperator("=="));
		assertFalse(lpv.validOperator("!="));
		assertFalse(lpv.validOperator("+"));
		assertFalse(lpv.validOperator("-"));
		assertFalse(lpv.validOperator("/")); 
		assertFalse(lpv.validOperator("*"));
		assertFalse(lpv.validOperator(">"));
		assertFalse(lpv.validOperator("<"));
		assertFalse(lpv.validOperator(">="));
		assertFalse(lpv.validOperator("<="));
		
		// Object
		lpv = new LocalPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.OBJECT);
		assertFalse(lpv.validOperator("=="));
		assertFalse(lpv.validOperator("!="));		
		assertFalse(lpv.validOperator("||"));
		assertFalse(lpv.validOperator("&&"));
		assertFalse(lpv.validOperator("!"));
		assertFalse(lpv.validOperator("+"));
		assertFalse(lpv.validOperator("-"));
		assertFalse(lpv.validOperator("/"));
		assertFalse(lpv.validOperator("*"));
		assertFalse(lpv.validOperator(">"));
		assertFalse(lpv.validOperator("<"));
		assertFalse(lpv.validOperator(">="));
		assertFalse(lpv.validOperator("<="));
	}

}