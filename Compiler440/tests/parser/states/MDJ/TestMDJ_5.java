package parser.states.MDJ;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_5;
import parser.states.MDJ.MDJ_6;
import tokenizer.Token;
/**
 * 
 * @author Curtis Rabe
 * Test cases to ensure MDJ_5 can successfully shift when reading tokens
 */
public class TestMDJ_5
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
	 * Tests that MDJ_5 shifts to MDJ_6 when reading an "id" token
	 */
	@Test
	public void testShiftId() throws ParserException {
		Parser p = Parser.getInstance();
		State s = new MDJ_5();

		Token token = new Token("id", "id", 6);

		p.getInputStack().push(token);

		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());

		s.shiftId();

		assertTrue(p.getInputStack().empty());
		assertFalse(p.getHoldStack().empty());
		assertFalse(p.getStateStack().empty());

		assertEquals(p.getHoldStack().peek(), token);
		assertEquals(p.getStateStack().peek(), s);

		assertTrue(p.getCurrentState() instanceof MDJ_6);
	}

}
