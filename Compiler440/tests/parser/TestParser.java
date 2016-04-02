package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import parser.states.CRM_1;
import parser.states.CRM_2;
import parser.states.CRM_3;
import parser.states.JCTM_1;
import parser.states.JCTM_15;
import parser.states.JCTM_16;
import parser.states.MDJ_10;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;

/**
 * Test class to ensure the proper creation and usage with
 * of the parser and the stacks that comprises it
 * @author Curtis Rabe, Michael Zimmerman, Jared Good
 */
public class TestParser
{

    /**
     * This will ensure each test is run in isolation
     */
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
	/**
	 * Test the singleton initialization of a parser.
	 */
	@Test
	public void testInitialization()
	{
		assertNotNull(Parser.getInstance());
	}
	/**
	 * Test to make sure the holdStack is properly created
	 */
	@Test
	public void testHoldStackInitialization()
	{
		assertTrue(Parser.getInstance().getHoldStack().empty());
	}
	
	/**
	 * Test to make sure the holdStack can successfully hold tokens
	 */
	@Test
	public void testHoldStackCanStoreTokens()
	{
		Token tok1 = new Token();
		Token tok2 = new Token();
		Parser.getInstance().getHoldStack().push(tok1);
		Parser.getInstance().getHoldStack().push(tok2);
		assertEquals(tok2, Parser.getInstance().getHoldStack().pop());
		assertEquals(tok1, Parser.getInstance().getHoldStack().pop());
	}
	/**
	 * Test to make sure the inputStack is properly created
	 * Michael Zimmerman
	 */
	@Test
	public void testInputStackInitialization()
	{
		assertTrue(Parser.getInstance().getInputStack().empty());
	}
	
	/**
	 * Test to make sure the inputStack can successfully hold tokens
	 * Michael Zimmerman
	 */
	@Test
	public void testInputStackCanStoreTokens()
	{
		Token tok1 = new Token();
		Token tok2 = new Token();
		Parser.getInstance().getInputStack().push(tok1);
		Parser.getInstance().getInputStack().push(tok2);
		assertEquals(tok2, Parser.getInstance().getInputStack().pop());
		assertEquals(tok1, Parser.getInstance().getInputStack().pop());
	}
	
	/**
	 * Test to make sure the stateStack is properly created
	 * Jared Good
	 */
	@Test
	public void testStateStackInitialization()
	{
		assertTrue(Parser.getInstance().getStateStack().empty());
	}
	
	/**
	 * Test to make sure the stateStack can successfully hold states
	 * Jared Good
	 */
	@Test
	public void testStateStackCanStoreTokens()
	{
		ExampleState state1 = new ExampleState();
		ExampleState state2 = new ExampleState();
		Parser.getInstance().getStateStack().push(state1);
		Parser.getInstance().getStateStack().push(state2);
		assertEquals(state2, Parser.getInstance().getStateStack().pop());
		assertEquals(state1, Parser.getInstance().getStateStack().pop());
	}
	
	/**
	 * Test to ensure that we properly create an Input Stack from an ArrayList
	 * Daniel Breitigan & Matt Mousetis
	 */
	@Test
	public void testCreateInputStack()
	{
	       Token tok1 = new Token();
	       Token tok2 = new Token();
	       ArrayList<Token> tok = new ArrayList<Token>();
	       tok.add(tok1);
	       tok.add(tok2);
	       
	       Parser.getInstance().createInputStack(tok);
	       assertEquals(tok1, Parser.getInstance().popInputStack());
	       assertEquals(tok2, Parser.getInstance().popInputStack());
	}
	/**
	 * Test that our parser properly shifts to the next state
	 * @throws ParserException 
	 */
	@Test
	public void testNextState() throws ParserException
	{
	    Token tok1 = new Token("EXP1", "EXP1", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof MDJ_10);  
	}
	
	@Test
	public void testEXP2shift() throws ParserException
	{
	    Token tok1 = new Token("EXP2", "EXP2", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof CRM_1);  
	}
	
	@Test
	public void testEXP3Shift() throws ParserException
	{
	    Token tok1 = new Token("EXP3", "EXP3", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof CRM_2);  
	}
	
	@Test
	public void testEXP4Shift() throws ParserException
	{
	    Token tok1 = new Token("EXP4", "EXP4", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof CRM_3);  
	}
	
	@Test
	public void testEXP5Shift() throws ParserException
	{
	    Token tok1 = new Token("EXP5", "EXP5", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JCTM_1);  
	}
	
	@Test
	public void testEXP6Shift() throws ParserException
	{
	    Token tok1 = new Token("EXP6", "EXP6", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JCTM_15);  
	}
	
	@Test
	public void testEXP7Shift() throws ParserException
	{
	    Token tok1 = new Token("EXP7", "EXP7", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JCTM_16);  
	}

	@Test
	public void testShiftId() throws ParserException
	{
	    Token tok1 = new Token("ID", "id", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JCTM_17);  
	}
	
	@Test
	public void testShiftIntegerLiteral() throws ParserException
	{
	    Token tok1 = new Token("IntNum", "IntNum", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JCTM_18);  
	}
	
