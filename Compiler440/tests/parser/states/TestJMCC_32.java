package parser.states;

import static org.junit.Assert.*;

import org.junit.Test;

import parser.Parser;
import tokenizer.Token;

public class TestJMCC_32 {

	/**
	 * Tests that JMCC_32 can shift with EXP5
	 * @throws ParserException
	 */
    @Test
    public void testShiftEXP5() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_32();
        
        Token inpToken = new Token("exp5", "EXP5", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftEXP5();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JMCC_20);
    }

}
