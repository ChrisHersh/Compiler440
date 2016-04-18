package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;

public class CILS_13 extends State {

	/**
	 * @author Corey Peregord 
	 * Method used to shift on ( and change to CILS_17
	 */
	@Override
	public void shiftEXP1() throws ParserException
	{
		changeToState(new CILS_17());
	}
}
