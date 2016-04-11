package parser.states;

public class CRM_33 extends State {
	/**
	 * Changes to state CRM_34
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftRightBrace() {
		changeToState(new CRM_34());
	}
}
