package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Jessica Schlesiger
 * MDJ_20 state. Ensure this state can properly shift to MDJ_22 on "VAR_DECL_L" token
 */
public class MDJ_20 extends State
{
	/**
	 * Changes to state MDJ_22 on "VAR_DECL_L" token
	 */
	@Override
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new MDJ_22());
	}
}