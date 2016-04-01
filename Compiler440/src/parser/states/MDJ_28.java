package parser.states;

import tokenizer.TokenTypes;
/**
 * reduce State
 * @author Shannon Lee
 *
 */
public class MDJ_28 extends State 
{
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(new MDJ_3(), TokenTypes.CLASS_DECL);
	}

}
