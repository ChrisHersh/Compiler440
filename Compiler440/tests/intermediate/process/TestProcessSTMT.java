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
 * @author Curtis Rabe
 * 
 * Test class for STMT
 *
 */
public class TestProcessSTMT
{

	/**
	 * Test for Process Pass1 on STMT -> { STMT_P }
	 */
	@Test
	public void testProcessPass1StartLBrace()
	{
		//first token of EXP_L
		Token t1 = new Token(TokenTypes.LBrace.name(), 1, null);
		t1.setVisited();
		Token t2 = new Token(TokenTypes.STMT_P.name(), 2, null);
		t2.setVisited();
		t2.setType("boolean");
		Token t3 = new Token(TokenTypes.RBrace.name(), 3, null);
		t3.setVisited();
		//EXP_R, the second token of EXP_L
		ArrayList<Token> tkns1 = new ArrayList<Token>();
		tkns1.add(t1);
		tkns1.add(t2);
		tkns1.add(t3);
		//The actual token of EXP_L to test
		Token t5 = new Token(TokenTypes.STMT.name(), 1, tkns1);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t5.setParentMethod(pm);
		t5.setParentClass(c1);
		assertFalse(t5.isVisited());
		Token.pass1(t5);
		assertEquals(t5.getType(), t5.getChildren().get(1).getType());
		assertEquals(t5.getChildren().get(0).getParentClass(), t5.getParentClass());
		assertEquals(t5.getChildren().get(0).getParentMethod(), t5.getParentMethod());
		assertEquals(t5.getChildren().get(1).getParentClass(), t5.getParentClass());
		assertEquals(t5.getChildren().get(1).getParentMethod(), t5.getParentMethod());
		assertTrue(t5.isVisited());
	}
	
	/**
	 * Test for Process Pass1 on STMT -> if ( EXP1 ) STMT else STMT
	 */
	@Test
	public void testProcessPass1StartIf()
	{
		Token t1 = new Token(TokenTypes.If.name(), 1, null);
		Token t2 = new Token(TokenTypes.LPara.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token t4 = new Token(TokenTypes.RPara.name(), 1, null);
		Token t5 = new Token(TokenTypes.STMT.name(), 1, null);
		Token t6 = new Token(TokenTypes.Else.name(), 1, null);
		Token t7 = new Token(TokenTypes.STMT.name(), 1, null);
		t1.setVisited();
		t2.setVisited();
		t2.setType("boolean");
		t3.setVisited();
		t4.setVisited();
		t5.setVisited();
		t6.setVisited();
		t7.setVisited();
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		tkns.add(t4);
		tkns.add(t5);
		tkns.add(t6);
		tkns.add(t7);
		Token t8 = new Token(TokenTypes.STMT.name(), 1, tkns);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t8.setParentMethod(pm);
		t8.setParentClass(c1);
		assertFalse(t8.isVisited());
		Token.pass1(t8);
		assertEquals(t8.getType(), t8.getChildren().get(2).getType());
		assertEquals(t8.getChildren().get(0).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(0).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(1).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(1).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(2).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(2).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(3).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(3).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(4).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(4).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(5).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(5).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(6).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(6).getParentMethod(), t8.getParentMethod());
		assertTrue(t8.isVisited());
	}

}
