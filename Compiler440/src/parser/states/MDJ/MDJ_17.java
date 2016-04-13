package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Jessica Schlesiger
 * MDJ_17 state. Ensure this state can properly shift to MDJ_18 on "id" token
 */
public class MDJ_17 extends State
{
	/**
	 * Changes to state MDJ_18 on "id" token
	 */
	@Override
	public void shiftId() throws ParserException
	{
		changeToState(new MDJ_18());
	}
}