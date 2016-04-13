package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * @author Jared Good and Curtis Rabe
 * MDJ_7 state. Ensure this state can properly shift to MDJ_8 on "MAIN_METHOD" token
 * and to MDJ_10 on "public" token
 */
public class MDJ_7 extends State
{
	/**
	 * Changes to state MDJ_10
	 */
	@Override
    public void shiftPublic() throws ParserException
    {
        changeToState(new MDJ_10());
    }
	
	/**
	 * Changes to state MDJ_8 on "MAIN_METHOD" token
	 */
	@Override
	public void shiftMAIN_METHOD() throws ParserException
	{
		changeToState(new MDJ_8());
	}
}
