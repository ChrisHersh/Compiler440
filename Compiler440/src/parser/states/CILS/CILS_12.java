package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;

/**
 * Class that handles the CILS_12 states
 * @author Shannon Jones
 *
 */
public class CILS_12 extends State
{


	/**
	 * Method used to shift on  EXP1 and change to state 16
	 * @author Shannon Jones
	 */
	@Override
	public void shiftEXP1() throws ParserException
	{
		changeToState(new CILS_16());
	}
}
