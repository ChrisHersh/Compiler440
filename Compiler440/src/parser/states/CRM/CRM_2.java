package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class CRM_2 extends State
{
	/**
	 * Changes to state CRM_3
	 * @author Chris Kjeldgaard
	 */
	public void shiftVAR_DECL() throws ParserException
	{
		changeToState(new CRM_3());
	}
	
	/**
	 * Changes the state to CMR_4
	 * @author TJ Renninger
	 */
	public void shiftSTMT_P()
	{
		changeToState(new CRM_4());
	}
	
	/**
	 * reduces to the current state and generates the token STMT_P
	 * @author Jason LoBianco
	 */
	@Override
	public void invalidState()
	{
		currentParser.pushInputStack(new Token(TokenTypes.STMT_P.name(), TokenTypes.STMT_P.toString(), currentParser.peekInputStack().getLineNumber()));
	}
}
