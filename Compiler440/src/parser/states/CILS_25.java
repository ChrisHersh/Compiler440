package parser.states;

public class CILS_25 extends State
{
	/**
	 * Method used to shift on EXP1 and change to state 26.
	 */
	@Override
	public void shiftEXP1() throws ParserException
	{
		changeToState(new CILS_26());
	}
}