	@Test
	public void testShiftTrue() throws ParserException
	{
	    Token tok1 = new Token("TRUE", "True", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JCTM_19);  
	}
	
	@Test
	public void testShiftFalse() throws ParserException
	{
	    Token tok1 = new Token("FALSE", "false", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JCTM_27);  
	}
	
	@Test
	public void testShiftThis() throws ParserException
	{
	    Token tok1 = new Token("THIS", "this", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JCTM_29);  
	}
	
	@Test
	public void testShiftNew() throws ParserException
	{
	    Token tok1 = new Token("NEW", "New", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_1);  
	}
	
	@Test
	public void testShiftNot() throws ParserException
	{
	    Token tok1 = new Token("NOT", "Not", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_5);  
	}
	
	@Test
	public void testShiftLBracket() throws ParserException
	{
	    Token tok1 = new Token("LBRACKET", "LBracket", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_6);  
	}
	
	@Test
	public void testShiftLBrace() throws ParserException
	{
	    Token tok1 = new Token("LBRACE", "LBrace", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_7);  
	}
	
	@Test
	public void testShiftLeftPara() throws ParserException
	{
	    Token tok1 = new Token("LPARA", "LPara", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_8);
	}
	
	@Test
	public void testShiftRightPara() throws ParserException
	{
	    Token tok1 = new Token("RPARA", "RPara", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_18);  
	}

	@Test
	public void testShiftVarDec_l() throws ParserException
	{
	    Token tok1 = new Token("VAR_DECL_L", "VAR_DECL_L", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_19);  
	}
	
	@Test
	public void testShiftVarDecl() throws ParserException
	{
	    Token tok1 = new Token("VAR_DECL", "VAR_DECL", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_20);  
	}
	
	@Test
	public void testShiftPublic() throws ParserException
	{
	    Token tok1 = new Token("PUBLIC", "Public", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_23);  
	}
	
	@Test
	public void testShiftStatic() throws ParserException
	{
	    Token tok1 = new Token("STATIC", "Static", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_24);  
	}
	
	@Test
	public void testShiftStatic() throws ParserException
	{
	    Token tok1 = new Token("VOID", "Void", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_27);  
	}
	
	@Test
	public void testShiftStatic() throws ParserException
	{
	    Token tok1 = new Token("MAIN", "Main", 1);
	    ArrayList<Token> tok = new ArrayList<Token>();
	    tok.add(tok1);
	    
	    
	    Parser.getInstance().createInputStack(tok);
	    Parser.getInstance().pushStateStack(new MockState());
	    Parser.getInstance().NextState();
	    assertTrue(Parser.getInstance().getCurrentState() instanceof JMCC_28);  
	}
}

    /**
     * Mock State Class to test the next state method
     *
     */
    class MockState extends State
    {
        public void shiftEXP1 () throws ParserException
        {
            changeToState(new MDJ_10());
        }
        public void shiftEXP2() throws ParserException
        {
        	changeToState(new CRM_1());
        }
        public void shiftEXP3() throws ParserException
        {
        	changeToState(new CRM_2());
        }
        public void shiftEXP4() throws ParserException
        {
        	changeToState(new CRM_3());
        }
        public void shiftEXP5() throws ParserException
        {
        	changeToState(new JCTM_1());
        }
        public void shiftEXP6() throws ParserException
        {
        	changeToState(new JCTM_15());
        }
        public void shiftEXP7() throws ParserException
        {
        	changeToState(new JCTM_16());
        }
        public void shiftId() throws ParserException
        {
        	changeToState(new JCTM_17());
        }
        public void shiftIntegerLiteral() throws ParserException
        {
        	changeToState(new JCTM_18());
        }
        public void shiftTrue() throws ParserException
        {
        	changeToState(new JCTM_19());
        }
        public void shiftFalse() throws ParserException
        {
        	changeToState(new JCTM_27());
        }
        public void shiftThis() throws ParserException
        {
        	changeToState(new JCTM_29());
        }
        public void shiftNew() throws ParserException
        {
        	changeToState(new JMCC_1());
        }
        public void shiftExclamation() throws ParserException
        {
        	changeToState(new JMCC_5());
        }
        public void shiftLeftBracket() throws ParserException
        {
        	changeToState(new JMCC_6());
        }
        public void shiftLeftBrace() throws ParserException
        {
        	changeToState(new JMCC_7());
        }
        public void shiftLeftPara() throws ParserException
        {
        	changeToState(new JMCC_8());
        }
        public void shiftRightPara() throws ParserException
        {
        	changeToState(new JMCC_18());
        }
        public void shiftVAR_DECL_L() throws ParserException
        {
        	changeToState(new JMCC_19());
        }
        public void shiftVAR_DECL() throws ParserException
        {
        	changeToState(new JMCC_20());
        }

        public void shiftPublic() throws ParserException 
        {
        	changeToState(new JMCC_23());
        }

        public void shiftStatic() throws ParserException 
        {
        	changeToState(new JMCC_24());
        }

        public void shiftVoid() throws ParserException 
        {
        	changeToState(new JMCC_27());
        }

        public void shiftMain() throws ParserException 
        {
        	changeToState(new JMCC_28());
        }
    }
