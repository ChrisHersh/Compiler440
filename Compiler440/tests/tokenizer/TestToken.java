package tokenizer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestToken {
	
    /**
     * Test to make sure the Token class's getters work correctly
     * Note: this is mainly for test coverage
     */
    @Test
    public void testToken()
    {
    	Token token = new Token("name", "NAME", 1);

        assertEquals(token.getToken(), "name");
        assertEquals(token.getTokenName(), "NAME");
        assertEquals(token.getLineNumber(), 1);
        assertEquals(token.getChildren().size(), 0);
        
    }

    /**
     * Makes sure the reduce tokens method works correctly
     */
    @Test
    public void testReduceTokens()
    {
        Token t1 = new Token("Name1", "name1", 5);
        Token t2 = new Token("Name2", "name2", 2);
        Token t3 = new Token("Name3", "name3", 6);
        
        ArrayList<Token> children = new ArrayList<Token>();
        children.add(t1);
        children.add(t2);
        children.add(t3);
        
        Token newT = Token.reduceTokens(children, TokenTypes.EXP7);
        assertEquals(newT.lineNumber, 2);
        assertEquals(newT.childTokens, children);
        assertEquals(newT.tokenName, TokenTypes.EXP7.name());
    }

}
