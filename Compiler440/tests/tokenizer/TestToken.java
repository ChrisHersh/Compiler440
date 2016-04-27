package tokenizer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import symboltable.Class;
import symboltable.method.impl.MainMethod;

/**
 * @author Curtis Rabe, TJ Renninger
 *
 */
public class TestToken {
	
    /**
     * Test to make sure the Token class's getters work correctly
     * Note, this is mainly for test coverage
     */
    @Test
    public void testToken()
    {
    	Token token = new Token("name", "NAME", 1);

        assertEquals(token.getToken(), "name");
        assertEquals(token.getTokenName(), "NAME");
        assertEquals(token.getLineNumber(), 1);
        assertEquals(token.getChildren().size(), 0);
        
    }

    /**
     * Makes sure the reduce tokens method works correctly
     */
    @Test
    public void testReduceTokens()
    {
        Token t1 = new Token("Name1", "name1", 5);
        Token t2 = new Token("Name2", "name2", 2);
        Token t3 = new Token("Name3", "name3", 6);
        
        ArrayList<Token> children = new ArrayList<Token>();
        children.add(t1);
        children.add(t2);
        children.add(t3);
        
        Token newT = Token.reduceTokens(children, TokenTypes.EXP7);
        assertEquals(newT.lineNumber, 2);
        assertEquals(newT.childTokens, children);
        assertEquals(newT.tokenName, TokenTypes.EXP7.name());
    }
    
    /**
     * Make sure the parent for a class can be set and received
     * @author Raistlin Hess
     */
    @Test
    public void testSetAndGetClass()
    {
    	Token t1 = new Token("Bobby", TokenTypes.Id.name(), 1);
    	Class c = new Class("Person", null, null);
    	
    	assertEquals(null,t1.getParentClass());
    	
    	t1.setParentClass(c);
    	
    	assertEquals(c,t1.getParentClass());
    }
    
    /**
     * Make sure the parent for a method can be set and received
     * @author Raistlin Hess
     */
    @Test
    public void testSetAndGetMethod()
    {
    	Token t1 = new Token("Bobby", TokenTypes.Id.name(), 1);
    	Class c = new Class("Person", null, null);
    	MainMethod mainMethod = MainMethod.getInstance(c);
    	
    	assertEquals(null,t1.getParentMethod());
    	
    	t1.setParentMethod(mainMethod);
    	
    	assertEquals(mainMethod,t1.getParentMethod());
    }
    
    /**
     * Make sure that we can get the Type of the token, if any
     * @author Raistlin Hess
     */
    @Test
    public void testSetAndGetType()
    {
    	Token t1 = new Token("Bobby", TokenTypes.Id.name(), 1);
    	String type = "boolean";
    	
    	assertEquals(null,t1.getType());
    	
    	t1.setType(type);
    	
    	assertEquals(type,t1.getType());
    }
    
    /**
     * Tests the setting and getting of new "visited" variable of Tokens
     */
    @Test
    public void testSetAndGetVisited()
    {
    	Token t1 = new Token("Jimmy", TokenTypes.Id.name(), 1);
    	assertFalse(t1.isVisited());
    	t1.setVisited();
    	assertTrue(t1.isVisited());
    }
    
    /**
     * Test to make sure that a token is visited when passed into pass1
     */
    @Test
    public void testPass1SingleToken()
    {
    	String[] toks = {"EXP7", "EXP6", "EXP5", "EXP4", "EXP3", "EXP2", "EXP1", 
    					 "VAR_DECL_L", "VAR_DECL", "PROG", "CLASS_DECL_L", "MAIN_CLASS", 
    					 "CLASS_DECL", "M_METH_BODY", "METH_DECL_L", "METH_DECL", 
    					 "METH_BODY", "FORMAL_L", "FORMAL_R", "TYPE", "STMT", "STMT_P",
    					 "OP1", "OP2", "OP3", "OP4", "OP5", "OP6", "EXP_L", "EXP_R"};
    	for (String s : toks)
    	{
    		Token t = new Token(s, s, 1);
    		Token.pass1(t);
    		assertTrue(t.isVisited());
    	}
    }
    
    /**
     * Test to make sure that all tokens are visited when passed into pass1 as a list
     */
    @Test
    public void testPass1MultipleTokens()
    {
    	String[] toks = {"EXP7", "EXP6", "EXP5", "EXP4", "EXP3", "EXP2", "EXP1", 
    					 "VAR_DECL_L", "VAR_DECL", "PROG", "CLASS_DECL_L", "MAIN_CLASS", 
    					 "CLASS_DECL", "M_METH_BODY", "METH_DECL_L", "METH_DECL", 
    					 "METH_BODY", "FORMAL_L", "FORMAL_R", "TYPE", "STMT", "STMT_P",
    					 "OP1", "OP2", "OP3", "OP4", "OP5", "OP6", "EXP_L", "EXP_R"};
    	ArrayList<Token> tokens = new ArrayList<Token>();
    	for (String s : toks)
    	{
    		Token t = new Token(s, s, 1);
    		tokens.add(t);
    	}
    	Token.pass1(tokens);
    	for (Token t : tokens)
    	{
    		assertTrue(t.isVisited());
    	}
    }
    
