package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_19;
import parser.states.CRM.CRM_20;

/**
 * Class for MDJ_27 states
 * @author Shannon Lee, Jason LoBianco
 *
 */
public class MDJ_27 extends State
{
	/**
	 * Method used to shift on  right bracket '}' and change to state 28
	 * @author Shannon Jones
	 */
	@Override
	public void shiftRightBrace() throws ParserException
	{
		changeToState(new MDJ_28());
	}
	
	/**
	 * Changes state to CRM_19
	 * @author Jason LoBianco
	 */
	public void shiftMETH_DECL()
	{
		changeToState(new CRM_19());
	}
	
	/**
	 * Changes state to CRM_20
	 * @author Jason LoBianco
	 */
	public void shiftPublic()
	{
		changeToState(new CRM_20());
	}
}