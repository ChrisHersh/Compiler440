package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;

public class CILS_22 extends State {

	/**
	 * @author Corey Peregord 
	 * Method used to shift on ( and change to CILS_24
	 */
	@Override
	public void shiftSemiColon() throws ParserException
	{
		changeToState(new CILS_24());
	}
}
