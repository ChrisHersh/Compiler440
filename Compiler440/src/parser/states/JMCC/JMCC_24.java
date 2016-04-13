package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

public class JMCC_24 extends State
{
	
	/**
	 * Invalidity of state
	 */
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(new JMCC_0(), TokenTypes.EXP5);
	}

}
