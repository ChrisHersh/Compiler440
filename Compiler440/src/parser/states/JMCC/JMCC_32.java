package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
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
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(1, TokenTypes.EXP5);
	}

}
