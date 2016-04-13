package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;
/**
 * @author Chris Kjeldgaard, Jason LoBianco
 */
import tokenizer.TokenTypes;

public class CRM_1 extends State
{
	/**
	 * Changes to state CRM_2
	 * @author Chris Kjeldgaard
	 */
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new CRM_2());
	}
	
	/**
	 * reduces to the current state and generates the token VAR_DECL_L
	 * @author Jason LoBianco
	 */
	@Override
	public void invalidState() throws ParserException
	{
		currentParser.pushInputStack(new Token(TokenTypes.VAR_DECL_L.name(), TokenTypes.VAR_DECL_L.toString(), currentParser.peekInputStack().getLineNumber()));
	}
}
