package parser.states;

public class CRM_1 extends State
{
	/**
	 * Changes to state CRM_2
	 * @author Chris Kjeldgaard
	 */
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new CRM_2());
	}
}
