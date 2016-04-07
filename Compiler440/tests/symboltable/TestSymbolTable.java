package symboltable;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.variable.impl.LocalObjectVariable;
import symboltable.variable.impl.LocalPrimitiveVariable;
import symboltable.variable.impl.MethodPrimitiveVariable;

/**
 * @author Ian Keefer (and Curtis Rabe)
 */
public class TestSymbolTable {

	/**
	 * Test the initialization of a symbol table.
	 */
	@Test
	public void testInitialization() {
		assertNotNull(SymbolTable.getInstance());
		assertNotNull(SymbolTable.getInstance().getVariableTable());
		//Added by Curtis Rabe
		assertNotNull(SymbolTable.getInstance().getMethodTable());
	}
	
	/**
	 * Test the storing of parameters from methods into the symbol table
	 */
	@Test
	public void testStoringParams()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		ArrayList<Variable> params = new ArrayList<Variable>();
		params.add(mpv1);
		SymbolTable.getInstance().getVariableTable().put(mpv1.getName(), params);
		assertEquals(mpv1, SymbolTable.getInstance().getVariableTable().get("Name1").get(0));
	}
	
	/**
	 * Test the order of parameters from methods being stored in the symbol table
	 */
	@Test
	public void testOrderParams()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		MethodPrimitiveVariable mpv2 = new MethodPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.METHOD, VariableType.BOOLEAN);
		ArrayList<Variable> params = new ArrayList<Variable>();
		params.add(mpv1);
		params.add(mpv2);
		SymbolTable.getInstance().getVariableTable().put("Method1", params);
		assertEquals(mpv1, SymbolTable.getInstance().getVariableTable().get("Method1").get(0));
		assertEquals(mpv2, SymbolTable.getInstance().getVariableTable().get("Method1").get(1));
	}
	
	/**
	 * Test the storing of parameters from methods into the symbol table
	 */
	@Test
	public void testStoringNoParams()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		ArrayList<Variable> params = new ArrayList<Variable>();
		//Note: No parameters added to "params"
		SymbolTable.getInstance().getVariableTable().put(mpv1.getName(), params);
		assertEquals(0, SymbolTable.getInstance().getVariableTable().get(mpv1.getName()).size());
	}
	
	/**
	 * Test the storing of variables into the symbol table
	 */
	@Test
	public void testStoringVars()
	{
		MethodPrimitiveVariable mpv1 = new MethodPrimitiveVariable("Name1", "ClassName", "MethodName", VariableScope.METHOD, VariableType.INTEGER);
		LocalPrimitiveVariable lpv1 = new LocalPrimitiveVariable("Name2", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.INTEGER);
		LocalPrimitiveVariable lpv2 = new LocalPrimitiveVariable("Name3", "ClassName", "MethodName", VariableScope.LOCAL, VariableType.INTEGER);
		LocalObjectVariable lov1 = new LocalObjectVariable("Name4", "ClassName", "id", "MethodName", VariableScope.LOCAL, VariableType.OBJECT);
		ArrayList<Variable> vars = new ArrayList<Variable>();
		vars.add(mpv1);
		vars.add(lpv1);
		vars.add(lpv2);
		vars.add(lov1);
		//passes in the method name and the list of variables within it
		SymbolTable.getInstance().getVariableTable().put("MethodName", vars);
		assertEquals(mpv1, SymbolTable.getInstance().getVariableTable().get("MethodName").get(0));
		assertEquals(lpv1, SymbolTable.getInstance().getVariableTable().get("MethodName").get(1));
		assertEquals(lpv2, SymbolTable.getInstance().getVariableTable().get("MethodName").get(2));
		assertEquals(lov1, SymbolTable.getInstance().getVariableTable().get("MethodName").get(3));
	}

}
