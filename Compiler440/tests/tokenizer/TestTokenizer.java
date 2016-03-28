package tokenizer;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * This class is just for tests mainly for the regex
 * 
 * @author Chris Hersh
 *
 */
public class TestTokenizer
{

    /**
     * Test to make sure the Tokenizer can find single line comments correctly
     */
    @Test
    public void testComments()
    {
        String sl_comment = "//Declare an Int";
        ArrayList<Token> list = Tokenizer.tokenizeString(sl_comment, 0);
        assertEquals(list.size(), 1);
        assertEquals(list.get(0).token, sl_comment);

        assertEquals(list.get(0).tokenName, "SL_COMMENT");
    }

    /**
     * Test to make sure the Tokenizer can find braces correctly
     */
    @Test
    public void testBraces()
    {
        String braces = "{ }";
        ArrayList<Token> list = Tokenizer.tokenizeString(braces, 0);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).token, "{");
        assertEquals(list.get(1).token, "}");

        assertEquals(list.get(0).tokenName, "L_BRACE");
        assertEquals(list.get(1).tokenName, "R_BRACE");
    }

    /**
     * Test to make sure the Tokenizer can find parens correctly
     */
    @Test
    public void testParens()
    {
        String parens = "( )";
        ArrayList<Token> list = Tokenizer.tokenizeString(parens, 0);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).token, "(");
        assertEquals(list.get(1).token, ")");

        assertEquals(list.get(0).tokenName, "L_PARA");
        assertEquals(list.get(1).tokenName, "R_PARA");
    }

    /**
     * Test to make sure the Tokenizer can find square brackets correctly
     */
    @Test
    public void testBrackets()
    {
        String brackets = "[ ]";
        ArrayList<Token> list = Tokenizer.tokenizeString(brackets, 0);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).token, "[");
        assertEquals(list.get(1).token, "]");

        assertEquals(list.get(0).tokenName, "L_BRACKET");
        assertEquals(list.get(1).tokenName, "R_BRACKET");
    }

    /**
     * Test to make sure the Tokenizer can find any of the keywords correctly
     */
    @Test
    public void testKeywords()
    {
        String keywords = "int boolean if while void main class static extends new public else return System.out.println length this true false";
        ArrayList<Token> list = Tokenizer.tokenizeString(keywords, 0);
        assertEquals(list.size(), 18);
        assertEquals(list.get(0).token, "int");
        assertEquals(list.get(1).token, "boolean");
        assertEquals(list.get(2).token, "if");
        assertEquals(list.get(3).token, "while");
        assertEquals(list.get(4).token, "void");
        assertEquals(list.get(5).token, "main");
        assertEquals(list.get(6).token, "class");
        assertEquals(list.get(7).token, "static");
        assertEquals(list.get(8).token, "extends");
        assertEquals(list.get(9).token, "new");
        assertEquals(list.get(10).token, "public");
        assertEquals(list.get(11).token, "else");
        assertEquals(list.get(12).token, "return");
        assertEquals(list.get(13).token, "System.out.println");
        assertEquals(list.get(14).token, "length");
        assertEquals(list.get(15).token, "this");
        assertEquals(list.get(16).token, "true");
        assertEquals(list.get(17).token, "false");

        assertEquals(list.get(0).tokenName, "INT");
        assertEquals(list.get(1).tokenName, "BOOLEAN");
        assertEquals(list.get(2).tokenName, "IF");
        assertEquals(list.get(3).tokenName, "WHILE");
        assertEquals(list.get(4).tokenName, "VOID");
        assertEquals(list.get(5).tokenName, "MAIN");
        assertEquals(list.get(6).tokenName, "CLASS");
        assertEquals(list.get(7).tokenName, "STATIC");
        assertEquals(list.get(8).tokenName, "EXTENDS");
        assertEquals(list.get(9).tokenName, "NEW");
        assertEquals(list.get(10).tokenName, "PUBLIC");
        assertEquals(list.get(11).tokenName, "ELSE");
        assertEquals(list.get(12).tokenName, "RETURN");
        assertEquals(list.get(13).tokenName, "SYSTEM_OUT");
        assertEquals(list.get(14).tokenName, "LENGTH");
        assertEquals(list.get(15).tokenName, "THIS");
        assertEquals(list.get(16).tokenName, "TRUE");
        assertEquals(list.get(17).tokenName, "FALSE");
    }

    
    /**
     * Test to make sure the Tokenizer can find any of the symbols correctly
     */
    @Test
    public void testSymbols()
    {
        String keywords = "; + - * = . && || ! == > < >= <= != ,";
        ArrayList<Token> list = Tokenizer.tokenizeString(keywords, 0);
        assertEquals(list.size(), 16);
        assertEquals(list.get(0).token, ";");
        assertEquals(list.get(1).token, "+");
        assertEquals(list.get(2).token, "-");
        assertEquals(list.get(3).token, "*");
        assertEquals(list.get(4).token, "=");
        assertEquals(list.get(5).token, ".");
        assertEquals(list.get(6).token, "&&");
        assertEquals(list.get(7).token, "||");
        assertEquals(list.get(8).token, "!");
        assertEquals(list.get(9).token, "==");
        assertEquals(list.get(10).token, ">");
        assertEquals(list.get(11).token, "<");
        assertEquals(list.get(12).token, ">=");
        assertEquals(list.get(13).token, "<=");
        assertEquals(list.get(14).token, "!=");
        assertEquals(list.get(15).token, ",");

        assertEquals(list.get(0).tokenName, "SEMI");
        assertEquals(list.get(1).tokenName, "PLUS");
        assertEquals(list.get(2).tokenName, "MINUS");
        assertEquals(list.get(3).tokenName, "MULT");
        assertEquals(list.get(4).tokenName, "ASGN");
        assertEquals(list.get(5).tokenName, "PERIOD");
        assertEquals(list.get(6).tokenName, "AND");
        assertEquals(list.get(7).tokenName, "OR");
        assertEquals(list.get(8).tokenName, "NOT");
        assertEquals(list.get(9).tokenName, "EQ");
        assertEquals(list.get(10).tokenName, "GT");
        assertEquals(list.get(11).tokenName, "LT");
        assertEquals(list.get(12).tokenName, "GT_EQ");
        assertEquals(list.get(13).tokenName, "LT_EQ");
        assertEquals(list.get(14).tokenName, "NOT_EQ");
        assertEquals(list.get(15).tokenName, "COMMA");

    }

    /**
     * Test to make sure the Tokenizer can parse integers correctly
     */
    @Test
    public void testInts()
    {
        String brackets = "0 100 40000000 -50";
        ArrayList<Token> list = Tokenizer.tokenizeString(brackets, 0);
        assertEquals(list.size(), 5);
        assertEquals(list.get(0).token, "0");
        assertEquals(list.get(1).token, "100");
        assertEquals(list.get(2).token, "40000000");
        assertEquals(list.get(3).token, "-");
        assertEquals(list.get(4).token, "50");

        assertEquals(list.get(0).tokenName, "INT_NUM");
        assertEquals(list.get(1).tokenName, "INT_NUM");
        assertEquals(list.get(2).tokenName, "INT_NUM");
        assertEquals(list.get(3).tokenName, "MINUS");
        assertEquals(list.get(4).tokenName, "INT_NUM");
    }


    /**
     * Test to make sure the Tokenizer will find the IDs correctly
     */
    @Test
    public void testID()
    {
        String sl_comment = "x bestStringNameEver year2016yay";
        ArrayList<Token> list = Tokenizer.tokenizeString(sl_comment, 0);
        assertEquals(list.size(), 3);
        assertEquals(list.get(0).token, "x");
        assertEquals(list.get(1).token, "bestStringNameEver");
        assertEquals(list.get(2).token, "year2016yay");

        assertEquals(list.get(0).tokenName, "ID");
        assertEquals(list.get(1).tokenName, "ID");
        assertEquals(list.get(2).tokenName, "ID");
    }

    /**
     * Test to make sure the Tokenizer will label everything not found above as junk
     */
    @Test
    public void testJunk()
    {
        String sl_comment = "@@ # $ ^";
        ArrayList<Token> list = Tokenizer.tokenizeString(sl_comment, 0);
        assertEquals(list.size(), 4);
        assertEquals(list.get(0).token, "@@");
        assertEquals(list.get(1).token, "#");
        assertEquals(list.get(2).token, "$");
        assertEquals(list.get(3).token, "^");

        assertEquals(list.get(0).tokenName, "JUNK");
        assertEquals(list.get(1).tokenName, "JUNK");
        assertEquals(list.get(2).tokenName, "JUNK");
        assertEquals(list.get(3).tokenName, "JUNK");
    }

    /**
     * Test to make sure the Tokenizer can find multi line comments correctly
     * Note: due to multi line comments being processed in the tokenizeProgram method, 
     *      the test case is stored in a text file
     */
    @Test
    public void testMLComment() throws FileNotFoundException
    {
        ArrayList<Token> list = Tokenizer.tokenizeProgram("MLComment.txt");
        assertEquals(list.size(), 6);

        assertEquals(list.get(0).token, "before");
        assertEquals(list.get(1).token, "/*This is a\nmultiline\ncomment*/");
        assertEquals(list.get(2).token, "after");
        assertEquals(list.get(3).token, "before2");
        assertEquals(list.get(4).token, "/*single line*/");
        assertEquals(list.get(5).token, "after2");

        assertEquals(list.get(0).tokenName, "ID");
        assertEquals(list.get(1).tokenName, "ML_COMMENT");
        assertEquals(list.get(2).tokenName, "ID");
        assertEquals(list.get(3).tokenName, "ID");
        assertEquals(list.get(4).tokenName, "ML_COMMENT");
        assertEquals(list.get(5).tokenName, "ID");
    }

    /**
     * Test to make sure the Token class's getters work correctly
     * Note: this is mainly for test coverage
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
     * Test to make sure tokenizeProgram will throw an exception for a non-existant file
     * Note: this is mainly for test coverage
     */
    @Test(expected = FileNotFoundException.class)
    public void testFileNotFound() throws FileNotFoundException
    {
        Tokenizer.tokenizeProgram("QWERTYUIOPLKJHGFDASZXCVBNM.txt");
        assertTrue(true);

    }
}
