package parser.states;

public class CILS_20 extends State
{
	/**
	 * Method used to shift on assignment and change to state 25.
	 */
	@Override
	public void shiftAssignment() throws ParserException
	{
		changeToState(new CILS_25());
	}
}
