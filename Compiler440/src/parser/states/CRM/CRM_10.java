package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;

/**
 * Implements the methods from state CRM_10
 * @author Jason LoBianco
 */
public class CRM_10 extends State 
{
	/**
	 * changes to state CRM_11
	 * @author Jason LoBianco
	 */
	public void shiftRightBracket() throws ParserException
	{
		changeToState(new CRM_11());
	}
}
