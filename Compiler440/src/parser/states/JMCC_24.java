package parser.states;

import tokenizer.TokenTypes;

public class JMCC_24 extends State
{
	
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(new JMCC_0(), TokenTypes.EXP5);
	}

}
