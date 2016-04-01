package parser.states;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;

public class TestMDJ_27 {

	/**
	 * Initialize the parser
	 * @author Shannon Jones
	 */
	@Before
    public void setUp()
    {
        Parser.resetParser();
    } 
	

	/**
	 * test shift right bracket
	 * @throws ParserException
	 */
	@Test
	public void testShiftRightBracket() throws ParserException 
	{
		 
			    Parser p = Parser.getInstance();
			    State s = new MDJ_27();
			        
			    Token token = new Token("}", "RT_BRACKET", 4);
			    
			    p.getInputStack().push(token);
			    
			    assertFalse(p.getInputStack().empty());
			    assertEquals(p.getInputStack().peek(), token);
			    assertTrue(p.getHoldStack().empty());
			    assertTrue(p.getStateStack().empty());
			    
			    s.shiftRightBracket();
			   
			    assertTrue(p.getInputStack().empty());
			    assertFalse(p.getHoldStack().empty());
			    assertFalse(p.getStateStack().empty());
			    
			    assertEquals(p.getHoldStack().peek(), token);
			    assertEquals(p.getStateStack().peek(), s);
			    
			    assertTrue(p.getCurrentState() instanceof MDJ_28);
	}
}
