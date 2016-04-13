package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;

/**
 * Implements the methods from state CRM_26
 * @author TJ Renninger
 */
public class CRM_26 extends State
{
	/**
	 * changes to state CRM_27
	 * @author TJ Renninger
	 */
	@Override
	public void shiftM_METH_BODY() throws ParserException
	{
		changeToState(new CRM_27());
	}

	/**
	 * changes to state CRM_28
	 * @author TJ Renninger
	 */
	@Override
	public void shiftLeftBrace() throws ParserException
	{
		changeToState(new CRM_28());
	}
}
