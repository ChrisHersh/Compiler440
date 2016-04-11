package parser.states;

import tokenizer.TokenTypes;

/**
 * Implements the methods from state CRM_11
 * @author Jason LoBianco
 */
public class CRM_11 extends State 
{
	/**
	 * reduces back to state CRM_2 and creates a TYPE token
	 * @author Jason LoBianco
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(3, TokenTypes.TYPE);
	}
}
