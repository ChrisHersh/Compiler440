package parser.states.CRM;

import parser.states.State;

public class CRM_39 extends State {
	/**
	 * Changes to state CRM_9
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftInt()
	{
		changeToState(new CRM_9());
	}
	/**
	 * Changes to state CRM_12
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftId()
	{
		changeToState(new CRM_12());
	}
	/**
	 * Changes to state CRM_13
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftBoolean()
	{
		changeToState(new CRM_13());
	}
	/**
	 * Changes to state CRM_40
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftTYPE()
	{
		changeToState(new CRM_40());
	}
}
