package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;

/**
 *This class is CILS_31 which represents this: STMT -> While ( EXP1 ) STMT, ?????
 * 
 * @author Mohammed, Chad Nunemaker
 */
public class CILS_15 extends State
{
	/**
	 * Method used to shift on EXP1 and change to state 19.
	 * @author Chad Nunemaker
	 */
	@Override
	public void shiftEXP1() throws ParserException
	{
		changeToState(new CILS_19());
	}
	

	/**
	 * @author Mohammed 
	 * If the input is RightBrace, this shifts to CILS_31
	 */
	@Override
	public void shiftRightBrace()
	{
		changeToState(new CILS_31());
	}
}
