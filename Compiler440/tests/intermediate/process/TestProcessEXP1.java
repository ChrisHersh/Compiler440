package intermediate.process;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.Class;
import symboltable.VariableType;
import symboltable.method.impl.PublicMethod;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Test process EXP1 to test the correct processing of the tokens.
 * @author Chad Nunemaker
 */
public class TestProcessEXP1
{
	/**
	 * A test to make sure EXP1 can properly run through and process its tokens.
	 */
	@Test
	public void testProcessPass1()
	{
		// Handle EXP1_A -> EXP1 op1 EXP2
		Token t1 = new Token(TokenTypes.EXP1.name(), 1, null); // Assume EXP1 = True
		t1.setVisited();
		t1.setType(TokenTypes.Boolean.name());
		Token t2 = new Token(TokenTypes.OP1.name(), 1, null);
		t2.setVisited();
		Token t3 = new Token(TokenTypes.EXP2.name(), 1, null); // Assume EXP2 = True
		t3.setVisited();
		t3.setType(TokenTypes.Boolean.name());
		
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		Class c1 = new Class("Foo", null, null);
		PublicMethod pm = new PublicMethod("Bar", null, VariableType.BOOLEAN, null);
		t4.setParentMethod(pm);
		t4.setParentClass(c1);
		try
		{
			ProcessEXP1.processPass1(t4);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		assertTrue(t4.isVisited());
		
		// Handle EXP1 -> EXP2
		t1 = new Token(TokenTypes.EXP2.name(), 1, null); // Assume EXP2 = True
		t1.setVisited();
		t1.setType(TokenTypes.Boolean.name());
		tkns = new ArrayList<Token>();
		tkns.add(t1);
		
		t2 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		c1 = new Class("Foo", null, null);
		pm = new PublicMethod("Bar", null, VariableType.BOOLEAN, null);
		t2.setParentMethod(pm);
		t2.setParentClass(c1);
		try
		{
			ProcessEXP1.processPass1(t2);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		assertTrue(t4.isVisited());
	}
	
	/**
	 * Test to see if the EXP1 can make it through a second pass .
	 */
	@Test
	public void testProcessPass2()
	{
		// Handle EXP1_A -> EXP1 op1 EXP2
		Token t1 = new Token(TokenTypes.EXP1.name(), 1, null); // Assume EXP1 = True
		t1.setVisited();
		t1.setType(TokenTypes.Boolean.name());
		Token t2 = new Token(TokenTypes.OP1.name(), 1, null);
		t2.setVisited();
		Token t3 = new Token(TokenTypes.EXP2.name(), 1, null); // Assume EXP2 = True
		t1.setVisited();
		t3.setType(TokenTypes.Boolean.name());
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		try
		{
			ProcessEXP1.processPass2(t4);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		} catch (ProcessException e)
		{
			fail("Failed on type check");
		}
		assertTrue(t4.isVisited());
		
		// Handle EXP1 -> EXP2
		t1 = new Token(TokenTypes.EXP2.name(), 1, null); // Assume EXP2 = True
		t1.setVisited();
		tkns = new ArrayList<Token>();
		tkns.add(t1);
		
		t2 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		try
		{
			ProcessEXP1.processPass2(t2);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		} catch (ProcessException e)
		{
			fail("Failed on type check");
		}
		assertTrue(t4.isVisited());
	}
	
	/**
	 * Test to see if the EXP1 can make it through the third pass. 
	 */
	@Test
	public void testProcessPass3()
	{
		// Handle EXP1_A -> EXP1 op1 EXP2
		Token t1 = new Token(TokenTypes.EXP1.name(), 1, null); // Assume EXP1 = True
		t1.getCode().append("True");
		t1.setVisited();
		Token t2 = new Token(TokenTypes.OP1.name(), 1, null);
		t2.getCode().append(" || ");
		t2.setVisited();
		Token t3 = new Token(TokenTypes.EXP2.name(), 1, null); // Assume EXP2 = True
		t3.getCode().append("True");
		t3.setVisited();
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		
		Token t4 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		try
		{
			ProcessEXP1.processPass3(t4);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		
		assertTrue(t4.isVisited());
		assertEquals("True || True", t4.getCode().toString());
		
		// Handle EXP1 -> EXP2
		t1 = new Token(TokenTypes.EXP2.name(), 1, null); // Assume EXP2 = True
		t1.getCode().append("True");
		t1.setVisited();
		tkns = new ArrayList<Token>();
		tkns.add(t1);
		
		t2 = new Token(TokenTypes.EXP1.name(), 1, tkns);
		try
		{
			ProcessEXP1.processPass3(t2);
		} catch (IndexOutOfBoundsException x)
		{
			fail("Failed on Children Creation");
		}
		
		assertTrue(t4.isVisited());
		assertEquals("True", t2.getCode().toString());
	}
}
