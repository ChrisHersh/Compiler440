package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * Class for MDJ_21 states
 * @author Shannon Lee
 *
 */
public class MDJ_21 extends State{
	/**
	 * method for shift on { and change to state 23
	 * @author Shannon Lee
	 *
	 */
	@Override
	public void shiftLeftBrace() throws ParserException
	{
		changeToState(new MDJ_23());
	}
}
