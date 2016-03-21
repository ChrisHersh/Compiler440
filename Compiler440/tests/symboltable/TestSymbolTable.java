package symboltable;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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

}
