package parser.states.CILS;

import parser.states.State;

/**
 *This class is CILS_11 which represents this: STMT -> While ( EXP1 ) STMT
 * 
 * @author Mohammed
 */
public class CILS_11 extends State {

	/**
	 * If the input is EXP1, this shifts to CILS_15
	 */
	@Override
	public void shiftEXP1()
	{
		changeToState(new CILS_15());
	}
	
	
}
