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
 * Test all of the state shifts for CILS_29
 * @author Raistlin Hess
 *
 */
public class TestCILS_29
{
		/**
		 * Initialize the Parser
		 */
		@Before
	    public void setUp()
	    {
	        Parser.resetParser();
	    }

		/**
		 * Make sure handles STMT input correctly.
		 * It should shift to CILS_30
		 */
		@Test
		public void testShiftSTMT() throws ParserException
		{
			Parser parser = Parser.getInstance();
	    	State state = new CILS_29();
	    	Token token = new Token("STMT", TokenTypes.Junk.name(),1);
	    	parser.getInputStack().push(token);
	    	
	    	assertEquals(parser.getInputStack().peek(), token);
	        assertTrue(parser.getHoldStack().empty());
	        assertTrue(parser.getStateStack().empty());
	        
	        state.shiftSTMT();
	        
	        assertTrue(parser.getInputStack().empty());
	        assertFalse(parser.getHoldStack().empty());
	        assertFalse(parser.getStateStack().empty());
	        
	        assertEquals(parser.getHoldStack().peek(), token);
	        assertEquals(parser.getStateStack().peek(), state);
	        assertTrue(parser.getCurrentState() instanceof CILS_30);
		}
		
		/**
		 * Make sure handles if input correctly.
		 * It should shift to CILS_7
		 */
		@Test
		public void testShiftIf() throws ParserException
		{
			Parser parser = Parser.getInstance();
			State state = new CILS_29();
	    	Token token = new Token("if", TokenTypes.If.name(),1);
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
		 * Make sure handles { input correctly.
		 * It should shift to CILS_6
		 */
		@Test
		public void testShiftLeftBrace() throws ParserException
		{
			Parser parser = Parser.getInstance();
			State state = new CILS_29();
	    	Token token = new Token("{", TokenTypes.LBrace.name(),1);
	    	parser.getInputStack().push(token);
	    	
	    	assertEquals(parser.getInputStack().peek(), token);
	        assertTrue(parser.getHoldStack().empty());
	        assertTrue(parser.getStateStack().empty());
	        
	        state.shiftLeftBrace();
	        
	        assertTrue(parser.getInputStack().empty());
	        assertFalse(parser.getHoldStack().empty());
	        assertFalse(parser.getStateStack().empty());
	        
	        assertEquals(parser.getHoldStack().peek(), token);
	        assertEquals(parser.getStateStack().peek(), state);
	        assertTrue(parser.getCurrentState() instanceof CILS_6);
		}
		
		/**
		 * Make sure handles while input correctly.
		 * It should shift to CILS_10
		 */
		@Test
		public void testShiftWhile() throws ParserException
		{
			Parser parser = Parser.getInstance();
			State state = new CILS_29();
	    	Token token = new Token("while", TokenTypes.While.name(),1);
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
		 * Make sure handles SOP input correctly.
		 * It should shift to CILS_8
		 */
		@Test
		public void testShiftSystemOutPrintln() throws ParserException
		{
			Parser parser = Parser.getInstance();
			State state = new CILS_29();
	    	Token token = new Token("System.out.println", TokenTypes.SystemOutPrintln.name(),1);
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
		 * Make sure handles id input correctly.
		 * It should shift to CILS_9
		 */
		@Test
		public void testShiftId() throws ParserException
		{
			Parser parser = Parser.getInstance();
			State state = new CILS_29();
	    	Token token = new Token("FUN", TokenTypes.Id.name(),1);
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
