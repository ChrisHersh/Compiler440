package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Curtis Rabe
 * MDJ_5 state. Ensure this state can properly shift to MDJ_6 on "id"
 *
 */
public class MDJ_5 extends State
{
	/**
	 * changes to state MDJ_6 when a "id" token is read
	 * @throws ParserException
	 */
	public void shiftId() throws ParserException
	{
		changeToState(new MDJ_6());
	}
}
