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
		t3.setType("boolean");
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
		assertEquals(t8.getType(), t8.getChildren().get(3).getType());
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
	
	/**
	 * Test for Process Pass1 on STMT -> while ( EXP1 ) STMT
	 */
	@Test
	public void testProcessPass1StartWhile()
	{
		Token t1 = new Token(TokenTypes.While.name(), 1, null);
		Token t2 = new Token(TokenTypes.LPara.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token t4 = new Token(TokenTypes.RPara.name(), 1, null);
		Token t5 = new Token(TokenTypes.STMT.name(), 1, null);

		t1.setVisited();
		t2.setVisited();
		t3.setType("boolean");
		t3.setVisited();
		t4.setVisited();
		t5.setVisited();

		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		tkns.add(t4);
		tkns.add(t5);

		Token t8 = new Token(TokenTypes.STMT.name(), 1, tkns);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t8.setParentMethod(pm);
		t8.setParentClass(c1);
		assertFalse(t8.isVisited());
		Token.pass1(t8);
		assertEquals(t8.getType(), t8.getChildren().get(3).getType());
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

		assertTrue(t8.isVisited());
	}
	
	/**
	 * Test for Process Pass1 on STMT -> System.out.println ( EXP1 ) ;
	 */
	@Test
	public void testProcessPass1StartSystemOutPrintLn()
	{
		Token t1 = new Token(TokenTypes.SystemOutPrintln.name() , 1, null);
		Token t2 = new Token(TokenTypes.LPara.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token t4 = new Token(TokenTypes.RPara.name(), 1, null);
		Token t5 = new Token(TokenTypes.SemiColon.name(), 1, null);

		t1.setVisited();
		t2.setVisited();
		t3.setType("boolean");
		t3.setVisited();
		t4.setVisited();
		t5.setVisited();

		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		tkns.add(t4);
		tkns.add(t5);

		Token t8 = new Token(TokenTypes.STMT.name(), 1, tkns);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t8.setParentMethod(pm);
		t8.setParentClass(c1);
		assertFalse(t8.isVisited());
		Token.pass1(t8);
		assertEquals(t8.getType(), t8.getChildren().get(3).getType());
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

		assertTrue(t8.isVisited());
	}
	
	/**
	 * Test for Process Pass1 on STMT -> id = EXP1 ;
	 * At this point in pass1, this id is not adding anything new, it is simply
	 * accessing what already exists. Also, pass1 is not for verifying, that is pass2,
	 * so, pass1 does not add id to the symbol table. Instead, it accesses EXP1. Tested
	 * alone this works, and since Chad coded EXP1, I gave my EXP1 token children that were
	 * "visited", and it goes through his code perfectly fine, proving that the recursive
	 * method call does in fact also work. :)
	 */
	@Test
	public void testProcessPass1StartIdEq()
	{
		Token t1 = new Token(TokenTypes.Id.name() , 1, null);
		Token t2 = new Token(TokenTypes.Assignment.name(), 1, null);
		
		Token temp1 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token temp2 = new Token(TokenTypes.OP1.name(), 1, null);
		Token temp3 = new Token(TokenTypes.EXP2.name(), 1, null);
		temp1.setVisited();
		temp2.setVisited();
		temp3.setVisited();
		ArrayList<Token> tkn = new ArrayList<Token>();
		tkn.add(temp1);
		tkn.add(temp2);
		tkn.add(temp3);
		
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, tkn);
		Token t4 = new Token(TokenTypes.SemiColon.name(), 1, null);

		t1.setType("boolean");

		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		tkns.add(t4);

		Token t8 = new Token(TokenTypes.STMT.name(), 1, tkns);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t8.setParentMethod(pm);
		t8.setParentClass(c1);
		assertFalse(t8.isVisited());
		Token.pass1(t8);
		assertEquals(t8.getType(), t8.getChildren().get(0).getType());
		assertEquals(t8.getChildren().get(0).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(0).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(1).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(1).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(2).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(2).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(3).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(3).getParentMethod(), t8.getParentMethod());


		assertTrue(t8.isVisited());
	}
	
	/**
	 * Test for Process Pass1 on STMT -> id [ EXP1 ] = EXP1 ;
	 * At this point in pass1, this id is not adding anything new, it is simply
	 * accessing what already exists. Also, pass1 is not for verifying, that is pass2,
	 * so, pass1 does not add id to the symbol table. Instead, it accesses EXP1. Tested
	 * alone this works, and since Chad coded EXP1, I gave my EXP1 tokens children that were
	 * "visited", and it goes through his code perfectly fine, proving that the recursive
	 * method call does in fact also work. :)
	 */
	@Test
	public void testProcessPass1StartIdArray()
	{
		Token t1 = new Token(TokenTypes.Id.name() , 1, null);
		Token t2 = new Token(TokenTypes.LBracket.name(), 1, null);
		
		Token temp1 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token temp2 = new Token(TokenTypes.OP1.name(), 1, null);
		Token temp3 = new Token(TokenTypes.EXP2.name(), 1, null);
		temp1.setVisited();
		temp2.setVisited();
		temp3.setVisited();
		ArrayList<Token> tkn = new ArrayList<Token>();
		tkn.add(temp1);
		tkn.add(temp2);
		tkn.add(temp3);
		
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, tkn);
		Token t4 = new Token(TokenTypes.RBracket.name(), 1, null);
		Token t5 = new Token(TokenTypes.Assignment.name(), 1, null);
		
		Token temp4 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token temp5 = new Token(TokenTypes.OP1.name(), 1, null);
		Token temp6 = new Token(TokenTypes.EXP2.name(), 1, null);
		temp4.setVisited();
		temp5.setVisited();
		temp6.setVisited();
		ArrayList<Token> tkn1 = new ArrayList<Token>();
		tkn1.add(temp4);
		tkn1.add(temp5);
		tkn1.add(temp6);

		Token t6 = new Token(TokenTypes.EXP1.name(), 1, tkn1);
		
		t1.setType("boolean");

		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		tkns.add(t4);
		tkns.add(t5);
		tkns.add(t6);

		Token t8 = new Token(TokenTypes.STMT.name(), 1, tkns);
		Class c1 = new Class("ClassName", null, null);
		PublicMethod pm = new PublicMethod("MethodName", null, VariableType.BOOLEAN, null);
		t8.setParentMethod(pm);
		t8.setParentClass(c1);
		assertFalse(t8.isVisited());
		Token.pass1(t8);
		assertEquals(t8.getType(), t8.getChildren().get(0).getType());
		assertEquals(t8.getChildren().get(0).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(0).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(1).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(1).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(2).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(2).getParentMethod(), t8.getParentMethod());
		assertEquals(t8.getChildren().get(3).getParentClass(), t8.getParentClass());
		assertEquals(t8.getChildren().get(3).getParentMethod(), t8.getParentMethod());

		assertTrue(t8.isVisited());
	}
	
	
	
