package parser.states;

import tokenizer.TokenTypes;

public class CILS_24 extends State {

	/**
	 * reduces to CILS_2 and generates the token STMT
	 */
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(new CILS_2(), TokenTypes.STMT);
	}
}
