package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;


/**
 * @author Jessica Schlesiger
 */
public class CILS_5 extends State {
	/**
	 * Changes state to CILS_4
	 * @auther Jessica Schlesiger
	 */
	public void shiftRightBrace() throws ParserException	{
		changeToState(new CILS_4());
	}
	
	/**
	 * Method used to shift on while and change to state 10
	 */
	@Override
	public void shiftWhile() throws ParserException
	{
		changeToState(new CILS_10());
	}
	
	/**
	 * Method used to shift on System.out.println and change to state 8
	 */
	@Override
	public void shiftSystemOutPrintln() throws ParserException
	{
		changeToState(new CILS_8());
	}
	
	/**
	 * Method used to shift on id and change to state 10
	 */
	@Override
	public void shiftId() throws ParserException
	{
		changeToState(new CILS_9());
	}
}