    /**
     * Test to make sure that a token is visited when passed into pass2
     */
    @Test
    public void testPass2SingleToken()
    {
    	String[] toks = {"EXP7", "EXP6", "EXP5", "EXP4", "EXP3", "EXP2", "EXP1", 
    					 "VAR_DECL_L", "VAR_DECL", "PROG", "CLASS_DECL_L", "MAIN_CLASS", 
    					 "CLASS_DECL", "M_METH_BODY", "METH_DECL_L", "METH_DECL", 
    					 "METH_BODY", "FORMAL_L", "FORMAL_R", "TYPE", "STMT", "STMT_P",
    					 "OP1", "OP2", "OP3", "OP4", "OP5", "OP6", "EXP_L", "EXP_R"};
    	for (String s : toks)
    	{
    		Token t = new Token(s, s, 1);
    		Token.pass2(t);
    		assertTrue(t.isVisited());
    	}
    }
    
    /**
     * Test to make sure that all tokens are visited when passed into pass2 as a list
     */
    @Test
    public void testPass2MultipleTokens()
    {
    	String[] toks = {"EXP7", "EXP6", "EXP5", "EXP4", "EXP3", "EXP2", "EXP1", 
    					 "VAR_DECL_L", "VAR_DECL", "PROG", "CLASS_DECL_L", "MAIN_CLASS", 
    					 "CLASS_DECL", "M_METH_BODY", "METH_DECL_L", "METH_DECL", 
    					 "METH_BODY", "FORMAL_L", "FORMAL_R", "TYPE", "STMT", "STMT_P",
    					 "OP1", "OP2", "OP3", "OP4", "OP5", "OP6", "EXP_L", "EXP_R"};
    	ArrayList<Token> tokens = new ArrayList<Token>();
    	for (String s : toks)
    	{
    		Token t = new Token(s, s, 1);
    		tokens.add(t);
    	}
    	Token.pass2(tokens);
    	for (Token t : tokens)
    	{
    		assertTrue(t.isVisited());
    	}
    }
    
    /**
     * Test to make sure that a token is visited when passed into pass3
     */
    @Test
    public void testPass3SingleToken()
    {
    	String[] toks = {"EXP7", "EXP6", "EXP5", "EXP4", "EXP3", "EXP2", "EXP1", 
    					 "VAR_DECL_L", "VAR_DECL", "PROG", "CLASS_DECL_L", "MAIN_CLASS", 
    					 "CLASS_DECL", "M_METH_BODY", "METH_DECL_L", "METH_DECL", 
    					 "METH_BODY", "FORMAL_L", "FORMAL_R", "TYPE", "STMT", "STMT_P",
    					 "OP1", "OP2", "OP3", "OP4", "OP5", "OP6", "EXP_L", "EXP_R"};
    	for (String s : toks)
    	{
    		Token t = new Token(s, s, 1);
    		Token.pass3(t);
    		assertTrue(t.isVisited());
    	}
    }
    
    /**
     * Test to make sure that all tokens are visited when passed into pass3 as a list
     */
    @Test
    public void testPass3MultipleTokens()
    {
    	String[] toks = {"EXP7", "EXP6", "EXP5", "EXP4", "EXP3", "EXP2", "EXP1", 
    					 "VAR_DECL_L", "VAR_DECL", "PROG", "CLASS_DECL_L", "MAIN_CLASS", 
    					 "CLASS_DECL", "M_METH_BODY", "METH_DECL_L", "METH_DECL", 
    					 "METH_BODY", "FORMAL_L", "FORMAL_R", "TYPE", "STMT", "STMT_P",
    					 "OP1", "OP2", "OP3", "OP4", "OP5", "OP6", "EXP_L", "EXP_R"};
    	ArrayList<Token> tokens = new ArrayList<Token>();
    	for (String s : toks)
    	{
    		Token t = new Token(s, s, 1);
    		tokens.add(t);
    	}
    	Token.pass3(tokens);
    	for (Token t : tokens)
    	{
    		assertTrue(t.isVisited());
    	}
    }
    
    @Test
    public void testPass2()
    {
    	
    }
    
    @Test
    public void testPass3()
    {
    	
    }
}
