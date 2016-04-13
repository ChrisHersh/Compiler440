package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;

/**
 * Implements the methods from state CRM_19
 * @author TJ Renninger
 */
public class CRM_22 extends State
{
	/**
	 * changes to state CRM_23
	 * @author TJ Renninger
	 */
	@Override
	public void shiftLeftPara() throws ParserException
	{
		changeToState(new CRM_23());
	}
}
