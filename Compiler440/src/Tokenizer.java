import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class handles the tokenizing of a file
 * 
 * @author Chris Hersh
 * 
 */
public class Tokenizer
{

    /**
     * Possible tokens that I am expecting to see
     * The order is based on how strict the regex is and to remove false positives
     *      ie: finding '=' instead of '=='
     * Note: I broke the format style a little here so the pairs would be a little more readable    
     *      Some similar types are on the same line for some space saving  
     */
    public static String[][] POSSIBLE_TOKENS = {
            //Single Comment
            { "^(//.*)", "SL_COMMENT" },
            //Parentheses, Brackets, and Braces.
            { "^(\\{)", "L_BRACE" }, { "^(})", "R_BRACE" },

            { "^(\\[)", "L_BRACKET" }, { "^(\\])", "R_BRACKET" },

            { "^(\\()", "L_PARA" },
            { "^(\\))", "R_PARA" },
            //Key Words
            { "^(int)(\\W|\\Z)", "INT" }, 
            { "^(double)(\\W|\\Z)", "DOUBLE" }, 
            { "^(char)(\\W|\\Z)", "CHAR" }, 
            { "^(boolean)(\\W|\\Z)", "BOOLEAN" }, 
            { "^(if)(\\W|\\Z)", "IF" },
            { "^(while)(\\W|\\Z)", "WHILE" },
            { "^(void)(\\W|\\Z)", "VOID" },

            //Symbols

            { "^(&&)", "AND" }, { "^(\\|\\|)", "OR" }, 
            { "^(==)", "EQ" }, 
            { "^(>=)", "GT_EQ" }, { "^(<=)", "LT_EQ" }, 
            { "^(>>)", "RT_SHIFT" }, { "^(<<)", "LFT_SHIFT" },
            { "^(->)", "PRT" },
            { "^(%)", "PERCENT" }, 
            { "^(!=)", "NOT_EQ" }, 
            { "^(;)", "SEMI" }, 
            { "^(\\+)", "PLUS" }, { "^(-)", "MINUS" }, 
            { "^(\\*)", "MULT" }, 
            { "^(=)", "ASGN" }, 
            { "^(\\.)", "PERIOD" },
            { "^(>)", "GT" }, { "^(<)", "LT" }, 
            { "^(!)", "NOT" },
            //Float
            { "^(\\d+\\.\\d+)", "FLOAT_NUM" },
            //Int Num
            { "^(\\d+)", "INT_NUM" },
            //ID -- Java only allows ids that start with a letter
            { "^([A-Za-z]\\w*)", "ID" },
            //Junk, if it's gotten this far without a match, it must be junk
            { "^(\\S+)", "JUNK" }

    };

    /**
     * This method will take a string filename, open it, and parse it line by line
     * Other than multiline comments every line is then fed into tokenizeString
     * Multiline comments are a bit harder to handle so most of this method is dealing with that
     * 
     * @param filename The name of the file that is going to be tokenized
     * @return An ArrayList of Tokens in the order they were found
     */
    public static ArrayList<Token> tokenizeProgram(String filename) throws FileNotFoundException
    {
        ArrayList<Token> tokens = new ArrayList<Token>();

        try
        {
            Scanner scan = new Scanner(new File(filename));

            int lineNum = 0;
            boolean ml_comment = false;
            String mlBuffer = "";
            int mlLineStart = 0;

            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                lineNum++;

                if (line.contains("*/") && ml_comment)
                {
                    ml_comment = false;
                    mlBuffer += line.substring(0, line.indexOf("*/") + 2);
                    line = line.substring(line.indexOf("*/") + 2);

                    Token tmp = new Token();
                    tmp.lineNumber = mlLineStart;
                    tmp.token = mlBuffer;
                    tmp.tokenName = "ML_COMMENT";
                    tokens.add(tmp);
                    mlBuffer = "";

                }
                else if (line.contains("/*"))
                {
                    ml_comment = true;
                    mlLineStart = lineNum;
                    String linetmp = line;

                    mlBuffer = line.substring(line.indexOf("/*"));
                    line = line.substring(0, line.indexOf("/*"));

                    tokens.addAll(tokenizeString(line, lineNum));

                    if (mlBuffer.contains("*/"))
                    {
                        ml_comment = false;
                        mlBuffer = mlBuffer.substring(mlBuffer.indexOf("/*"), mlBuffer.indexOf("*/") + 2);
                        Token tmp = new Token();
                        tmp.lineNumber = mlLineStart;
                        tmp.token = mlBuffer;
                        tmp.tokenName = "ML_COMMENT";
                        tokens.add(tmp);
                        mlBuffer = "";

                        line = linetmp.substring(linetmp.indexOf("*/") + 2);
                    }
                    else
                    {
                        mlBuffer += "\n";
                    }

                }
                else if (ml_comment)
                {
                    mlBuffer += line + "\n";
                }
                if (!ml_comment)
                    tokens.addAll(tokenizeString(line, lineNum));
            }

        }
        catch (FileNotFoundException e)
        {
            throw e;
        }
        return tokens;
    }

    /**
     * This method will take a string and create tokens for everything found in it
     * 
     * @param line The string that is exactly 1 line in the source code file
     * @param lineNumber The line number that the previous string was found on
     * @return An ArrayList of Tokens in the order they were found
     */
    public static ArrayList<Token> tokenizeString(String line, int lineNumber)
    {
        ArrayList<Token> tokens = new ArrayList<Token>();
        line = line.trim();
        while (!line.equals(""))
        {
            boolean found = false;
            for (int i = 0; i < POSSIBLE_TOKENS.length && !found; i++)
            {
                String[] combinations = POSSIBLE_TOKENS[i];
                Pattern p = Pattern.compile(combinations[0]);
                Matcher m = p.matcher(line);
                if (m.find())
                {
                    Token tmp = new Token();
                    tmp.lineNumber = lineNumber;
                    tmp.token = m.group(1);
                    tmp.tokenName = combinations[1];
                    tokens.add(tmp);

                    line = line.substring(m.end()).trim();
                    found = true;
                }
            }
        }

        return tokens;
    }
}
