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
 * Test all of the state shifts for CILS_31
 * @author Mohammed
 *
 */
public class TestCILS_31
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
		 * It should shift to CILS_32
		 */
		@Test
		public void testShiftSTMT() throws ParserException
		{
			Parser parser = Parser.getInstance();
	    	State state = new CILS_31();
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
	        assertTrue(parser.getCurrentState() instanceof CILS_32);
		}
		
		/**
		 * Make sure handles { input correctly.
		 * It should shift to CILS_6
		 */
		@Test
		public void testShiftLeftBrace() throws ParserException
		{
			Parser parser = Parser.getInstance();
			State state = new CILS_31();
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
			State state = new CILS_31();
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
		 * Make sure handles SYSO input correctly.
		 * It should shift to CILS_8
		 */
		@Test
		public void testShiftSystemOutPrintln() throws ParserException
		{
			Parser parser = Parser.getInstance();
			State state = new CILS_31();
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
			State state = new CILS_31();
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
