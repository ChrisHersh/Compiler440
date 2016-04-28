package intermediate.process;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Corey Peregord
 * Test class for ProcessOP3
 *
 */
public class TestProcessOP3 {

	/**
	 * Test to validate that code is generated properly
	 * @Author Corey Peregord
	 */
	@Test
	public void testProcessPass3()
	{		
		Token t2 = new Token(TokenTypes.OP3.name(), 1, null);		

		Token.pass3(t2);
		
		assertEquals(t2.getCode().toString(), "OP3.getOperater()");
		
	}
	
}
