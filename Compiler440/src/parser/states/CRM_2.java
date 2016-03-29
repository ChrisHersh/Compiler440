package parser.states;

public class CRM_2 extends State
{
	/**
	 * Changes to state CRM_3
	 * @author Chris Kjeldgaard
	 */
	public void shiftVAR_DECL() throws ParserException
	{
		changeToState(new CRM_3());
	}
}
