package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import parser.Parser;
import tokenizer.Token;

public class TestJMCC_33 {
	
	/**
	 * Tests that JMCC_33 can shift on EXP6
	 * @throws ParserException
	 */
    @Test
    public void testShiftEXP6() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JMCC_33();
        
        Token inpToken = new Token("exp6", "EXP6", 42);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        s.shiftEXP6();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JMCC_32);
    }

}
