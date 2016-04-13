package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Curtis Rabe
 * MDJ_0 state. Ensure this state can properly shift to MDJ_5 on "class"
 * and to MDJ_1 on "MAIN_CLASS"
 *
 */
public class MDJ_0 extends State
{
	/**
	 * changes to state MDJ_5 when a "class" token is read
	 * @throws ParserException
	 */
	public void shiftClass() throws ParserException
	{
		changeToState(new MDJ_5());
	}
	
	/**
	 * changes to state MDJ_5 when a "class" token is read
	 * @throws ParserException
	 */
	public void shiftMAIN_CLASS() throws ParserException
	{
		changeToState(new MDJ_1());
	}
}
