package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_12;
import parser.states.CRM.CRM_13;
import parser.states.CRM.CRM_3;
import parser.states.CRM.CRM_6;
import parser.states.CRM.CRM_9;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Class for MDJ_25 states
 * @author Shannon Lee, Jason LoBianco
 *
 */
public class MDJ_25 extends State
{
	/**
	 * Method used to shift on  METH_DECL_L and change to state 27
	 * @author Shannon Jones
	 */
	@Override
	public void shiftMETH_DECL_L() throws ParserException
	{
		changeToState(new MDJ_27());
	}

	/**
	 * If the input is VAR_DECL, this shifts to CRM_3
	 * @author Jason LoBianco
	 */
	@Override
	public void shiftVAR_DECL()
	{
		changeToState(new CRM_3());
	}
	
	/**
	 * If the input is TYPE, this shifts to CRM_6
	 * @author Jason LoBianco
	 */
	@Override
	public void shiftTYPE()
	{
		changeToState(new CRM_6());
	}
	
	/**
	 * If the input is int, this shifts to CRM_9
	 * @author Jason LoBianco
	 */
	@Override
	public void shiftInt()
	{
		changeToState(new CRM_9());
	}
	
	/**
	 * If the input is boolean, this shifts to CRM_13
	 * @author Jason LoBianco
	 */
	@Override
	public void shiftBoolean()
	{
		changeToState(new CRM_13());
	}
	
	/**
	 * If the input is id, this shifts to CRM_12
	 * @author Jason LoBianco
	 */
	@Override
	public void shiftId()
	{
		changeToState(new CRM_12());
	}
	
	/**
	 * reduces to the current state and creates a METH_DECL_L token
	 * @author Jason LoBianco
	 */
	@Override
	public void invalidState()
	{
		currentParser.pushInputStack(new Token(TokenTypes.METH_DECL_L.name(), TokenTypes.METH_DECL_L.toString(), currentParser.peekInputStack().getLineNumber()));
	}
}
