package parser.states.JCTM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.*;
import parser.states.JMCC.*;
import tokenizer.Token;

/**
 * Test JCTM_2
 * @author Daniel Breitigan
 *
 */
public class TestJCTM_2
{

    //reset parser
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
    //Test shift EXP1
    @Test
    public void testEXP1() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("EXP1", "EXP1", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP1();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_4);  
    }
    
    //Test shift EXP2
    @Test
    public void testEXP2() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("EXP2", "EXP2", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP2();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JMCC_9);  
    }
    
    //Test shift EXP3
    @Test
    public void testEXP3() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("EXP3", "EXP3", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP3();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JMCC_15);  
    }
  //Test shift EXP4
    @Test
    public void testEXP4() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("EXP4", "EXP4", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP4();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JMCC_8);  
    }
    
  //Test shift EXP5
    @Test
    public void testEXP5() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("EXP5", "EXP5", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP5();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JMCC_20);  
    }
    
  //Test shift EXP6
    @Test
    public void testEXP6() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("EXP6", "EXP6", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP6();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JMCC_32);  
    }
    
  //Test shift EXP7
    @Test
    public void testEXP7() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("EXP7", "EXP7", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftEXP7();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JMCC_33);  
    }
    
  //Test shift Id
    @Test
    public void testId() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("Id", "Id", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftId();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_1);  
    }
    
  //Test shift IntergerLiteral
    @Test
    public void testIntegerLiteral() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("INTEGER_LITERAL", "INTEGER_LITERAL", 5);
        
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
        
        assertTrue(parser.getCurrentState() instanceof JCTM_18);  
    }
    
  //Test shift True
    @Test
    public void testTrue() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("True", "True", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftTrue();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_15);  
    }
    
  //Test shift False
    @Test
    public void testFalse() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("False", "False", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftFalse();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_16);  
    }
    
  //Test shift This
    @Test
    public void testThis() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("This", "This", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftThis();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_17);  
    }
    
  //Test shift New
    @Test
    public void testNew() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("New", "New", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftNew();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_19);  
    }
    
  //Test shift Exclamation
    @Test
    public void testExclamation() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("Exclamation", "Exclamation", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftExclamation();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_27);  
    }
    
  //Test shift LeftPara
    @Test
    public void testLeftPara() throws ParserException 
    {
        Parser parser = Parser.getInstance();
        State state = new JCTM_2();
        
        Token token = new Token("LPara", "LPara", 5);
        
        parser.getInputStack().push(token);
        
        assertFalse(parser.getInputStack().empty());
        assertEquals(parser.getInputStack().peek(), token);
        assertTrue(parser.getHoldStack().empty());
        assertTrue(parser.getStateStack().empty());
        
        state.shiftLeftPara();
        
        assertTrue(parser.getInputStack().empty());
        assertFalse(parser.getHoldStack().empty());
        assertFalse(parser.getStateStack().empty());
        
        assertEquals(parser.getHoldStack().peek(), token);
        assertEquals(parser.getStateStack().peek(), state);
        
        assertTrue(parser.getCurrentState() instanceof JCTM_29);  
    }
}
