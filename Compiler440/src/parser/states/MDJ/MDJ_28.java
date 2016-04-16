package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * Class for MDJ_28 reduce state
 * CLASS_DECL -> "class id extends id { VAR_DECL_L METH_DECL_L }"
 * @author Shannon Lee
 *
 */
public class MDJ_28 extends State 
{
	/**
	 * method for the reduce state for CLASS_DECL (MDJ_3)
	 * @author Shannon Jones
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(8, TokenTypes.CLASS_DECL);
	}

}
