package parser.states;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Implements the methods from state CRM_16
 * @author Jason LoBianco
 */
public class CRM_16 extends State
{
	/**
	 * changes to state CRM_18
	 * @author Jason LoBianco
	 */
	public void shiftMETH_DECL_L()
	{
		changeToState(new CRM_18());
	}
	
	/**
	 * reduces to the current state and generates the token METH_DECL_L
	 * @author Jason LoBianco
	 */
	@Override
	public void invalidState()
	{
		currentParser.pushInputStack(new Token(TokenTypes.METH_DECL_L.name(), TokenTypes.METH_DECL_L.toString(), currentParser.peekInputStack().getLineNumber()));
	}
}
