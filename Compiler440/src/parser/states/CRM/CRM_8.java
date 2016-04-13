package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * Implements the methods from state CRM_8
 * @author Jason LoBianco
 */
public class CRM_8 extends State 
{
	/**
	 * reduces back to the state CRM_5 and creates a VAR_DECL token
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(3, TokenTypes.VAR_DECL);
	}
}
