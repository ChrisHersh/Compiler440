package parser.states;

public class JMCC_3 extends State {
	
	/**
	 * Shift to JMCC_20 if the shift is EXP5.
	 */
	@Override
	public void shiftEXP5()
	{
		changeToState(new JMCC_20());
	}
	
	/**
	 * Shift to JMCC_32 if the shift is 6.
	 */
	@Override
	public void shiftEXP6()
	{
		changeToState(new JMCC_32());
	}

}
