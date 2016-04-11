package parser.states;


public class CILS_16 extends State
{
	/**
	 * Method used to shift on  right brace ')' and change to state 23
	 * @author Shannon Jones
	 */
	@Override
	public void shiftRightPara() throws ParserException
	{
		changeToState(new CILS_23());
	}
}
