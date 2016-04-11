package parser.states;

/**
 * @author Jessica Schlesiger
 */

public class CILS_2 extends State
{
	/**
	 * Changes state to CILS_3
	 * @auther Jessica Schlesiger
	 */
	public void shiftSTMT() throws ParserException	{
		changeToState(new CILS_3());
	}
	
	/**
	 * Changes state to CILS_3
	 * @auther Jessica Schlesiger
	 */
	public void shiftLeftBrace() throws ParserException	{
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
