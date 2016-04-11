package parser.states;

public class CILS_8 extends State {
	
	/**
	 * Method used to shift on ( and change to state 13
	 */
	@Override
	public void shiftLeftPara() throws ParserException
	{
		changeToState(new CILS_13());
	}
}
