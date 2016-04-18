package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

public class CILS_24 extends State {

	/**
	 * @author Corey Peregord 
	 * reduces to CILS_2 and generates the token STMT
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(5, TokenTypes.STMT);
	}
}
