package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * changes to state MDJ_16
 * @author Michael Zimmerman
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
}
