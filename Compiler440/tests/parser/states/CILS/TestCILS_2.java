package parser.states.CILS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_10;
import parser.states.CILS.CILS_2;
import parser.states.CILS.CILS_3;
import parser.states.CILS.CILS_6;
import parser.states.CILS.CILS_7;
import parser.states.CILS.CILS_8;
import parser.states.CILS.CILS_9;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test class to check the methods of the CILS_2 class.
 * @author Jessica Schlesiger, Shannon Lee
 *
 */
public class TestCILS_2 {
    @Before
    public void setUp() {
        Parser.resetParser();
    }
    
    /**
     * Tests shifting to CILS_3 when STMT is received. 
     * @author Jessica Schlesiger
     * @throws ParserException
     */
    @Test
	public void testShiftSTMT() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_2();
	        
	    Token token = new Token("STMT", "STMT", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftSTMT();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_3);
	}
    
    /**
     * Tests shifting to CILS_6 when { is received. 
     * @author Jessica Schlesiger
     * @throws ParserException
     */
    @Test
	public void testShiftLeftBrace() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new CILS_2();
	        
	    Token token = new Token("{", "{", 25);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftLeftBrace();
	    
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof CILS_6);
	}
	@Test
	public void testIf() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_2();
    	Token token = new Token("if",TokenTypes.If.name(),1);
    	
    	parser.getInputStack().push(token);
    	
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftIf();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        assertTrue(parser.getCurrentState() instanceof CILS_7);
	}
	
    /**
     * @author Corey Peregord 
     * Tests shifting to CILS_10 when while is received. 
     * @throws ParserException
     */
	@Test
	public void testWhile() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_2();
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
     * @author Corey Peregord 
     * Tests shifting to CILS_8 when System.out.println is received. 
     * @throws ParserException
     */
	@Test
	public void testSystemOutPrintln() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_2();
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
     * @author Corey Peregord 
     * Tests shifting to CILS_9 when id is received. 
     * @throws ParserException
     */
	@Test
	public void testId() throws ParserException
	{
		Parser parser = Parser.getInstance();
    	State state = new CILS_2();
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
