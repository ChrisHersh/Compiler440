package parser;

import java.util.Stack;

import tokenizer.Token;

/**
 * Class created for the parser. It should be comprised of
 * three independent stacks - the input stack, state stack, and hold stack
 * Just like the SymbolTable, there can only be one parser.
 * @author Curtis Rabe
 */
public class Parser
{
	
	private static Parser parser;
	Stack<Token> holdStack;
	
	private Parser()
	{
		holdStack = new Stack<Token>();
	}
	
	/**
     * @return singleton of SymbolTable
     */
    public static Parser getInstance() 
    {
    	if(parser == null) 
    	{
    		parser = new Parser();
    	}
    	return parser;
    }
    
    /**
     * Getter to return the holdStack
     * @return the holdStack
     */
    public Stack<Token> getHoldStack()
    {
    	return holdStack;
    }
}
