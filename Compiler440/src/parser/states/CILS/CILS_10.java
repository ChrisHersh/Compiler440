package parser.states.CILS;

import parser.states.State;

/**
 *This class is CILS_10 which represents this: STMT -> While ( EXP1 ) STMT
 * 
 * @author Mohammed
 */
 
public class CILS_10 extends State {

	/**
	 * If the input is LeftBrace, this shifts to CILS_11 
	 */
	@Override
	public void shiftLeftBrace()
	{
		changeToState(new CILS_11());
	}
	
	
}
