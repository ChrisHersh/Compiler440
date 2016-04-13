package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * @author Jared Good
 */
public class MDJ_11 extends State 
{
	/**
	 * Changes to state MDJ_12
	 */
	@Override
    public void shiftVoid() throws ParserException
    {
        changeToState(new MDJ_12());
    }
}
