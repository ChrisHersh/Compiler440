package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_0;
import parser.states.MDJ.MDJ_1;
import parser.states.MDJ.MDJ_5;
import tokenizer.Token;
/**
 * 
 * @author Curtis Rabe
 * Test cases to ensure MDJ_0 properly shifts when reading tokens
 *
 */
public class TestMDJ_0
{

	/**
    * prepares the parser from former test
    */
   @Before
   public void setUp()
   {
       Parser.resetParser();
   }
   
   /**
    * @author Curtis Rabe
    * @throws ParserException
    * Test to ensure MDJ_0 can shift to MDJ_5 when reading "class" token
    */
   @Test
	public void testShiftClass() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new MDJ_0();
	        
	    Token token = new Token("class", "class", 6);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftClass();
	   
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof MDJ_5);
	}
   
   /**
    * @author Curtis Rabe
    * @throws ParserException
    * Test to ensure MDJ_0 can shift to MDJ_1 when reading "MAIN_CLASS" non-terminal
    */
   @Test
	public void testShiftMAIN_CLASS() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new MDJ_0();
	        
	    Token token = new Token("MAIN_CLASS", "MAIN_CLASS", 6);
	    
	    p.getInputStack().push(token);
	    
	    assertFalse(p.getInputStack().empty());
	    assertEquals(p.getInputStack().peek(), token);
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	    
	    s.shiftMAIN_CLASS();
	   
	    assertTrue(p.getInputStack().empty());
	    assertFalse(p.getHoldStack().empty());
	    assertFalse(p.getStateStack().empty());
	    
	    assertEquals(p.getHoldStack().peek(), token);
	    assertEquals(p.getStateStack().peek(), s);
	    
	    assertTrue(p.getCurrentState() instanceof MDJ_1);
	}

}
