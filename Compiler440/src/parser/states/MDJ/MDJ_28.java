package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

public class MDJ_28 extends State 
{
	/**
	 * method for the reduce state for CLASS_DECL	
	 * @author Shannon Jones
	 */
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(new MDJ_3(), TokenTypes.CLASS_DECL);
	}

}
