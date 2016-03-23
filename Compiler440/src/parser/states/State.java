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
	public void shiftEXP2() throws ParserException
	{
		invalidState();
	}
	public void shiftEXP3() throws ParserException
	{
		invalidState();
	}
	public void shiftEXP4() throws ParserException
	{
		invalidState();
	}
	public void shiftEXP5() throws ParserException
	{
		invalidState();
	}
	public void shiftEXP6() throws ParserException
	{
		invalidState();
	}
	public void shiftEXP7() throws ParserException
	{
		invalidState();
	}
	public void shiftId() throws ParserException
	{
		invalidState();
	}
	public void shiftIntegerLiteral() throws ParserException
	{
		invalidState();
	}
	public void shiftTrue() throws ParserException
	{
		invalidState();
	}
	public void shiftFalse() throws ParserException
	{
		invalidState();
	}
	public void shiftThis() throws ParserException
	{
		invalidState();
	}
	public void shiftNew() throws ParserException
	{
		invalidState();
	}
	public void shiftExclamation() throws ParserException
	{
		invalidState();
	}
	public void shiftLeftBracket() throws ParserException
	{
		invalidState();
	}
	
}
