package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Curtis Rabe
 * MDJ_8 state. Ensure this state can properly shift to MDJ_9 on "}" token
 */
public class MDJ_8 extends State
{
	/**
	 * Changes to state MDJ_8 on "}" token
	 */
	@Override
	public void shiftRightBrace() throws ParserException
	{
		changeToState(new MDJ_9());
	}
}
