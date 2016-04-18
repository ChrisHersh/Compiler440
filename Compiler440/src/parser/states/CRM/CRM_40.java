package parser.states.CRM;

import parser.states.State;
/**
 * @author Chris Kjeldgaard
 */
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
