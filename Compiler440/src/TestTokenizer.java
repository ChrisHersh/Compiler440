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
        String keywords = "int double char boolean if while void";
        ArrayList<Token> list = Tokenizer.tokenizeString(keywords, 0);
        assertEquals(list.size(), 7);
        assertEquals(list.get(0).token, "int");
        assertEquals(list.get(1).token, "double");
        assertEquals(list.get(2).token, "char");
        assertEquals(list.get(3).token, "boolean");
        assertEquals(list.get(4).token, "if");
        assertEquals(list.get(5).token, "while");
        assertEquals(list.get(6).token, "void");

        assertEquals(list.get(0).tokenName, "INT");
        assertEquals(list.get(1).tokenName, "DOUBLE");
        assertEquals(list.get(2).tokenName, "CHAR");
        assertEquals(list.get(3).tokenName, "BOOLEAN");
        assertEquals(list.get(4).tokenName, "IF");
        assertEquals(list.get(5).tokenName, "WHILE");
        assertEquals(list.get(6).tokenName, "VOID");
    }

    /**
     * Test to make sure the Tokenizer can find any of the symbols correctly
     */
    @Test
    public void testSymbols()
    {
        String keywords = "; + - * = . && || ! == > < >= <= >> << -> % !=";
        ArrayList<Token> list = Tokenizer.tokenizeString(keywords, 0);
        assertEquals(list.size(), 19);
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
        assertEquals(list.get(14).token, ">>");
        assertEquals(list.get(15).token, "<<");
        assertEquals(list.get(16).token, "->");
        assertEquals(list.get(17).token, "%");
        assertEquals(list.get(18).token, "!=");

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
        assertEquals(list.get(14).tokenName, "RT_SHIFT");
        assertEquals(list.get(15).tokenName, "LFT_SHIFT");
        assertEquals(list.get(16).tokenName, "PRT");
        assertEquals(list.get(17).tokenName, "PERCENT");
        assertEquals(list.get(18).tokenName, "NOT_EQ");

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
     * Test to make sure the Tokenizer can parse floats correctly
     */
    @Test
    public void testFloats()
    {
        String brackets = "0.0 100.56 .5 -50.5";
        ArrayList<Token> list = Tokenizer.tokenizeString(brackets, 0);
        assertEquals(list.size(), 6);
        assertEquals(list.get(0).token, "0.0");
        assertEquals(list.get(1).token, "100.56");
        assertEquals(list.get(2).token, ".");
        assertEquals(list.get(3).token, "5");
        assertEquals(list.get(4).token, "-");
        assertEquals(list.get(5).token, "50.5");

        assertEquals(list.get(0).tokenName, "FLOAT_NUM");
        assertEquals(list.get(1).tokenName, "FLOAT_NUM");
        assertEquals(list.get(2).tokenName, "PERIOD");
        assertEquals(list.get(3).tokenName, "INT_NUM");
        assertEquals(list.get(4).tokenName, "MINUS");
        assertEquals(list.get(5).tokenName, "FLOAT_NUM");
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
        Token t = new Token();
        t.token = "name";
        t.tokenName = "NAME";
        t.lineNumber = 1;

        assertEquals(t.getToken(), "name");
        assertEquals(t.getTokenName(), "NAME");
        assertEquals(t.getLineNumber(), 1);
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

    /**
     * Test to make sure the program runs....because test coverage was below 99%
     * This was a last ditch effort to maximize code coverage for no reason at all
     */
    @Test
    public void testMain()
    {
        ByteArrayInputStream in = new ByteArrayInputStream("test.txt".getBytes());
        System.setIn(in);

        try
        {
            Runner.main(new String[0]);
            assertTrue(true);
        }
        catch (FileNotFoundException e1)
        {
            assertTrue(false);
        }
        catch (UnsupportedEncodingException e2)
        {
            assertTrue(false);
        }

    }
}
