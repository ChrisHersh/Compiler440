package parser.states;

public class MDJ_19 extends State 
{
	/**
	 * Changes to state MDJ_18 on "id" token
	 */
	@Override
	public void shiftId() throws ParserException
	{
		changeToState(new MDJ_21());
	}
}
