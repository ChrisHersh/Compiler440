package parser.states;

import parser.Parser;

public abstract class State 
{
	private Parser currentParser;
	
	public State ()
	{
		this.currentParser = Parser.getInstance();
	}
	
	//Below here add all the methods for the different shift calls with our default logic
	public void shiftEXP1 ()
	{
		
	}
	
}
