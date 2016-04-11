package parser.states;

public class CILS_15 extends State
{
	/**
	 * Method used to shift on EXP1 and change to state 19.
	 */
	@Override
	public void shiftEXP1() throws ParserException
	{
		changeToState(new CILS_19());
	}
	

	/**
	 * @author Mohammed 
	 * If the input is RightBrace, this shifts to CILS_31
	 */
	@Override
	public void shiftRightBrace()
	{
		changeToState(new CILS_31());
	}
}
