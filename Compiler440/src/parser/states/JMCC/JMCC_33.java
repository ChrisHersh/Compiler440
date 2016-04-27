package parser.states.JMCC;

import parser.states.State;

/**
 * 
 * @author Ian Keefer
 *
 */
public class JMCC_33 extends State 
{
	
	/**
	 * Shift to JMCC_32 if the shift is 6.
	 */
	@Override
	public void shiftEXP6()
	{
		changeToState(new JMCC_32());
	}

}
