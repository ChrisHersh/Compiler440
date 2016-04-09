package symboltable;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.SymbolTable;
import symboltable.Variable;
import symboltable.VariableScope;
import symboltable.VariableType;
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
		lpv.setValue("1", "id");
		assertEquals(lpv.getValue(), "1");
		lpv.setValue("2", "id");
		assertEquals(lpv.getValue(), "2");
		lpv.setValue("true", "id");
		assertEquals(lpv.getValue(), "2");
		
		LocalPrimitiveVariable lpv2 = new LocalPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.BOOLEAN);
		lpv2.setValue("true", "id");
		assertEquals(lpv2.getValue(), "true");
		lpv2.setValue("1", "id");
		assertEquals(lpv2.getValue(), "true");
		lpv2.setValue("false", "id");
		assertEquals(lpv2.getValue(), "false");
		
		LocalObjectVariable obj = new LocalObjectVariable("Name", "ClassName", "id", "MethodName", VariableScope.LOCAL, VariableType.OBJECT);
		obj.setValue("idk", "id");
		assertEquals(obj.getValue(), "idk");
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


	@Test
	public void testIfVaribleIsInMethod()
	{
		//Proudly stolen from above
		LocalPrimitiveVariable lpv = new LocalPrimitiveVariable("local", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.INTEGER);
		InstancePrimitiveVariable ipv = new InstancePrimitiveVariable("instance", "ClassName", VariableScope.INSTANCE, VariableType.BOOLEAN);
		MethodPrimitiveVariable mpv = new MethodPrimitiveVariable("parameter", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		
		LocalPrimitiveVariable lpv_class2 = new LocalPrimitiveVariable("local2", "ClassName2", "MethodName", VariableScope.LOCAL, VariableType.INTEGER);
		
		//Each variable name has it's own list, this should get much cleaner once we have an insertion method
		ArrayList<Variable> local = new ArrayList<Variable>();
		local.add(lpv);
		ArrayList<Variable> ins = new ArrayList<Variable>();
		ins.add(ipv);
		ArrayList<Variable> para = new ArrayList<Variable>();
		para.add(mpv);
		ArrayList<Variable> local2 = new ArrayList<Variable>();
		local2.add(lpv_class2);
		
		SymbolTable symbol = SymbolTable.getInstance();
		symbol.getVariableTable().put(lpv.getName(), local);
		symbol.getVariableTable().put(ipv.getName(), ins);
		symbol.getVariableTable().put(mpv.getName(), para);
		symbol.getVariableTable().put(lpv_class2.getName(), local2);
		
		assertTrue(symbol.checkIfVariableIsInMethod("local", "MethodName", "ClassName"));
		assertTrue(symbol.checkIfVariableIsInMethod("parameter", "MethodName", "ClassName"));
		
		//Should fail, it's an instance variable
		assertFalse(symbol.checkIfVariableIsInMethod("instance", "MethodName", "ClassName"));
		
		//Should fail, it's in a different class
		assertFalse(symbol.checkIfVariableIsInMethod("local2", "MethodName", "ClassName"));
	}
	
	/**
	 * Test to see if an operation can be done between two variables
	 * @author TJ Renninger
	 */
	@Test
	public void testOperations()
	{
		// Integers
		LocalPrimitiveVariable i = new LocalPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.INTEGER);
		// Boolean
		LocalPrimitiveVariable b = new LocalPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.BOOLEAN);
		// Object
		LocalPrimitiveVariable o = new LocalPrimitiveVariable("Name", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.OBJECT);

		//INTEGER
		assertTrue(i.isValidOperation(i, "+")); //Valid
		assertFalse(i.isValidOperation(i, "&&")); //Invalid by operation
		assertFalse(i.isValidOperation(b, "+")); //Invalid by type mismatch
		
		//BOOLEAN
		assertTrue(b.isValidOperation(b, "||")); //Valid
		assertFalse(b.isValidOperation(b, "+")); //Invalid by operation
		assertFalse(b.isValidOperation(i, "||")); //Invalid by type mismatch
		
		//OBJECT
		assertFalse(o.isValidOperation(o, "+")); //Invalid because objects are not allowed to have operations yet
	}
}
