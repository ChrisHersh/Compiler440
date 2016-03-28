package tokenizer;

import java.util.ArrayList;


/**
 * This class holds the information needed for the tokens
 * 
 * @author Chris Hersh, Ian Keefer
 *
 */
public class Token
{
    String token;
    String tokenName;
    int lineNumber;
    ArrayList<Token> childTokens;

    
    /**
     * Method to turn multiple tokens into one, and it marks the line number as the lowest
     * @param tokens the children tokens
     * @param type the type of the expected token
     * @return the new token
     */
    public static Token reduceTokens(ArrayList<Token> tokens, TokenTypes type)
    {
        int lowestLineNum = Integer.MAX_VALUE;
        for(Token t : tokens)
        {
            if(t.lineNumber < lowestLineNum)
                lowestLineNum = t.lineNumber;
        }
        Token newToken = new Token(type.name(), lowestLineNum, tokens);
        
        return newToken;
    }
    
    /**
     * Blank constructor
     */
    public Token()
    {
    }
    
    /**
     * Constructor to set the values for the token
     * @param token
     * @param tokenName
     * @param lineNumber
     */
    public Token(String token, String tokenName, int lineNumber)
    {
        this.token = token;
        this.tokenName = tokenName;
        this.lineNumber = lineNumber;
        this.childTokens = new ArrayList<Token>();
    }
    
    /**
     * Constructor for non terminals
     * @param tokenName
     * @param lineNumber
     * @param children
     */
    public Token(String tokenName, int lineNumber, ArrayList<Token> children)
    {
        this.tokenName = tokenName;
        this.lineNumber = lineNumber;
        this.childTokens = children;
    }
    
    /**
     * @return token
     */
    public String getToken()
    {
        return token;
    }

    /**
     * @return tokenName
     */
    public String getTokenName()
    {
        return tokenName;
    }

    /**
     * @return lineNumber
     */
    public int getLineNumber()
    {
        return lineNumber;
    }
    
    /**
     * @return childTokens
     */
    public ArrayList<Token> getChildren() 
    {
    	return childTokens;
    }
}
