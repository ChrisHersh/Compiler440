package intermediate.process;

import java.util.ArrayList;

import org.junit.Test;

import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestProcessSTMT_P {

	@Test
	public void testProcessPass3()
	{		
		
		Token t1 = new Token(TokenTypes.STMT_P.name(), 1, null);
		Token t2 = new Token(TokenTypes.STMT.name(), 1, null);
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		
		Token t3 = new Token(TokenTypes.STMT_P.name(), 1, tkns);
		ProcessSTMT_P.processPass3(t3);
		
	}
	
}
