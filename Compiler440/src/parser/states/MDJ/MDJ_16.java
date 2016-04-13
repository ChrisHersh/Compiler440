package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * changes to state MDJ_7
 * @author Mike
 *
 */
public class MDJ_16 extends State
{
	/**
	 * reduces to MDJ_7 and generates the token MAIN_METHOD 
	 */
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(new MDJ_7(), TokenTypes.MAIN_METHOD);
	}

}
