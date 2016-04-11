package parser.states;

public class MDJ_27 extends State
{
	/**
	 * Method used to shift on  right bracket '}' and change to state 28
	 * @author Shannon Jones
	 */
	@Override
	public void shiftRightBrace() throws ParserException
	{
		changeToState(new MDJ_28());
	}
}
