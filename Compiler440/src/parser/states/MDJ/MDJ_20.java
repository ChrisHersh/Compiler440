package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * 
 * @author Jessica Schlesiger, Jason LoBianco
 * MDJ_20 state. Ensure this state can properly shift to MDJ_22 on "VAR_DECL_L" token
 * and reduce to currect state on "empty string" token.
 */
public class MDJ_20 extends State
{
	/**
	 * Changes to state MDJ_22 on "VAR_DECL_L" token
	 */
	@Override
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new MDJ_22());
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