package intermediate.process;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.Class;
import symboltable.VariableType;
import symboltable.method.impl.PublicMethod;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * TestProcessEXP7.java
 * Tests for ProcessEXP7. Note that many cases don't need Pass2 or Pass3.
 * @author Chris Hersh, Daniel Breitigan, Matt Mousetis, Ian Keefer
 *
 */
public class TestProcessEXP7 
{
	
	/**
	 * id.length
	 */
	@Test
	public void testProcessPass1Length()
	{
		Token t0 = new Token("Id", TokenTypes.Id.name(), 1);
		Token t1 = new Token(TokenTypes.Length.name(), 1, null);
		t0.setVisited();
		t1.setVisited();
		t1.setType(TokenTypes.Length.name());

		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(t0);
		tokens.add(t1);

		Token t2 = new Token(TokenTypes.Boolean.name(), 1, tokens);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t2.setParentMethod(pm);
		t2.setParentClass(c1);
		
		assertFalse(t2.isVisited());
		
		ProcessEXP7.processPass1(t2);
		assertTrue(t2.isVisited());
		assertEquals(t2.getType(), t2.getChildren().get(0).getType());
		assertEquals(t2.getParentClass(), t2.getChildren().get(0).getParentClass());
		assertEquals(t2.getParentMethod(), t2.getChildren().get(0).getParentMethod());
		assertEquals(t2.getParentClass(), t2.getChildren().get(1).getParentClass());
		assertEquals(t2.getParentMethod(), t2.getChildren().get(1).getParentMethod());
	}
	
	/**
	 * id.id[EXP_L]
	 */
	@Test
	public void testProcessPass1IdIdLBraceEXP1RBrace()
	{
		Token t0 = new Token(TokenTypes.Id.name(), 1, null);
		Token t1 = new Token(TokenTypes.Id.name(), 1, null);
		Token t2 = new Token(TokenTypes.LBrace.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP_L.name(), 1, null);
		Token t4 = new Token(TokenTypes.RBrace.name(), 1, null);
		t0.setVisited();
		t1.setVisited();
		t2.setVisited();
		t3.setVisited();
		t4.setVisited();
		t3.setType(TokenTypes.Boolean.name());

		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(t0);
		tokens.add(t1);
		tokens.add(t2);
		tokens.add(t3);
		tokens.add(t4);

		Token t5 = new Token(TokenTypes.Boolean.name(), 1, tokens);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t5.setParentMethod(pm);
		t5.setParentClass(c1);
		
		assertFalse(t5.isVisited());
		ProcessEXP7.processPass1(t5);
		assertTrue(t5.isVisited());
		assertEquals(t5.getType(), t5.getChildren().get(4).getType());
		assertEquals(t5.getParentClass(), t5.getChildren().get(0).getParentClass());
		assertEquals(t5.getParentMethod(), t5.getChildren().get(0).getParentMethod());
		assertEquals(t5.getParentClass(), t5.getChildren().get(1).getParentClass());
		assertEquals(t5.getParentMethod(), t5.getChildren().get(1).getParentMethod());
		assertEquals(t5.getParentClass(), t5.getChildren().get(2).getParentClass());
		assertEquals(t5.getParentMethod(), t5.getChildren().get(2).getParentMethod());
		assertEquals(t5.getParentClass(), t5.getChildren().get(3).getParentClass());
		assertEquals(t5.getParentMethod(), t5.getChildren().get(3).getParentMethod());
		assertEquals(t5.getParentClass(), t5.getChildren().get(4).getParentClass());
		assertEquals(t5.getParentMethod(), t5.getChildren().get(4).getParentMethod());
	
	}
	
