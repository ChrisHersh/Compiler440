package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;

public class CRM_4 extends State
{
	/**
	 * Changes the state to CRM_5
	 * @author TJ Renninger
	 */
	public void shiftRightBrace() throws ParserException
	{
		changeToState(new CRM_5());
	}
}
