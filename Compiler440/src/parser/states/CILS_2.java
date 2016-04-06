package parser.states;

public class CILS_2 extends State
{
	/**
	 * Method used to shift on  if and change to state 7
	 * @author Shannon Jones
	 */
	@Override
	public void shiftIf() throws ParserException
	{
		changeToState(new CILS_7());
	}

}
