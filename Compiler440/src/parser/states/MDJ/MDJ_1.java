package parser.states.MDJ;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * A parser state for MDJ_1.
 * @author Chad Nunemaker
 */
public class MDJ_1 extends State
{
	/**
	 * changes to state MDJ_3 when a "CLASS_DECL_L" token is read
	 */
	public void shiftCLASS_DECL_L() throws ParserException
	{
		changeToState(new MDJ_3());
	}

	/**
	 * reduces to MDJ_1 (itself) and generates a CLASS_DECL_L token
	 * @throws ParserException a parsing error has occurred
	 */
	@Override
	public void invalidState() throws ParserException
	{
		currentParser.pushInputStack(new Token(TokenTypes.CLASS_DECL_L.name(), TokenTypes.CLASS_DECL_L.toString(), currentParser.peekInputStack().getLineNumber()));
	}
}
