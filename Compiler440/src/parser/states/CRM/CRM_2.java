package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Implements the methods from state CRM_2
 * @author Chris Kjeldgaard, TJ Renninger, Jason LoBianco
 */
public class CRM_2 extends State
{
	/**
	 * Changes to state CRM_3
	 * @author Chris Kjeldgaard
	 */
	public void shiftVAR_DECL() throws ParserException
	{
		changeToState(new CRM_3());
	}
	
	/**
	 * Changes the state to CMR_4
	 * @author TJ Renninger
	 */
	public void shiftSTMT_P()
	{
		changeToState(new CRM_4());
	}
	
	/**
	 * Changes the state to CRM_6
	 * @author Jason LoBianco
	 */
	public void shiftTYPE()
	{
		changeToState(new CRM_6());
	}
	
	/**
	 * Changes the state to CRM_9
	 * @author Jason LoBianco
	 */
	public void shiftInt()
	{
		changeToState(new CRM_9());
	}
	
	/**
	 * Changes the state to CRM_13
	 * @author Jason LoBianco
	 */
	public void shiftBoolean()
	{
		changeToState(new CRM_13());
	}
	
	/**
	 * Changes the state to CRM_12
	 * @author Jason LoBianco
	 */
	public void shiftId()
	{
		changeToState(new CRM_12());
	}
	
	/**
	 * reduces to the current state and generates the token STMT_P
	 * @author Jason LoBianco
	 */
	@Override
	public void invalidState()
	{
		currentParser.pushInputStack(new Token(TokenTypes.STMT_P.name(), TokenTypes.STMT_P.toString(), currentParser.peekInputStack().getLineNumber()));
	}
}
