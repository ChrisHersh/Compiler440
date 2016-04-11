package parser.states;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the MDJ_1 class.
 *
 */
public class TestMDJ_4 {
	
	
	    @Before
	    public void setUp()
	    {
	        Parser.resetParser();
	    }
	    
	    /**
	     * @author Mohammed
	     * Test the reduce to MDJ_3
	     * @throws ParserException
	     */
	    @Test
		public void testInvalidState() throws ParserException
		{
			Parser parser = Parser.getInstance();
			State state = new MDJ_26();
			ArrayList<Token> tokens = new ArrayList<Token>();
			tokens.add(new Token("class", TokenTypes.Class.name(),1));
			tokens.add(new Token("iAmVariable", TokenTypes.Id.name(),1));
			tokens.add(new Token("{", TokenTypes.LBrace.name(),1));
			tokens.add(new Token("VAR_DECL_L", TokenTypes.VAR_DECL_L.name(),1));
			tokens.add(new Token("METH_DECL_L", TokenTypes.METH_DECL_L.name(),1));
			tokens.add(new Token("}", TokenTypes.RBrace.name(),1));
			tokens.add(new Token("public", TokenTypes.Public.name(),1));
			
			parser.pushHoldStack(tokens.get(6));
			parser.pushHoldStack(tokens.get(5));
			parser.pushHoldStack(tokens.get(4));
			parser.pushHoldStack(tokens.get(3));
			parser.pushHoldStack(tokens.get(2));
			parser.pushHoldStack(tokens.get(1));
			parser.pushHoldStack(tokens.get(0));
			
			parser.pushStateStack(new MDJ_3());
			parser.pushStateStack(new MDJ_17());
			parser.pushStateStack(new MDJ_18());
			parser.pushStateStack(new MDJ_20());
			parser.pushStateStack(new MDJ_22());
			parser.pushStateStack(new MDJ_24());
			parser.pushStateStack(new MDJ_26());
			
			state.invalidState();
			
			assertFalse(parser.getInputStack().empty());
			assertTrue(parser.getHoldStack().empty());
			assertTrue(parser.getStateStack().empty());
			Token token = new Token(TokenTypes.CLASS_DECL, tokens);
			assertEquals(parser.peekInputStack().getLineNumber(), token.getLineNumber());
			assertEquals(parser.peekInputStack().getToken(), token.getToken());
			assertEquals(parser.peekInputStack().getTokenName(), token.getTokenName());
			assertEquals(parser.peekInputStack().getChildren(), token.getChildren());
			assertEquals(parser.getCurrentState().getClass(), new MDJ_3().getClass());
		}

}
