package parser.states;


public class CRM_0 extends State
{
	/**
	 * Reduces to state CMR_1 and generates a new token
	 * @author Ledny Joseph
	 */
	public void shiftLBrace() throws ParserException
	{
		changeToState(new CRM_1());
	}
}
