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
	 * @author Corey Peregord 
	 * Method used to shift on while and change to CILS_10
	 */
	@Override
	public void shiftWhile() throws ParserException
	{
		changeToState(new CILS_10());
	}
	
	/**
	 * @author Corey Peregord 
	 * Method used to shift on System.out.println and change to CILS_8
	 */
	@Override
	public void shiftSystemOutPrintln() throws ParserException
	{
		changeToState(new CILS_8());
	}
	
	/**
	 * @author Corey Peregord 
	 * Method used to shift on id and change to CILS_9
	 */
	@Override
	public void shiftId() throws ParserException
	{
		changeToState(new CILS_9());
	}
}
