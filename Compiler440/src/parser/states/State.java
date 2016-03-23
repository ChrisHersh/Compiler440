package parser.states;

import parser.Parser;

public abstract class State 
{
	private State currentState;
	private Parser currentParser;
	
	public State ()
	{
		this.currentParser = Parser.getInstance();
//		this.currentState = currentParser.getStartState();//Sets the state to be the inital state in the state diagram
	}
	
	public void changeState(State newState)
	{
		currentState = newState;
	}
	
	//Below here add all the methods for the different shift calls with our default logic
	public void shiftEXP1 ()
	{
		
	}
	
}
