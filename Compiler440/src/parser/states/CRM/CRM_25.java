package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;

/**
 * Implements the methods from state CRM_25
 * @author TJ Renninger
 */
public class CRM_25 extends State
{
	/**
	 * changes to state CRM_26
	 * @author TJ Renninger
	 */
	@Override
	public void shiftRightPara() throws ParserException
	{
		changeToState(new CRM_26());
	}
}
