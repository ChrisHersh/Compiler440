package parser;

import java.util.ArrayList;
import java.util.Stack;

import tokenizer.Token;
import parser.states.ParserException;
import parser.states.State;

/**
 * Class created for the parser. It should be comprised of
 * three independent stacks - the input stack, state stack, and hold stack
 * Just like the SymbolTable, there can only be one parser.
 * @author Curtis Rabe, TJ Renninger, Michael Zimmerman, Jared Good
 */
public class Parser
{
	private static Parser parser;
	private State currentState;
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
     * For testing
     * Resets the parser so the tests can run independent of each other
     */
    public static void resetParser()
    {
        parser = new Parser();
    }
    
    /**
     * Changes the current state
     * @param newState that will be the current state
     */
    public void changeState(State newState)
	{
		currentState = newState;
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
    
    /**
     * Returns the current state
     * Mainly for tests
     * @return
     */
    public State getCurrentState()
    {
        return currentState;
    }
    
    /**
     * @author TJ Renninger
     * @return the top element of the state stack and remove it
     */
    public State popStateStack()
    {
    	return stateStack.pop();
    }
    
    /**
     * @author TJ Renninger
     * @return the top element of the state stack but keep it
     */
    public State peekStateStack()
    {
    	return stateStack.peek();
    }
    
    /**
     * @author TJ Renninger
     * Adds a state to the top of the state stack
     * @param state to be added to the state stack
     */
    public void pushStateStack(State state)
    {
    	stateStack.push(state);
    }
    
    /**
     * @author TJ Renninger
     * @return the top element of the hold stack and remove it
     */
    public Token popHoldStack()
    {
    	return holdStack.pop();
    }
    
    /**
     * @author TJ Renninger
     * @return the top element of the hold stack but keep it
     */
    public Token peekHoldStack()
    {
    	return holdStack.peek();
    }
    
    /**
     * @author TJ Renninger
     * Adds a token to the top of the hold stack
     * @param token to be added to the hold stack
     */
    public void pushHoldStack(Token token)
    {
    	holdStack.push(token);
    }
    
    /**
     * @author TJ Renninger
     * @return the top element of the input stack and remove it
     */
    public Token popInputStack()
    {
    	return inputStack.pop();
    }
    
    /**
     * @author TJ Renninger
     * @return the top element of the input stack but keep it
     */
    public Token peekInputStack()
    {
    	return inputStack.peek();
    }
    
    /**
     * @author TJ Renninger
     * Adds a token to the top of the input stack
     * @param token to be added to the input stack
     */
    public void pushInputStack(Token token)
    {
    	inputStack.push(token);
    }
    
    /**
     * puts the ArrayList of tokens into the parser's input stack
     * Daniel Breitigan & matt Mousetis
     * @param tok - ArrayList of tokens
     */
    public void createInputStack(ArrayList<Token> tok)
    {
        
        int size = tok.size();
        for(int i = size - 1; i >= 0; i--)
        {
            pushInputStack(tok.get(i));
        }
    }
    /**
     * Method to tell the state which shift to use depending on the next token.
     * @Author Daniel Breitigan & Matt Mousetis
     * @throws ParserException
     */
    public void NextState() throws ParserException
    {
        switch (peekInputStack().getTokenName())
        {
        case "EXP7":
            peekStateStack().shiftEXP7();
            break;
        case "EXP6":
            peekStateStack().shiftEXP6();
            break;
        case "EXP5":
            peekStateStack().shiftEXP5();
            break;
        case "EXP4":
            peekStateStack().shiftEXP4();
            break;
        case "EXP3":
            peekStateStack().shiftEXP3();
            break;
        case "EXP2":
            peekStateStack().shiftEXP2();
            break;
        case "EXP1":
            peekStateStack().shiftEXP1();
            break;
        case "Id":
            peekStateStack().shiftId();
            break;
        case "IntNum":
            peekStateStack().shiftIntegerLiteral();
            break;
        case "True":
            peekStateStack().shiftTrue();
            break;
        case "False":
            peekStateStack().shiftFalse();
            break;
        case "This":
            peekStateStack().shiftThis();
            break;
        case "New":
            peekStateStack().shiftNew();
            break;
        case "Not":
            peekStateStack().shiftExclamation();
            break;
        case "LBracket":
            peekStateStack().shiftLeftBracket();
            break;
        case "LBrace":
            peekStateStack().shiftLeftBrace();
            break;
        case "LPara":
            peekStateStack().shiftLeftPara();
            break;
        case "RPara":
            peekStateStack().shiftRightPara();
            break;
        case "VAR_DECL_L":
            peekStateStack().shiftVAR_DECL_L();
            break;
        case "VAR_DECL":
            peekStateStack().shiftVAR_DECL();
            break;
        case "Public":
            peekStateStack().shiftPublic();
            break;
        case "Static":
            peekStateStack().shiftStatic();
            break;
        case "Void":
            peekStateStack().shiftVoid();
            break;
        case "Main":
            peekStateStack().shiftMain();
            break;
            
            
//      These are not used at the moment, but could be needed later
//        case "RBracket":
//            peekStateStack().shiftRightBracket();
//            break;
//        case "RBrace":
//            peekStateStack().shiftRightBrace();
//            break;
        }
    }
}
