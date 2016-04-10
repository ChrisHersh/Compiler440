package parser.states;

import tokenizer.TokenTypes;
/**
 * Implements the methods from state CRM_13
 * @author Jason LoBianco
 */
public class CRM_13 extends State 
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
