package tokenizer;
/**
 * This class holds the information needed for the tokens
 * 
 * @author Chris Hersh
 *
 */
public class Token
{
    String token;

    String tokenName;

    int lineNumber;

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
    }
    
    public String getToken()
    {
        return token;
    }

    public String getTokenName()
    {
        return tokenName;
    }

    public int getLineNumber()
    {
        return lineNumber;
    }
}
