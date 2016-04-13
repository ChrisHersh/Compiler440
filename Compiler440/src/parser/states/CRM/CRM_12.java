package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * Implements the methods from state CRM_12
 * @author Jason LoBianco
 */
public class CRM_12 extends State 
{
	/**
	 * reduces back to state CRM_2 and creates a TYPE token
	 * @author Jason LoBianco
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(1, TokenTypes.TYPE);
	}
}
