package tokenizer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
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

        assertEquals(list.get(0).tokenName, TokenTypes.SLComment.name());
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

        assertEquals(list.get(0).tokenName, TokenTypes.LBrace.name());
        assertEquals(list.get(1).tokenName, TokenTypes.RBrace.name());
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

        assertEquals(list.get(0).tokenName, TokenTypes.LPara.name());
        assertEquals(list.get(1).tokenName, TokenTypes.RPara.name());
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

        assertEquals(list.get(0).tokenName, TokenTypes.LBracket.name());
        assertEquals(list.get(1).tokenName, TokenTypes.RBracket.name());
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

        assertEquals(list.get(0).tokenName, TokenTypes.Int.name() );
        assertEquals(list.get(1).tokenName, TokenTypes.Boolean.name());
        assertEquals(list.get(2).tokenName, TokenTypes.If.name());
        assertEquals(list.get(3).tokenName, TokenTypes.While.name());
        assertEquals(list.get(4).tokenName, TokenTypes.Void.name());
        assertEquals(list.get(5).tokenName, TokenTypes.Main.name());
        assertEquals(list.get(6).tokenName, TokenTypes.Class.name());
        assertEquals(list.get(7).tokenName, TokenTypes.Static.name());
        assertEquals(list.get(8).tokenName, TokenTypes.Extends.name());
        assertEquals(list.get(9).tokenName, TokenTypes.New.name());
        assertEquals(list.get(10).tokenName, TokenTypes.Public.name());
        assertEquals(list.get(11).tokenName, TokenTypes.Else.name());
        assertEquals(list.get(12).tokenName, TokenTypes.Return.name());
        assertEquals(list.get(13).tokenName, TokenTypes.SystemOutPrintln.name());
        assertEquals(list.get(14).tokenName, TokenTypes.Length.name());
        assertEquals(list.get(15).tokenName, TokenTypes.This.name());
        assertEquals(list.get(16).tokenName, TokenTypes.True.name());
        assertEquals(list.get(17).tokenName, TokenTypes.False.name());
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

        assertEquals(list.get(0).tokenName, TokenTypes.SemiColon.name());
        assertEquals(list.get(1).tokenName, TokenTypes.Plus.name());
        assertEquals(list.get(2).tokenName, TokenTypes.Minus.name());
        assertEquals(list.get(3).tokenName, TokenTypes.Mult.name());
        assertEquals(list.get(4).tokenName, TokenTypes.Assignment.name());
        assertEquals(list.get(5).tokenName, TokenTypes.Period.name());
        assertEquals(list.get(6).tokenName, TokenTypes.And.name());
        assertEquals(list.get(7).tokenName, TokenTypes.Or.name());
        assertEquals(list.get(8).tokenName, TokenTypes.Not.name());
        assertEquals(list.get(9).tokenName, TokenTypes.Equals.name());
        assertEquals(list.get(10).tokenName, TokenTypes.Gt.name());
        assertEquals(list.get(11).tokenName, TokenTypes.Lt.name());
        assertEquals(list.get(12).tokenName, TokenTypes.GtEquals.name());
        assertEquals(list.get(13).tokenName, TokenTypes.LtEquals.name());
        assertEquals(list.get(14).tokenName, TokenTypes.NotEquals.name());
        assertEquals(list.get(15).tokenName, TokenTypes.Comma.name());

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

        assertEquals(list.get(0).tokenName, TokenTypes.IntNum.name());
        assertEquals(list.get(1).tokenName, TokenTypes.IntNum.name());
        assertEquals(list.get(2).tokenName, TokenTypes.IntNum.name());
        assertEquals(list.get(3).tokenName, TokenTypes.Minus.name());
        assertEquals(list.get(4).tokenName, TokenTypes.IntNum.name());
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

        assertEquals(list.get(0).tokenName, TokenTypes.Id.name());
        assertEquals(list.get(1).tokenName, TokenTypes.Id.name());
        assertEquals(list.get(2).tokenName, TokenTypes.Id.name());
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

        assertEquals(list.get(0).tokenName, TokenTypes.Junk.name());
        assertEquals(list.get(1).tokenName, TokenTypes.Junk.name());
        assertEquals(list.get(2).tokenName, TokenTypes.Junk.name());
        assertEquals(list.get(3).tokenName, TokenTypes.Junk.name());
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

        assertEquals(list.get(0).tokenName, TokenTypes.Id.name());
        assertEquals(list.get(1).tokenName, TokenTypes.MLComment.name());
        assertEquals(list.get(2).tokenName, TokenTypes.Id.name());
        assertEquals(list.get(3).tokenName, TokenTypes.Id.name());
        assertEquals(list.get(4).tokenName, TokenTypes.MLComment.name());
        assertEquals(list.get(5).tokenName, TokenTypes.Id.name());
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
