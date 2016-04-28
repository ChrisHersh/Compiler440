package intermediate.process;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Corey Peregord
 * Test class for EXP4
 *
 */
public class TestProcessOP4 {

	/**
	 * Test to validate that code is generated properly
	 * @Author Corey Peregord
	 */
	@Test
	public void testProcessPass3()
	{		
		Token t2 = new Token(TokenTypes.OP4.name(), 1, null);		

		Token.pass3(t2);
		
		assertEquals(t2.getCode().toString(), "OP4.getOperater()");
		
	}
	
}