	/**
	 * id[EXP1]
	 */
	@Test
	public void testProcessPass1IdLBraceEXP1RBrace()
	{
		Token t1 = new Token(TokenTypes.Id.name(), 1, null);
		Token t2 = new Token(TokenTypes.LBrace.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP_L.name(), 1, null);
		Token t4 = new Token(TokenTypes.RBrace.name(), 1, null);
		t1.setVisited();
		t2.setVisited();
		t3.setVisited();
		t4.setVisited();
		t3.setType(TokenTypes.Boolean.name());

		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(t1);
		tokens.add(t2);
		tokens.add(t3);
		tokens.add(t4);

		Token t5 = new Token(TokenTypes.Boolean.name(), 1, tokens);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t5.setParentMethod(pm);
		t5.setParentClass(c1);
		
		assertFalse(t5.isVisited());
		ProcessEXP7.processPass1(t5);
		assertTrue(t5.isVisited());
		assertEquals(t5.getType(), t5.getChildren().get(3).getType());
		assertEquals(t5.getParentClass(), t5.getChildren().get(0).getParentClass());
		assertEquals(t5.getParentMethod(), t5.getChildren().get(0).getParentMethod());
		assertEquals(t5.getParentClass(), t5.getChildren().get(1).getParentClass());
		assertEquals(t5.getParentMethod(), t5.getChildren().get(1).getParentMethod());
		assertEquals(t5.getParentClass(), t5.getChildren().get(2).getParentClass());
		assertEquals(t5.getParentMethod(), t5.getChildren().get(2).getParentMethod());
		assertEquals(t5.getParentClass(), t5.getChildren().get(3).getParentClass());
		assertEquals(t5.getParentMethod(), t5.getChildren().get(3).getParentMethod());
	}
	
	/**
     * Makes sure EXP7 -> id works
     */
    @Test
    public void testProcessPass1Id()
    {
        Token t0 = new Token("str", TokenTypes.Id.name(), 1);

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);

        Token t1 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t1.setParentMethod(pm);
        t1.setParentClass(c1);
        
