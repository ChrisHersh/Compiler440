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
