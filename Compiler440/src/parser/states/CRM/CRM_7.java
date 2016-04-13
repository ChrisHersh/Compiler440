package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;

/**
 * Implements the methods from state CRM_7
 * @author Jason LoBianco
 */
public class CRM_7 extends State 
{
	/**
	 * changes to the state CRM_8
	 * @author Jason LoBianco
	 */
	public void shiftSemiColon() throws ParserException 
	{
		changeToState(new CRM_8());
	}
}
