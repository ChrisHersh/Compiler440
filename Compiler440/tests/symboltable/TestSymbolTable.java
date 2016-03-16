package symboltable;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Ian Keefer
 */
public class TestSymbolTable {

	/**
	 * Test the initialization of a symbol table.
	 */
	@Test
	public void testInitialization() {
		assertNotNull(SymbolTable.getInstance());
		assertNotNull(SymbolTable.getInstance().getTable());
	}

}
