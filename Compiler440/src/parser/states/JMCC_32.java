package parser.states;

public class JMCC_32 extends State {
	
	/**
	 * Shift to JMCC_20 if the shift is EXP5.
	 */
	@Override
	public void shiftEXP5()
	{
		changeToState(new JMCC_20());
	}

}
