package parser.states;

public class CILS_26 extends State
{
	/**
	 * Method used to shift on SemiColon and change to state 27.
	 */
	@Override
	public void shiftSemiColon() throws ParserException
	{
		changeToState(new CILS_27());
	}
}
