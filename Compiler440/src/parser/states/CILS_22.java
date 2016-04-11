package parser.states;

public class CILS_22 extends State {

	/**
	 * Method used to shift on ( and change to state 13
	 */
	@Override
	public void shiftSemiColon() throws ParserException
	{
		changeToState(new CILS_24());
	}
}
