package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * Implements the methods from state CRM_9
 * @author Jason LoBianco
 */
public class CRM_9 extends State 
{
	/**
	 * changes to state CRM_10
	 * @author Jason LoBianco
	 */
	public void shiftLeftBracket() throws ParserException
	{
		changeToState(new CRM_10());
	}
	
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
