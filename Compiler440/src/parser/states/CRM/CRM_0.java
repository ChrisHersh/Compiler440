package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;
/**
 * Implements the methods from state CRM_0
 * @author Ledny Joseph, Jason LoBianco
 */

public class CRM_0 extends State
{
	/**
	 * changes state to CRM_1
	 * @author Ledny Joseph, Jason LoBianco
	 */
	public void shiftLeftBrace() throws ParserException
	{
		changeToState(new CRM_1());
	}
}
