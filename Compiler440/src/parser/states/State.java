package parser.states;

import java.util.ArrayList;

import parser.Parser;
import tokenizer.Token;
import tokenizer.TokenTypes;

public abstract class State
{
	protected Parser currentParser;
	
	public State()
	{
		this.currentParser = Parser.getInstance();
	}
	
	/**
	 * For default behavior for invalid states
	 * This makes it easy to change the behavior for every shift
	 * @author Chris Hersh
	 * @throws ParserException 
	 */
	protected void invalidState() throws ParserException
	{
	    throw new ParserException();
	}
	
	/**
	 * Method to handle any common code for every state transition
	 * @param state New state to transition to
	 */
	protected void changeToState(State state)
	{
	    currentParser.pushHoldStack(currentParser.popInputStack());
        currentParser.pushStateStack(this);
        currentParser.changeState(state);
	}
	/**
	 * Takes the state that you would be in after reducing and the name of the non terminal created by the reduce
	 * It then pops states and holds off the stack and adds the new nonterminal to the input stack
	 * @author Chris Kjeldgaard
	 * @param state
	 * @param tokenName
	 */
	protected void reduceToState(State state, TokenTypes tokenName)
	{
		ArrayList<Token> children = new ArrayList<Token>();
		
		while(!(currentParser.peekStateStack().getClass().equals(state.getClass())))
		{
			currentParser.popStateStack();
			children.add(currentParser.popHoldStack());
		}
		
		currentParser.popStateStack();
		children.add(currentParser.popHoldStack());
		currentParser.changeState(state);
		
		Token newToken = new Token(tokenName, children);
		currentParser.pushInputStack(newToken);
		
	}
	
	//Below here add all the methods for the different shift calls with our default logic
	public void shiftEXP1 () throws ParserException
	{
		invalidState();
	}
	public void shiftEXP2() throws ParserException
	{
		invalidState();
	}
	public void shiftEXP3() throws ParserException
	{
		invalidState();
	}
	public void shiftEXP4() throws ParserException
	{
		invalidState();
	}
	public void shiftEXP5() throws ParserException
	{
		invalidState();
	}
	public void shiftEXP6() throws ParserException
	{
		invalidState();
	}
	public void shiftEXP7() throws ParserException
	{
		invalidState();
	}
	public void shiftId() throws ParserException
	{
		invalidState();
	}
	public void shiftIntegerLiteral() throws ParserException
	{
		invalidState();
	}
	public void shiftTrue() throws ParserException
	{
		invalidState();
	}
	public void shiftFalse() throws ParserException
	{
		invalidState();
	}
	public void shiftThis() throws ParserException
	{
		invalidState();
	}
	public void shiftNew() throws ParserException
	{
		invalidState();
	}
	public void shiftExclamation() throws ParserException
	{
		invalidState();
	}
	public void shiftLeftBracket() throws ParserException
	{
		invalidState();
	}
	public void shiftLeftBrace() throws ParserException
	{
		invalidState();
	}
	public void shiftLeftPara() throws ParserException
	{
		invalidState();
	}
	public void shiftVAR_DECL_L() throws ParserException
	{
		invalidState();
	}
	public void shiftVAR_DECL() throws ParserException
	{
		invalidState();
	}

	public void shiftPublic() throws ParserException 
	{
		invalidState();
	}

	public void shiftStatic() throws ParserException 
	{
		invalidState();
	}

	public void shiftVoid() throws ParserException 
	{
		invalidState();
	}

	public void shiftMain() throws ParserException 
	{
		invalidState();
	}

	public void shiftRightPara() throws ParserException 
	{
		invalidState();
	}

	/**
	 * @author Michael Zimmerman
	 * @throws ParserException
	 */
	public void shiftM_METH_BODY() throws ParserException
	{
		invalidState();
	}

	public void shiftMETH_DECL_L() throws ParserException
	{
		invalidState();
	}
	
	public void shiftRightBracket() throws ParserException
	{
		invalidState();
	}
	
	/**
	 * @author Curtis Rabe
	 * @throws ParserException
	 */
	public void shiftClass() throws ParserException
	{
		invalidState();
	}
	
	public void shiftMAIN_CLASS() throws ParserException
	{
		invalidState();
	}
	
	public void shiftMAIN_METHOD() throws ParserException
	{
		invalidState();
	}
	
	public void shiftRightBrace() throws ParserException
	{
		invalidState();
	}

    public void shiftInt() throws ParserException
    {
        invalidState();
    }

    public void shiftBoolean() throws ParserException
    {
        invalidState();
    }

    public void shiftIf() throws ParserException
    {
        invalidState();
    }

    public void shiftWhile() throws ParserException
    {
        invalidState();
    }

    public void shiftElse() throws ParserException
    {
        invalidState();
    }

    public void shiftReturn() throws ParserException
    {
        invalidState();
    }

    public void shiftSystemOutPrintln() throws ParserException
    {
        invalidState();
    }

    public void shiftExtends() throws ParserException
    {
        invalidState();
    }

    public void shiftLength() throws ParserException
    {
        invalidState();
    }

    public void shiftEXP_R() throws ParserException
    {
        invalidState();
    }

    public void shiftEXP_L() throws ParserException
    {
        invalidState();
    }

    public void shiftOP6() throws ParserException
    {
        invalidState();
    }

    public void shiftOP5() throws ParserException
    {
        invalidState();
    }

    public void shiftOP4() throws ParserException
    {
        invalidState();
    }

    public void shiftOP3() throws ParserException
    {
        invalidState();
    }

    public void shiftOP2() throws ParserException
    {
        invalidState();
    }

    public void shiftOP1() throws ParserException
    {
        invalidState();
    }

    public void shiftSTMT_P() throws ParserException
    {
        invalidState();
    }

    public void shiftSTMT() throws ParserException
    {
        invalidState(); 
    }

    public void shiftTYPE() throws ParserException
    {
        invalidState();
    }

    public void shiftFORMAL_R() throws ParserException
    {
        invalidState();
    }

    public void shiftFORMAL_L() throws ParserException
    {
        invalidState();
    }

    public void shiftMETH_BODY() throws ParserException
    {
        invalidState();
    }

    public void shiftMETH_DECL() throws ParserException
    {
        invalidState();
    }

    public void shiftCLASS_DECL() throws ParserException
    {
        invalidState();
    }

    public void shiftCLASS_DECL_L() throws ParserException
    {
        invalidState();
    }

    public void shiftProg() throws ParserException
    {
        invalidState();
    }

    public void shiftLt() throws ParserException
    {
        invalidState();
    }

    public void shiftGt() throws ParserException
    {
        invalidState();
    }

    public void shiftPeriod() throws ParserException
    {
        invalidState();
    }

    public void shiftAssignment() throws ParserException
    {
        invalidState();
    }

    public void shiftMult() throws ParserException
    {
        invalidState();
    }

    public void shiftMinus() throws ParserException
    {
        invalidState();
    }

    public void shiftPlus() throws ParserException
    {
        invalidState();
    }

    public void shiftSemiColon() throws ParserException
    {
        invalidState();
    }

    public void shiftNotEquals() throws ParserException
    {
        invalidState();
    }

    public void shiftLtEquals() throws ParserException
    {
        invalidState();
    }

    public void shiftGtEquals() throws ParserException
    {
        invalidState(); 
    }

    public void shiftEquals() throws ParserException
    {
        invalidState();
    }

    public void shiftOr() throws ParserException
    {
        invalidState();
    }

    public void shiftAnd() throws ParserException
    {
        invalidState();
    }

    public void shiftComa() throws ParserException
    {
        invalidState();
    }
}
