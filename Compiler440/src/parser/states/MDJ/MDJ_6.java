package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Curtis Rabe
 * MDJ_6 state. Ensure this state can properly shift to MDJ_7 on "{"
 */
public class MDJ_6 extends State
{
	/**
	 * changes to state MDJ_7 when a "{" token is read
	 * @throws ParserException
	 */
	public void shiftLeftBrace() throws ParserException
	{
		changeToState(new MDJ_7());
	}
}
