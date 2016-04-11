package parser.states;

import tokenizer.TokenTypes;

public class JMCC_32 extends State {
	
	/**
	 * Shift to JMCC_20 if the shift is EXP5.
	 */
	@Override
	public void shiftEXP5()
	{
		changeToState(new JMCC_20());
	}
	
	/**
	 * Invalidity of state
	 */
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(new JMCC_0(), TokenTypes.EXP5);
	}

}
