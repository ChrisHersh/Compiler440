package parser.states;

public class CRM_40 extends State 
{
	/**
	 * Changes to state CRM_41
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftId()
	{
		changeToState(new CRM_41());
	}
}