//--------------------------------------------------------------------------------------------------
	/**
	 * A test to make sure that STMT can make it through pass 3 and process its children
	 * for the rule: if ( EXP1 ) STMT1 else STMT2
	 * @author Jared Good
	 */
	@Test
	public void testProcessPass3If()
	{		
		//Children for STMT
		Token t1 = new Token(TokenTypes.If.name(), 1, null);
		Token t2 = new Token(TokenTypes.LPara.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token t4 = new Token(TokenTypes.RPara.name(), 1, null);
		Token t5 = new Token(TokenTypes.STMT.name(), 1, null);
		Token t6 = new Token(TokenTypes.Else.name(), 1, null);
		Token t7 = new Token(TokenTypes.STMT.name(), 1, null);
		t1.setVisited();
		t2.setVisited();
		t3.setVisited();
		t4.setVisited();
		t5.setVisited();
		t6.setVisited();
		t7.setVisited();
		
		// Adds tokens to ArrayList to add to STMT
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		tkns.add(t4);
		tkns.add(t5);
		tkns.add(t6);
		tkns.add(t7);
		
		
		// Main STMT		
		Token t8 = new Token(TokenTypes.STMT.name(), 1, tkns);
		
		// Checks that the token properly goes through pass 3
		assertFalse(t8.isVisited());
		Token.pass3(t8);
		assertTrue(t8.isVisited());
		
		// Checks that the generated code is what is expected
		String code = t8.getCode().toString();
		String test = "START_EXP1:\n" + "\tJMP [Value], ELSE\n" + "\tJMP END\n" + "ELSE:\n" + "END:\n";
		assertEquals(code, test);
		
	}
	
	/**
	 * A test to make sure that STMT can make it through pass 3 and process its children
	 * for the rule: { STMT_P }
	 * @author Jared Good
	 */
	@Test
	public void testProcessPass3LBrace()
	{		
		
		//Children for STMT
		Token t1 = new Token(TokenTypes.LBrace.name(), 1, null);
		Token t2 = new Token(TokenTypes.STMT_P.name(), 1, null);
		Token t3 = new Token(TokenTypes.RBrace.name(), 1, null);
		t1.setVisited();
		t2.setVisited();
		t3.setVisited();
		
		// Adds tokens to ArrayList to add to STMT
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		
		// Main STMT		
		Token t4 = new Token(TokenTypes.STMT_P.name(), 1, tkns);
		
		// Checks that the token properly goes through pass 3
		assertFalse(t4.isVisited());
		Token.pass3(t4);
		assertTrue(t4.isVisited());
		
	}
	
	/**
	 * A test to make sure that STMT can make it through pass 3 and process its children
	 * for the rule: while ( EXP1 ) STMT
	 * @author Jared Good
	 */
	@Test
	public void testProcessPass3While()
	{		
		
		//Children for STMT
		Token t1 = new Token(TokenTypes.While.name(), 1, null);
		Token t2 = new Token(TokenTypes.LPara.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token t4 = new Token(TokenTypes.RPara.name(), 1, null);
		Token t5 = new Token(TokenTypes.STMT.name(), 1, null);
		t1.setVisited();
		t2.setVisited();
		t3.setVisited();
		t4.setVisited();
		t5.setVisited();
		
		// Adds tokens to ArrayList to add to STMT
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		tkns.add(t4);
		tkns.add(t5);
		
		// Main STMT		
		Token t6 = new Token(TokenTypes.STMT.name(), 1, tkns);
		
		// Checks that the token properly goes through pass 3
		assertFalse(t6.isVisited());
		Token.pass3(t6);
		assertTrue(t6.isVisited());
		
		// Checks that the generated code is what is expected
		String code = t6.getCode().toString();
		String test = "START_EXP1:\n" + "\tJMP [Value], END\n" + "\tJMP START_EXP1\n" + "END:\n";
		assertEquals(code, test);
		
	}
	
	/**
	 * A test to make sure that STMT can make it through pass 3 and process its children
	 * for the rule: System.out.Println ( EXP1 ) ;
	 * @author Jared Good
	 */
	@Test
	public void testProcessPass3SystemOutPrintLn()
	{		
		
		//Children for STMT
		Token t1 = new Token(TokenTypes.SystemOutPrintln.name(), 1, null);
		Token t2 = new Token(TokenTypes.LPara.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token t4 = new Token(TokenTypes.RPara.name(), 1, null);
		Token t5 = new Token(TokenTypes.SemiColon.name(), 1, null);
		t1.setVisited();
		t2.setVisited();
		t3.setVisited();
		t4.setVisited();
		t5.setVisited();
		
		// Adds tokens to ArrayList to add to STMT
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		tkns.add(t4);
		tkns.add(t5);
		
		// Main STMT		
		Token t6 = new Token(TokenTypes.STMT.name(), 1, tkns);
		
		// Checks that the token properly goes through pass 3
		assertFalse(t6.isVisited());
		Token.pass3(t6);
		assertTrue(t6.isVisited());
		
		// Checks that the generated code is what is expected
		String code = t6.getCode().toString();
		String test = "\tLI [Value], OUTPUT_REGISTER\n" + "\tLI [TYPE], OUTPUT_REGISTER2\n" + "\tSYSCALL\n";
		assertEquals(code, test);
		
	}
	
	/**
	 * A test to make sure that STMT can make it through pass 3 and process its children
	 * for the rule: id = EXP1 ;
	 * @author Jared Good
	 */
	@Test
	public void testProcessPass3IdAssignment()
	{		
		
		//Children for STMT
		Token t1 = new Token(TokenTypes.Id.name(), 1, null);
		Token t2 = new Token(TokenTypes.Assignment.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token t4 = new Token(TokenTypes.SemiColon.name(), 1, null);
		t1.setVisited();
		t2.setVisited();
		t3.setVisited();
		t4.setVisited();
		
		// Adds tokens to ArrayList to add to STMT
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		tkns.add(t4);
		
		// Main STMT		
		Token t5 = new Token(TokenTypes.STMT.name(), 1, tkns);
		
		// Checks that the token properly goes through pass 3
		assertFalse(t5.isVisited());
		Token.pass3(t5);
		assertTrue(t5.isVisited());
		
		// Checks that the generated code is what is expected
		String code = t5.getCode().toString();
		String test = "\tSW [Value], [id]\n";
		assertEquals(code, test);
		
	}
	
	/**
	 * A test to make sure that STMT can make it through pass 3 and process its children
	 * for the rule: id [ EXP1 ] = EXP1 ;
	 * @author Jared Good
	 */
	@Test
	public void testProcessPass3IdLBracket()
	{		
		
		//Children for STMT
		Token t1 = new Token(TokenTypes.Id.name(), 1, null);
		Token t2 = new Token(TokenTypes.LBracket.name(), 1, null);
		Token t3 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token t4 = new Token(TokenTypes.RBracket.name(), 1, null);
		Token t5 = new Token(TokenTypes.Assignment.name(), 1, null);
		Token t6 = new Token(TokenTypes.EXP1.name(), 1, null);
		Token t7 = new Token(TokenTypes.SemiColon.name(), 1, null);
		t1.setVisited();
		t2.setVisited();
		t3.setVisited();
		t4.setVisited();
		t5.setVisited();
		t6.setVisited();
		t7.setVisited();
		
		// Adds tokens to ArrayList to add to STMT
		ArrayList<Token> tkns = new ArrayList<Token>();
		tkns.add(t1);
		tkns.add(t2);
		tkns.add(t3);
		tkns.add(t4);
		tkns.add(t5);
		tkns.add(t6);
		tkns.add(t7);
		
		// Main STMT		
		Token t8 = new Token(TokenTypes.STMT.name(), 1, tkns);
		
		// Checks that the token properly goes through pass 3
		assertFalse(t8.isVisited());
		Token.pass3(t8);
		assertTrue(t8.isVisited());
		
		// Checks that the generated code is what is expected
		String code = t8.getCode().toString();
		String test = "\tSLL [Value1], 2, [Value1]\n" + "\tADD [Value1], [id], [Value1]\n" + "\tSW [Value2], [Value1]\n";
		assertEquals(code, test);
		
	}
}
