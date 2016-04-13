package parser.states.CILS;

import parser.states.State;

/**
 *This class is CILS_28 which represents this: STMT -> if ( EXP1 ) STMT • else STMT
 * 
 * @author Raistlin Hess
 */
public class CILS_28 extends State 
{
	/**
	 * If the input is else, this shifts to CILS_29
	 */
	@Override
	public void shiftElse()
	{
		changeToState(new CILS_29());
	}
}
