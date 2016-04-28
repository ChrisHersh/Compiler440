package intermediate.process;

import static org.junit.Assert.*;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Tests to make sure ProcessTYPE passes correctly.  
 * @author Jessica Schlesiger
 */
public class TestProcessTYPE {

	/**
	 * Test to validate that code is generated properly
	 * @Author Jessica Schlesiger
	 */
	@Test
	public void testProcessPass3()
	{		
		Token t2 = new Token(TokenTypes.TYPE.name(), 1, null);		

		Token.pass3(t2);
		
		assertEquals(t2.getCode().toString(), "TYPE.getType()");
		
	}

}
