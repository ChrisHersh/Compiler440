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
 * @author Curtis Rabe, TJ Renninger, Michael Zimmerman, Jared Good, Daniel Breitigan, Matt Mousetis
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
    public void nextState() throws ParserException
    {
        switch (peekInputStack().getTokenName())
        {
        case "EXP7":
            getCurrentState().shiftEXP7();
            break;
        case "EXP6":
            getCurrentState().shiftEXP6();
            break;
        case "EXP5":
            getCurrentState().shiftEXP5();
            break;
        case "EXP4":
            getCurrentState().shiftEXP4();
            break;
        case "EXP3":
            getCurrentState().shiftEXP3();
            break;
        case "EXP2":
            getCurrentState().shiftEXP2();
            break;
        case "EXP1":
            getCurrentState().shiftEXP1();
            break;
        case "Id":
            getCurrentState().shiftId();
            break;
        case "IntNum":
            getCurrentState().shiftIntegerLiteral();
            break;
        case "True":
            getCurrentState().shiftTrue();
            break;
        case "False":
            getCurrentState().shiftFalse();
            break;
        case "This":
            getCurrentState().shiftThis();
            break;
        case "New":
            getCurrentState().shiftNew();
            break;
        case "Exclamation":
            getCurrentState().shiftExclamation();
            break;
        case "LBracket":
            getCurrentState().shiftLeftBracket();
            break;
        case "LBrace":
            getCurrentState().shiftLeftBrace();
            break;
        case "LPara":
            getCurrentState().shiftLeftPara();
            break;
        case "RPara":
            getCurrentState().shiftRightPara();
            break;
        case "VAR_DECL_L":
            getCurrentState().shiftVAR_DECL_L();
            break;
        case "VAR_DECL":
            getCurrentState().shiftVAR_DECL();
            break;
        case "Public":
            getCurrentState().shiftPublic();
            break;
        case "Static":
            getCurrentState().shiftStatic();
            break;
        case "Void":
            getCurrentState().shiftVoid();
            break;
        case "Main":
            getCurrentState().shiftMain();
            break;
        case "RBracket":
            getCurrentState().shiftRightBracket();
            break;
        case "RBrace":
            getCurrentState().shiftRightBrace();
            break;
        case "int":
            getCurrentState().shiftInt();
            break;
        case "Boolean":
            getCurrentState().shiftBoolean();
            break;
        case "If":
            getCurrentState().shiftIf();
            break;
        case "While":
            getCurrentState().shiftWhile();
            break;
        case "Class":
            getCurrentState().shiftClass();
            break;
        case "Extends":
            getCurrentState().shiftExtends();
            break;
        case "Else":
            getCurrentState().shiftElse();
            break;
        case "Return":
            getCurrentState().shiftReturn();
            break;
        case "SystemOutPrintln":
            getCurrentState().shiftSystemOutPrintln();
            break;
        case "Length":
            getCurrentState().shiftLength();
            break;
        case "Comma":
            getCurrentState().shiftComa();
            break;
        case "And":
            getCurrentState().shiftAnd();
            break;
        case "Or":
            getCurrentState().shiftOr();
            break;
        case "Equals":
            getCurrentState().shiftEquals();
            break;
        case "GtEquals":
            getCurrentState().shiftGtEquals();
            break;
        case "LtEquals":
            getCurrentState().shiftLtEquals();
            break;
        case "NotEquals":
            getCurrentState().shiftNotEquals();
            break;
        case "SemiColon":
            getCurrentState().shiftSemiColon();
            break;
        case "Plus":
            getCurrentState().shiftPlus();
            break;
        case "Minus":
            getCurrentState().shiftMinus();
            break;
        case "Mult":
            getCurrentState().shiftMult();
            break;
        case "Assignment":
            getCurrentState().shiftAssignment();
            break;
        case "Period":
            getCurrentState().shiftPeriod();
            break;
        case "Gt":
            getCurrentState().shiftGt();
            break;
        case "Lt":
            getCurrentState().shiftLt();
            break;
        case "Not":
            getCurrentState().shiftNot();
            break;
        case "Prog":
            getCurrentState().shiftProg();
            break;
        case "CLASS_DECL_L":
            getCurrentState().shiftCLASS_DECL_L();
            break;
        case "MAIN_CLASS":
            getCurrentState().shiftMAIN_CLASS();
            break;
        case "MAIN_METHOD":
            getCurrentState().shiftMAIN_METHOD();
            break;
        case "CLASS_DECL":
            getCurrentState().shiftCLASS_DECL();
            break;
        case "M_METH_BODY":
            getCurrentState().shiftM_METH_BODY();
            break;
        case "METH_DECL_L":
            getCurrentState().shiftMETH_DECL_L();
            break;
        case "METH_DECL":
            getCurrentState().shiftMETH_DECL();
            break;
        case "METH_BODY":
            getCurrentState().shiftMETH_BODY();
            break;
        case "FORMAL_L":
            getCurrentState().shiftFORMAL_L();
            break;
        case "FORMAL_R":
            getCurrentState().shiftFORMAL_R();
            break;
        case "TYPE":
            getCurrentState().shiftTYPE();
            break;
        case "STMT":
            getCurrentState().shiftSTMT();
            break;
        case "STMT_P":
            getCurrentState().shiftSTMT_P();
            break;
        case "OP1":
            getCurrentState().shiftOP1();
            break;
        case "OP2":
            getCurrentState().shiftOP2();
            break;
        case "OP3":
            getCurrentState().shiftOP3();
            break;
        case "OP4":
            getCurrentState().shiftOP4();
            break;
        case "OP5":
            getCurrentState().shiftOP5();
            break;
        case "OP6":
            getCurrentState().shiftOP6();
            break;
        case "EXP_L":
            getCurrentState().shiftEXP_L();
            break;
        case "EXP_R":
            getCurrentState().shiftEXP_R();
            break;  
        default:
            getCurrentState().shiftInvalidState();
            break;
        }
    }
}
