package parser.states.MDJ;

import parser.states.State;
import tokenizer.TokenTypes;

/**
 *This class is MDJ_26 which represents this: CLASS_DECL -> class id { VAR_DECL_L METH_DECL_L } •
 * 
 * @author Raistlin Hess
 */
public class MDJ_26 extends State
{
	/**
	 * Since there can be no more inputs, reduce to MDJ_3
	 */
	@Override
	public void invalidState()
	{
		reduceToState(new MDJ_3(), TokenTypes.CLASS_DECL);
	}
}