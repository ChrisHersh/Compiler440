package parser.states.MDJ;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.MDJ.MDJ_0;
import parser.states.MDJ.MDJ_1;
import parser.states.MDJ.MDJ_17;
import parser.states.MDJ.MDJ_3;
import parser.states.MDJ.MDJ_4;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * 
 * @author Jessica Schlesiger
 * Test cases to ensure the MDJ_3 can properly shift when reading tokens
 */
public class TestMDJ_3 {

	/**
	 * prepares the parser from former test
	 */
	@Before
	public void setUp()
	{
		Parser.resetParser();
	}

	/**
	 * @author Jessica Schlesiger
	 * @throws ParserException
	 * Tests that MDJ_3 can properly shift to MDJ_17 when reading a "class" token
	 */
	@Test
	public void testShiftClass() throws ParserException
	{
		Parser p = Parser.getInstance();
		State s = new MDJ_3();

		Token token = new Token("class", "class", 60);

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

		assertTrue(p.getCurrentState() instanceof MDJ_17);
	}
	
	/**
	 * @throws ParserException
	 * Tests that MDJ_3 can properly shift to MDJ_4 when reading a "CLASS_DECL" token
	 */
	@Test
	public void testShiftClass_Decl() throws ParserException
	{
		Parser p = Parser.getInstance();
		State s = new MDJ_3();

		Token token = new Token("CLASS_DECL", "CLASS_DECL", 60);

		p.getInputStack().push(token);

		assertFalse(p.getInputStack().empty());
		assertEquals(p.getInputStack().peek(), token);
		assertTrue(p.getHoldStack().empty());
		assertTrue(p.getStateStack().empty());

		s.shiftCLASS_DECL();

		assertTrue(p.getInputStack().empty());
		assertFalse(p.getHoldStack().empty());
		assertFalse(p.getStateStack().empty());

		assertEquals(p.getHoldStack().peek(), token);
		assertEquals(p.getStateStack().peek(), s);

		assertTrue(p.getCurrentState() instanceof MDJ_4);
	}

	/**
	 * Tests the reduce from MDJ_3 to MDJ_0 for PROG
     * @throws ParserException
     */
    @Test
	public void testReduce() throws ParserException
	{
	    Parser p = Parser.getInstance();
	    State s = new MDJ_3();
	    
	    ArrayList<Token> tokens = new ArrayList<Token>();
	    //the tokens that should be found to make a MAIN_CLASS token
	    tokens.add(new Token("class_decl_l","CLASS_DECL_L",5));
	    tokens.add(new Token("main_class","MAIN_CLASS",5));
	    //push the tokens on the holdStack in the order that they are expected to be found in
	    p.pushHoldStack(tokens.get(1));
	    p.pushHoldStack(tokens.get(0)); 
	    //push the states that stateStack in the order that they are expected to be found in
	    p.pushStateStack(new MDJ_0());
	    p.pushStateStack(new MDJ_1());
	    //try to handle "bad" token to start the reduce
	    s.invalidState();
	    //test that the stacks are appropriately filled
	    assertFalse(p.getInputStack().empty());
	    assertTrue(p.getHoldStack().empty());
	    assertTrue(p.getStateStack().empty());
	
	    Token testee = new Token(TokenTypes.PROG, tokens);
	    //test that the new token is correct and stacks correctly
	    assertEquals(p.peekInputStack().getLineNumber(), testee.getLineNumber());
	    assertEquals(p.peekInputStack().getToken(), testee.getToken());
	    assertEquals(p.peekInputStack().getTokenName(), testee.getTokenName());
	    assertEquals(p.peekInputStack().getChildren(), testee.getChildren());
	    assertEquals(p.getCurrentState().getClass(), new MDJ_0().getClass());
	}
	
}
