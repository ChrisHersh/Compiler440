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
