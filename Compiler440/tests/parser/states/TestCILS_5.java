package parser.states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the CILS_5 class.
 * @author Jessica Schlesiger
 *
 */
public class TestCILS_5 {
    @Before
    public void setUp() {
        Parser.resetParser();
    }
    
    /**
     * Tests shifting to CILS_4 when } is received. 
     * @author Jessica Schlesiger
     * @throws ParserException
     */
    @Test
	public void testShiftRightBrace() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_5();
	        
	    Token token = new Token("}", "}", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftRightBrace();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_4);
	}
    
    /**
     * Tests shifting to CILS_10 when while is received. 
     * @throws ParserException
     */
	@Test
	public void testWhile() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_5();
    	Token token = new Token("while",TokenTypes.While.name(),1);
    	
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftWhile();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CILS_10);
	}
	
    /**
     * Tests shifting to CILS_8 when System.out.println is received. 
     * @throws ParserException
     */
	@Test
	public void testSystemOutPrintln() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_5();
    	Token token = new Token("System.out.println",TokenTypes.SystemOutPrintln.name(),1);
    	
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftSystemOutPrintln();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CILS_8);
	}
	
    /**
     * Tests shifting to CILS_9 when id is received. 
     * @throws ParserException
     */
	@Test
	public void testId() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_5();
    	Token token = new Token("id",TokenTypes.Id.name(),1);
    	
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftId();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CILS_9);
	}
}
