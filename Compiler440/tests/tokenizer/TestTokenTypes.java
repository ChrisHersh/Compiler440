package tokenizer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTokenTypes {
	
    private final int terminals = 45;
    private final int non_terminals = 31;
    private final int epsilon = 1;
	private final int TOKEN_AMOUNT = terminals + non_terminals + epsilon; // 45 Terminals, 31 Non-terminals, 1 epsilon
	
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
