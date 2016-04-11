package parser.states;

public class CRM_31 extends State {
	/**
	 * Changes to state CRM_32
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftEXP1() {
		changeToState(new CRM_32());
	}

	/**
	 * Changes to state JMCC_9
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftEXP2() {
		changeToState(new JMCC_9());
	}

	/**
	 * Changes to state JMCC_15
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftEXP3() {
		changeToState(new JMCC_15());
	}

	/**
	 * Changes to state JMCC_8
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftEXP4() {
		changeToState(new JMCC_8());
	}

	/**
	 * Changes to state JMCC_20
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftEXP5() {
		changeToState(new JMCC_20());
	}

	/**
	 * Changes to state JMCC_32
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftEXP6() {
		changeToState(new JMCC_32());
	}

	/**
	 * Changes to state JCTM_33
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftEXP7() {
		changeToState(new JCTM_33());
	}

	/**
	 * Changes to state JCTM_18
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftIntegerLiteral() {
		changeToState(new JCTM_18());
	}

	/**
	 * Changes to state JCTM_15
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftTrue() {
		changeToState(new JCTM_15());
	}

	/**
	 * Changes to state JCTM_16
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftFalse() {
		changeToState(new JCTM_16());
	}

	/**
	 * Changes to state JCTM_17
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftThis() {
		changeToState(new JCTM_17());
	}

	/**
	 * Changes to state JCTM_19
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftNew() {
		changeToState(new JCTM_19());
	}

	/**
	 * Changes to state JCTM_27
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftExclamation() {
		changeToState(new JCTM_27());
	}

	/**
	 * Changes to state JCTM_29
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftLeftBrace() {
		changeToState(new JCTM_29());
	}

	/**
	 * Changes to state JCTM_1
	 * 
	 * @author Chris Kjeldgaard
	 */
	@Override
	public void shiftId() {
		changeToState(new JCTM_1());
	}
}
