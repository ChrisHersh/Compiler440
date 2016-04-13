package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

public class MDJ_23 extends State
{
	/**
	 * Method used to shift on VAR_DECL_L and change to state 25
	 * @author Shannon Jones
	 */
	@Override
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new MDJ_25());
	}

}
