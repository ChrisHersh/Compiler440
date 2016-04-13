package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * @author Jared Good
 */
public class MDJ_10 extends State 
{
	/**
	 * Changes to state MDJ_11
	 */
	@Override
    public void shiftStatic() throws ParserException
    {
        changeToState(new MDJ_11());
    }
}
