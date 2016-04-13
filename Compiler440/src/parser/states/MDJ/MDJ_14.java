package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * @author Jared Good
 */
public class MDJ_14 extends State 
{
	/**
	 * Changes to state MDJ_15
	 */
	@Override
    public void shiftRightPara() throws ParserException
    {
        changeToState(new MDJ_15());
    }
}