        assertFalse(t1.isVisited());
        ProcessEXP7.processPass1(t1);
        assertTrue(t1.isVisited());
        assertEquals(t1.getToken(), "str");
    }
    
    /**
     * Makes sure EXP7 -> id works
     */
    @Test
    public void testProcessPass1This()
    {
        Token t0 = new Token("this", TokenTypes.This.name(), 1);

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);

        Token t1 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t1.setParentMethod(pm);
        t1.setParentClass(c1);
        
        assertFalse(t1.isVisited());
        ProcessEXP7.processPass1(t1);
        assertTrue(t1.isVisited());
        assertEquals(t1.getType(), "ClassName");
    }
	
    
    
    /**
     * Makes sure EXP7 -> new int [ EXP ] works
     */
    @Test
    public void testProcessPass1NewInt()
    {
        Token t0 = new Token("new", TokenTypes.New.name(), 1);
        Token t1 = new Token("int", TokenTypes.Int.name(), 1);
        Token t2 = new Token("[", TokenTypes.LBracket.name(), 1);
        Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
        Token t4 = new Token("]", TokenTypes.RBracket.name(), 1);

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);
        tokens.add(t1);
        tokens.add(t2);
        tokens.add(t3);
        tokens.add(t4);

        Token t5 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t5.setParentMethod(pm);
        t5.setParentClass(c1);
        
        assertFalse(t5.isVisited());
        try
        {
            ProcessEXP7.processPass1(t5);
        } catch (NullPointerException e)
        {
            //do nothing we expect an exception to be thrown
        }
        assertTrue(t5.isVisited());
        assertEquals(t5.getType(), "int[]");
        assertEquals(t3.getParentClass(), c1);
        assertEquals(t3.getParentMethod(), pm);
    }
    
    /**
     * Makes sure EXP7 -> new id() works
     */
    @Test
    public void testProcessPass1NewId()
    {
        Token t0 = new Token("new", TokenTypes.New.name(), 1);
        Token t1 = new Token("Id", TokenTypes.Id.name(), 1);
        Token t2 = new Token("(", TokenTypes.LPara.name(), 1);
        Token t3 = new Token(")", TokenTypes.RPara.name(), 1);

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);
        tokens.add(t1);
        tokens.add(t2);
        tokens.add(t3);

        Token t4 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t4.setParentMethod(pm);
        t4.setParentClass(c1);
        
        assertFalse(t4.isVisited());
        try
        {
            ProcessEXP7.processPass1(t4);
        } catch (NullPointerException e)
        {
            //do nothing we expect an exception to be thrown
        }
        assertTrue(t4.isVisited());
        assertEquals(t4.getType(), "Id()");
    }
    
    /**
     * Makes sure EXP7 -> ! EXP1 works
     */
    @Test
    public void testProcessPass1NotEXP1()
    {
        Token t0 = new Token("!", TokenTypes.Not.name(), 1);
        Token t1 = new Token(TokenTypes.EXP1.name(), 1, null);
        t1.setType(TokenTypes.EXP1.name());

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);
        tokens.add(t1);

        Token t4 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t4.setParentMethod(pm);
        t4.setParentClass(c1);
        
        assertFalse(t4.isVisited());
        try
        {
            ProcessEXP7.processPass1(t4);
        } catch (NullPointerException e)
        {
            //do nothing we expect an exception to be thrown
        }
        assertTrue(t4.isVisited());
        assertEquals(t4.getType(), "EXP1");
    }
    
    /**
     * Makes sure EXP7 -> ( EXP1 ) works
     */
    @Test
    public void testProcessPass1LPara()
    {
        Token t0 = new Token("(", TokenTypes.LPara.name(), 1);
        Token t1 = new Token(TokenTypes.EXP1.name(), 1, null);
        Token t2 = new Token(")", TokenTypes.RPara.name(), 1);
        t1.setType(TokenTypes.EXP1.name());

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);
        tokens.add(t1);
        tokens.add(t2);

        Token t4 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t4.setParentMethod(pm);
        t4.setParentClass(c1);
        
        assertFalse(t4.isVisited());
        try
        {
            ProcessEXP7.processPass1(t4);
        } catch (NullPointerException e)
        {
            //do nothing we expect an exception to be thrown
        }
        assertTrue(t4.isVisited());
        assertEquals(t4.getType(), "EXP1");
    }

    /**
     * Makes sure EXP7 -> true works
     */
    @Test
    public void testProcessPass1True()
    {
        Token t0 = new Token("true", TokenTypes.True.name(), 1);
        t0.setType(TokenTypes.True.name());

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);

        Token t1 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t1.setParentMethod(pm);
        t1.setParentClass(c1);
        
        assertFalse(t1.isVisited());
        ProcessEXP7.processPass1(t1);
        assertTrue(t1.isVisited());
        assertEquals("True", t0.getType());
    }
    
    @Test
    public void testProcessPass1False()
    {
        Token t0 = new Token("false", TokenTypes.False.name(), 1);
        t0.setType(TokenTypes.False.name());

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);

        Token t1 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t1.setParentMethod(pm);
        t1.setParentClass(c1);
        
        assertFalse(t1.isVisited());
        ProcessEXP7.processPass1(t1);
        assertTrue(t1.isVisited());
        assertEquals("False", t0.getType());
    }
    
    @Test
    public void testProcessPass1IntLiteral()
    {
        Token t0 = new Token("INTEGER_LITERAL", TokenTypes.IntNum.name(), 1);
        t0.setType(TokenTypes.IntNum.name());

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);

        Token t1 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t1.setParentMethod(pm);
        t1.setParentClass(c1);
        
        assertFalse(t1.isVisited());
        ProcessEXP7.processPass1(t1);
        assertTrue(t1.isVisited());
        assertEquals("IntNum", t0.getType());
    }
    
    /**
     * Daniel Breitigan
     * Makes sure EXP7 -> (EXP1) works for pass3
     */
    @Test
    public void testProcessPass3LPara()
    {
        Token t0 = new Token("(", TokenTypes.LPara.name(), 1);
        Token t1 = new Token(TokenTypes.EXP1.name(), 1, null);
        Token t2 = new Token(")", TokenTypes.RPara.name(), 1);
        t1.setType(TokenTypes.EXP1.name());

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);
        tokens.add(t1);
        tokens.add(t2);

        Token t4 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t4.setParentMethod(pm);
        t4.setParentClass(c1);
        
        assertFalse(t4.isVisited());
        try
        {
            ProcessEXP7.processPass3(t4);
        } catch (NullPointerException e)
        {
            //do nothing we expect an exception to be thrown
        }
        assertEquals(t4.getCode().toString(), "(_EXP1_)_1:\n");
    }
    
    /**
     * Daniel Breitigan
     * Makes sure EXP7 -> ! EXP1 works for pass3
     */
    @Test
    public void testProcessPass3NotEXP1()
    {
        Token t0 = new Token("!", TokenTypes.Not.name(), 1);
        Token t1 = new Token(TokenTypes.EXP1.name(), 1, null);
        t1.setType(TokenTypes.EXP1.name());

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);
        tokens.add(t1);

        Token t4 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t4.setParentMethod(pm);
        t4.setParentClass(c1);
        
        assertFalse(t4.isVisited());
        try
        {
            ProcessEXP7.processPass3(t4);
        } catch (NullPointerException e)
        {
            //do nothing we expect an exception to be thrown
        }
        
        assertEquals(t4.getCode().toString(), "!_EXP1_1:\n");
    }
    
    /**
     * Daniel Breitigan
     * Makes sure EXP7 -> new id() works for pass3
     */
    @Test
    public void testProcessPass3NewId()
    {
        Token t0 = new Token("new", TokenTypes.New.name(), 1);
        Token t1 = new Token("Id", TokenTypes.Id.name(), 1);
        Token t2 = new Token("(", TokenTypes.LPara.name(), 1);
        Token t3 = new Token(")", TokenTypes.RPara.name(), 1);

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);
        tokens.add(t1);
        tokens.add(t2);
        tokens.add(t3);

        Token t4 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t4.setParentMethod(pm);
        t4.setParentClass(c1);
        
        assertFalse(t4.isVisited());
        try
        {
            ProcessEXP7.processPass3(t4);
        } catch (NullPointerException e)
        {
            //do nothing we expect an exception to be thrown
        }
        assertEquals(t4.getCode().toString(), "New_Id()_1:\n");
    }
    
    /**
     * Makes sure EXP7 -> this works for pass 3
     */
    @Test
    public void testProcessPass3This()
    {
        Token t0 = new Token("this", TokenTypes.This.name(), 1);

        t0.setVisited();

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);

        Token t4 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t4.setParentMethod(pm);
        t4.setParentClass(c1);
        
        assertFalse(t4.isVisited());
        try
        {
            ProcessEXP7.processPass3(t4);
        } catch (NullPointerException e)
        {
            //do nothing we expect an exception to be thrown
        }
        assertEquals(t4.getCode().toString(), "intermediate code for this");
    }
    
    /**
     * Makes sure EXP7 -> new int [ EXP1 ] works for pass 3
     */
    @Test
    public void testProcessPass3NewInt()
    {
    	Token t0 = new Token("new", TokenTypes.New.name(), 1);
        Token t1 = new Token("int", TokenTypes.Int.name(), 1);
        Token t2 = new Token("[", TokenTypes.LBracket.name(), 1);
        Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
        Token t4 = new Token("]", TokenTypes.RBracket.name(), 1);

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);
        tokens.add(t1);
        tokens.add(t2);
        tokens.add(t3);
        tokens.add(t4);

        Token t5 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t5.setParentMethod(pm);
        t5.setParentClass(c1);
        
        assertFalse(t5.isVisited());
        try
        {
            ProcessEXP7.processPass3(t5);
        } catch (NullPointerException e)
        {
            //do nothing we expect an exception to be thrown
        }
        assertEquals(t5.getCode().toString(), "intermediate code for new int [ EXP1 ]");
    }
    
    /**
     * Makes sure EXP7 -> id works for pass 3
     */
    @Test
    public void testProcessPass3Id()
    {
    	Token t0 = new Token("str", TokenTypes.Id.name(), 1);

        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(t0);

        Token t4 = new Token(TokenTypes.EXP7.name(), 1, tokens);
        Class c1 = new Class("ClassName", null, null);
        PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
        t4.setParentMethod(pm);
        t4.setParentClass(c1);
        
        assertFalse(t4.isVisited());
        try
        {
            ProcessEXP7.processPass3(t4);
        } catch (NullPointerException e)
        {
            //do nothing we expect an exception to be thrown
        }
        assertEquals(t4.getCode().toString(), "intermediate code for id");
    }
    
    /**
	 * length
	 */
	@Test
	public void testProcessPass3Length()
	{
		Token t1 = new Token(TokenTypes.Length.name(), 1, null);
		t1.setVisited();
		t1.setType(TokenTypes.Length.name());

		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(t1);

		Token t2 = new Token(TokenTypes.Boolean.name(), 1, tokens);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t2.setParentMethod(pm);
		t2.setParentClass(c1);
		
		assertFalse(t2.isVisited());
		
		ProcessEXP7.processPass3(t2);
        assertEquals(t2.getCode().toString(), "intermediate code for length");

	}
	
	/**
	 * rbrace
	 */
	@Test
	public void testProcessPass3RBrace()
	{
		Token t1 = new Token(TokenTypes.RBrace.name(), 1, null);
		t1.setVisited();
		t1.setType(TokenTypes.RBrace.name());

		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(t1);

		Token t2 = new Token(TokenTypes.Boolean.name(), 1, tokens);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t2.setParentMethod(pm);
		t2.setParentClass(c1);
		
		assertFalse(t2.isVisited());
		
		ProcessEXP7.processPass3(t2);
        assertEquals(t2.getCode().toString(), "intermediate code for rbrace");

	}
	
	/**
	 * lbrace
	 */
	@Test
	public void testProcessPass3LBrace()
	{
		Token t1 = new Token(TokenTypes.LBrace.name(), 1, null);
		t1.setVisited();
		t1.setType(TokenTypes.LBrace.name());

		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(t1);

		Token t2 = new Token(TokenTypes.Boolean.name(), 1, tokens);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t2.setParentMethod(pm);
		t2.setParentClass(c1);
		
		assertFalse(t2.isVisited());
		
		ProcessEXP7.processPass3(t2);
        assertEquals(t2.getCode().toString(), "intermediate code for lbrace");

	}
	
	/**
	 * EXP_l
	 */
	@Test
	public void testProcessPass3expl()
	{
		Token t1 = new Token(TokenTypes.EXP_L.name(), 1, null);
		t1.setVisited();
		t1.setType(TokenTypes.EXP_L.name());

		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(t1);

		Token t2 = new Token(TokenTypes.Boolean.name(), 1, tokens);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t2.setParentMethod(pm);
		t2.setParentClass(c1);
		
		assertFalse(t2.isVisited());
		
		ProcessEXP7.processPass3(t2);
        assertEquals(t2.getCode().toString(), "intermediate code for exp_l");

	}
	
	/**
	 * id
	 */
	@Test
	public void testProcessPass3id()
	{
		Token t1 = new Token(TokenTypes.Id.name(), 1, null);
		t1.setVisited();
		t1.setType(TokenTypes.Id.name());

		ArrayList<Token> tokens = new ArrayList<Token>();
		tokens.add(t1);

		Token t2 = new Token(TokenTypes.Boolean.name(), 1, tokens);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t2.setParentMethod(pm);
		t2.setParentClass(c1);
		
		assertFalse(t2.isVisited());
		
		ProcessEXP7.processPass3(t2);
        assertEquals(t2.getCode().toString(), "intermediate code for id");

	}

    
    
}
    
}
