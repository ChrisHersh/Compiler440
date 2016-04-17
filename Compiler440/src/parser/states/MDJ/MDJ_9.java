package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * changes to state MDJ_0
 * @author Michael Zimmerman
 */
public class MDJ_9 extends State
{
	/**
	 * reduces to MDJ_0 and generates the token MAIN_CLASS
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(5, TokenTypes.MAIN_CLASS);
	}
}
