package tests.parser.states;

import static org.junit.Assert.*;

import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;

public class TestJCTM_0 {

    public void testShiftIntegerLiteral() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_0();
        
        Token inpToken = new Token("5", TokenTypes.IntNum.name(), 6);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        //Make the current state the one we're testing
        p.changeState(s);
        
        p.nextState();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JCTM_18);
    }

    @Test
    public void testTrue() throws ParserException 
    {
    	Parser parser = Parser.getInstance();
    	State state = new JCTM_0();
    	
    	Token token = new Token("true", "TRUE", 5);
    	
    	parser.getInputStack().push(token);
    	
    	assertFalse(parser.getInputStack().empty());
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftIntegerLiteral();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_15);
        
    }
    
    @Test
    public void testFalse() throws ParserException 
    {
    	Parser parser = Parser.getInstance();
    	State state = new JCTM_0();
    	
    	Token token = new Token("false", "FALSE", 5);
    	
    	parser.getInputStack().push(token);
    	
    	assertFalse(parser.getInputStack().empty());
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftIntegerLiteral();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_16);
        
    }
    
    @Test
    public void testThis() throws ParserException 
    {
    	Parser parser = Parser.getInstance();
    	State state = new JCTM_0();
    	
    	Token token = new Token("this", "THIS", 5);
    	
    	parser.getInputStack().push(token);
    	
    	assertFalse(parser.getInputStack().empty());
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftIntegerLiteral();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_17);
        
    }
    
    @Test
    public void testId() throws ParserException 
    {
    	Parser parser = Parser.getInstance();
    	State state = new JCTM_0();
    	
    	Token token = new Token("id", "ID", 5);
    	
    	parser.getInputStack().push(token);
    	
    	assertFalse(parser.getInputStack().empty());
    	assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftIntegerLiteral();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_1);
        
    }
    
    @Test
    public void testShiftLeftBrace() throws ParserException
    {
        Parser p = Parser.getInstance();
        State s = new JCTM_0();
        
        Token inpToken = new Token("||", TokenTypes.LBrace.name(), 6);
        
        p.getInputStack().push(inpToken);
        
        assertFalse(p.getInputStack().empty());
        assertEquals(p.getInputStack().peek(), inpToken);
        assertTrue(p.getHoldStack().empty());
        assertTrue(p.getStateStack().empty());
        
        //Make the current state the one we're testing
        p.changeState(s);
        
        p.nextState();
        
        assertTrue(p.getInputStack().empty());
        assertFalse(p.getHoldStack().empty());
        assertFalse(p.getStateStack().empty());
        
        assertEquals(p.getHoldStack().peek(), inpToken);
        assertEquals(p.getStateStack().peek(), s);
        
        assertTrue(p.getCurrentState() instanceof JCTM_29);
    }
}
