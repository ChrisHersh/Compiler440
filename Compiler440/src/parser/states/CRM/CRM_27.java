package parser.states.CRM;

import parser.states.State;
import tokenizer.TokenTypes;

public class CRM_27 extends State
{
	/**
	 * Reduces and places the METH_DECL_L token on the stack
	 * 
	 * @author TJ Renninger
	 */
	@Override
	public void invalidState()
	{
		reduceNumberOfStates(7, TokenTypes.METH_DECL_L);
	}
}
