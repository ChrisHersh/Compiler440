package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;

public class CILS_8 extends State {
	
	/**
	 * @author Corey Peregord 
	 * Method used to shift on ( and change to CILS_13
	 */
	@Override
	public void shiftLeftPara() throws ParserException
	{
		changeToState(new CILS_13());
	}
}
