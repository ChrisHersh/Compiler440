package parser.states;
/*
 * @auther Mohammed
 */
public class CILS_10 extends State {

	/**
	 * If the input is LeftBrace, this shifts to CILS_11 
	 */
	@Override
	public void shiftLeftBrace()
	{
		changeToState(new CILS_11());
	}
	
	
}
