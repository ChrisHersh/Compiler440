package parser.states;
/**
 * @author Jason LoBianco
 */
import tokenizer.Token;
import tokenizer.TokenTypes;

public class CRM_14 extends State
{
	/**
	 * Changes to state CRM_15
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new CRM_15());
	}
	
	/**
	 * reduces to the current state and generates the token VAR_DECL_L
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	@Override
	protected void invalidState() throws ParserException
	{
		currentParser.pushInputStack(new Token(TokenTypes.VAR_DECL_L.name(), TokenTypes.VAR_DECL_L.toString(), currentParser.peekInputStack().getLineNumber()));
	}
}
