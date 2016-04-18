package parser.states.CRM;

import parser.states.State;
import parser.states.JMCC.JMCC_2;
import parser.states.JMCC.JMCC_3;
/**
 * @author Chris Kjeldgaard
 */
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
