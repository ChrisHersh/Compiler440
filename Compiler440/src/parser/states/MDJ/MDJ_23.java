package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Class for MDJ_23 states
 * @author Shannon Lee, Jason LoBianco
 *
 */
public class MDJ_23 extends State
{
	/**
	 * Method used to shift on VAR_DECL_L and change to state 25
	 * @author Shannon Jones
	 */
	@Override
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new MDJ_25());
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
