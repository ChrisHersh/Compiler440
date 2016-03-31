package parser.states;

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
	protected void invalidState() throws ParserException
	{
		reduceToState(new MDJ_0(), TokenTypes.MAIN_CLASS);
	}
}
