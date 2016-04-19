package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import parser.states.CRM.CRM_1;

/**
 * Implements the methods from state MDJ_15
 * @author Michael Zimmerman, Jason LoBianco
 */
public class MDJ_15 extends State
{
	/**
	 * changes to state MDJ_16 when a M_METH_BODY token is read
	 * @throws ParserException
	 */
	public void shiftM_METH_BODY() throws ParserException
	{
		changeToState(new MDJ_16());
	}
	
	/**
	 * Changes to the state CRM_1
	 * @author Jason LoBianco
	 */
	public void shiftLeftBrace()
	{
		changeToState(new CRM_1());
	}
}
