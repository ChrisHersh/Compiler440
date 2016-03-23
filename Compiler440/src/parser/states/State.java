package parser.states;

import parser.Parser;

public abstract class State
{
	private Parser currentParser;
	
	public State()
	{
		this.currentParser = Parser.getInstance();
	}
	
	/**
	 * For default behavior for invalid states
	 * This makes it easy to change the behavior for every shift
	 * @author Chris Hersh
	 * @throws ParserException 
	 */
	private void invalidState() throws ParserException
	{
	    throw new ParserException();
	}
	
	//Below here add all the methods for the different shift calls with our default logic
	public void shiftEXP1 () throws ParserException
	{
		invalidState();
	}
	
}
