package tokenizer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTokenTypes {
	
	private final int TOKEN_AMOUNT = 76; // 45 Terminals, 31 Non-terminals
	
	@SuppressWarnings("unused") // Ignoring the warning for non using type. No other way to test.
	@Test
	public void testTokenAmounts() {
		int amount = 0;
		for(TokenTypes type : TokenTypes.values()) 
		{
			amount++;
		}
		assertEquals(TOKEN_AMOUNT, amount);
	}

}
