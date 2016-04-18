package parser.states.CRM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_36;
import parser.states.CRM.CRM_38;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * @author Chris Kjeldgaard
 */
public class TestCRM_36 {

	@Before
	public void setUp() {
		Parser.resetParser();
	}

	/**
	 * checks that shiftFORMAL_R works correctly
	 * 
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testShiftFORMAL_R() throws ParserException {
		Parser p = Parser.getInstance();
		State s = new CRM_36();

		Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);

		p.getInputStack().push(token);

		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());

		s.shiftFORMAL_R();

		assertTrue(p.getInputStack().empty());
		assertFalse(p.getHoldStack().empty());
		assertFalse(p.getStateStack().empty());

		assertEquals(p.getHoldStack().peek(), token);
		assertEquals(p.getStateStack().peek(), s);

		assertTrue(p.getCurrentState() instanceof CRM_38);
	}

	/**
	 * checks that shiftId works correctly
	 * 
	 * @author Chris Kjeldgaard
	 * @throws ParserException
	 */
	@Test
	public void testEmptyStringReduce() throws ParserException {
		Parser p = Parser.getInstance();
		State s = new CRM_36();

		Token token = new Token("METH_DECL_L", "METH_DECL_L", 25);

		p.getInputStack().push(token);

		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());

		s.shiftId();
		
		assertTrue(p.getInputStack().peek().getTokenName().equals(TokenTypes.FORMAL_R.name()));
	}

}
