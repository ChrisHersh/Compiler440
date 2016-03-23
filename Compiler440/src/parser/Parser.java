package parser;

import java.util.Stack;

import tokenizer.Token;
import parser.states.State;

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
	Stack<Token> inputStack;
	Stack<State> stateStack;
	
	private Parser()
	{
		holdStack = new Stack<Token>();
		inputStack = new Stack<Token>();
		stateStack = new Stack<State>();
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
     * Getter to return the stateStack
     * @return the stateStack
     */
    public Stack<State> getStateStack() 
    {
		return stateStack;
	}

	/**
     * Getter to return the holdStack
     * @return the holdStack
     */
    public Stack<Token> getHoldStack()
    {
    	return holdStack;
    }
    
    /**
     * Getter to return the inputStack
     * @return the inputStack
     */
    public Stack<Token> getInputStack()
    {
    	return inputStack;
    }
}
