package intermediate.process;
/*
 * @author Manal Ibrahim 
 * Test process EXP6 to test the correct processing of the tokens
 * 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.Class;
import symboltable.VariableType;
import symboltable.method.impl.PublicMethod;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class TestProcessEXP5
{
	/**
	 * A test to make sure EXP6 can properly run through and process its tokens
	 */
	@Test
	public void testProcessPass1()
	{
		// Handle EXP5_A -> EXP5 op5 EXP6
		Token t1 = new Token(TokenTypes.EXP5.name(), 1, null);
		t1.setVisited();
		t1.setType(TokenTypes.Boolean.name());
		Token t2 = new Token(TokenTypes.OP5.name(), 1, null);
		t2.setVisited();
		Token t3 = new Token(TokenTypes.EXP6.name(), 1, null);
		t3.setVisited();
		t3.setType(TokenTypes.Boolean.name());
		
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP5.name(), 1, tkns);
		Class c1 = new Class("hi", null, null);
		PublicMethod pm = new PublicMethod("lol", null, VariableType.BOOLEAN, null);
		t4.setParentMethod(pm);
		t4.setParentClass(c1);
		try
		{
			ProcessEXP5.processPass1(t4);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		
		// Handle EXP5 -> EXP6
		t1 = new Token(TokenTypes.EXP6.name(), 1, null);
		t1.setVisited();
		t1.setType(TokenTypes.Boolean.name());
		tkns = new ArrayList<Token>();
		tkns.add(t1);
		
		t2 = new Token(TokenTypes.EXP5.name(), 1, tkns);
		c1 = new Class("hi", null, null);
		pm = new PublicMethod("lol", null, VariableType.BOOLEAN, null);
		t2.setParentMethod(pm);
		t2.setParentClass(c1);
		try
		{
			ProcessEXP5.processPass1(t2);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
	}
	
	
	/**
	 * test to see if the EXP6 can make it through a pass 2 
	 */
	@Test
	public void testProcessPass2()
	{
		// Handle EXP5_A -> EXP5 op5 EXP6
		Token t1 = new Token(TokenTypes.EXP6.name(), 1, null); 
		t1.setVisited();
		t1.setType(TokenTypes.Boolean.name());
		Token t2 = new Token(TokenTypes.OP5.name(), 1, null);
		t2.setVisited();
		Token t3 = new Token(TokenTypes.EXP6.name(), 1, null); 
		t1.setVisited();
		t3.setType(TokenTypes.Boolean.name());
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP5.name(), 1, tkns);
		try
		{
			ProcessEXP5.processPass2(t4);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		
		// Handle EXP5 -> EXP6
		t1 = new Token(TokenTypes.EXP6.name(), 1, null);
		t1.setVisited();
		tkns = new ArrayList<Token>();
		tkns.add(t1);
		
		t2 = new Token(TokenTypes.EXP5.name(), 1, tkns);
		try
		{
			ProcessEXP5.processPass2(t2);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
	}
	
	
	/**
	 * test to see if the EXP5 can make it through the pass 3
	 */
	@Test
	public void testProcessPass3()
	{
		// Handle EXP5_A -> EXP5 op5 EXP6
		Token t1 = new Token(TokenTypes.EXP5.name(), 1, null);
		t1.getCode().append("True");
		t1.setVisited();
		Token t2 = new Token(TokenTypes.OP5.name(), 1, null);
		if (t2.getCode().append(" + ") != null)
		t2.setVisited();
		else if (t2.getCode().append(" - ") != null)
			t2.setVisited();
		Token t3 = new Token(TokenTypes.EXP5.name(), 1, null);
		t3.getCode().append("True");
		t3.setVisited();
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP5.name(), 1, tkns);
		try
		{
			ProcessEXP5.processPass3(t4);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		
		assertEquals("True + True", t4.getCode().toString());
		
		// Handle EXP5 -> EXP6
		t1 = new Token(TokenTypes.EXP6.name(), 1, null);
		t1.getCode().append("True");
		t1.setVisited();
		tkns = new ArrayList<Token>();
		tkns.add(t1);
		
		t2 = new Token(TokenTypes.EXP5.name(), 1, tkns);
		try
		{
			ProcessEXP5.processPass3(t2);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		
		assertEquals("True", t2.getCode().toString());
	}
}