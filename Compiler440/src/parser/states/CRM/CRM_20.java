package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;

/**
 * Implements the methods from state CRM_20
 * @author TJ Renninger
 */
public class CRM_20 extends State
{
	/**
	 * changes to state CRM_9
	 * @author TJ Renninger
	 */
	@Override
	public void shiftInt() throws ParserException
	{
		changeToState(new CRM_9());
	}

	/**
	 * changes to state CRM_12
	 * @author TJ Renninger
	 */
	@Override
	public void shiftId() throws ParserException
	{
		changeToState(new CRM_12());
	}

	/**
	 * changes to state CRM_13
	 * @author TJ Renninger
	 */
	@Override
	public void shiftBoolean() throws ParserException
	{
		changeToState(new CRM_13());
	}

	/**
	 * changes to state CRM_21
	 * @author TJ Renninger
	 */
	@Override
	public void shiftTYPE() throws ParserException
	{
		changeToState(new CRM_21());
	}
}
