package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;

/**
 * Class that handles the CILS_2 states
 * @author Jessica Schlesiger, Shannon Jones
 */

public class CILS_2 extends State
{
	/**
	 * Changes state to CILS_3
	 * @auther Jessica Schlesiger
	 */
	public void shiftSTMT() throws ParserException	
	{
		changeToState(new CILS_3());
	}
	
	/**
	 * Changes state to CILS_3
	 * @auther Jessica Schlesiger
	 */
	public void shiftLeftBrace() throws ParserException	
	{
		changeToState(new CILS_6());
	}
	
	/**
	 * Method used to shift on  if and change to state 7
	 * @author Shannon Jones
	 */
	@Override
	public void shiftIf() throws ParserException
	{
		changeToState(new CILS_7());
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
