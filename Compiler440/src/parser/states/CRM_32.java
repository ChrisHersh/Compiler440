package parser.states;

public class CRM_32 extends State {
	/**
	 * Changes to state CRM_32
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftOP1() {
		changeToState(new JMCC_3());
	}

	/**
	 * Changes to state CRM_32
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftSemiColon() {
		changeToState(new CRM_33());
	}

	/**
	 * Changes to state CRM_32
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftOr() {
		changeToState(new JMCC_2());
	}
}
