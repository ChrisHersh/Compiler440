package parser.states;

public class CILS_7 extends State
{
	/**
	 * Method used to shift on left brace '(' and change to state 12
	 * @author Shannon Jones
	 */
	@Override
	public void shiftLeftBrace() throws ParserException
	{
		changeToState(new CILS_12());
	}
}
