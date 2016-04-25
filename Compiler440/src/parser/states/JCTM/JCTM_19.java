package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Matt Mousetis
 *
 */

public class JCTM_19 extends State
{
	/**
	 * Shift on id
	 */
	@Override
	public void shiftId() throws ParserException 
	{
		changeToState(new JCTM_24());
	}
	
	/**
	 * Shift on int
	 */
    public void shiftInt() throws ParserException
    {
    	changeToState(new JCTM_20());
    }
}
