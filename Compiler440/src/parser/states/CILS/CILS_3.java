package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.Token;
/**
 * @author Jessica Schlesiger
 */
import tokenizer.TokenTypes;

public class CILS_3 extends State {
	/**
	 * reduces to the current state and generates the token STMT_P
	 * @author Jessica Schlesiger
	 */
	@Override
	protected void invalidState() throws ParserException
	{
		currentParser.pushInputStack(new Token(TokenTypes.STMT_P.name(), TokenTypes.STMT_P.toString(), currentParser.peekInputStack().getLineNumber()));
	}
}
