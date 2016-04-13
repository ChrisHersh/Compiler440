package parser.states.CRM;

import parser.states.State;

public class CRM_35 extends State {
	/**
	 * Changes to state CRM_36
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftId()
	{
		changeToState(new CRM_36());
	}
}
