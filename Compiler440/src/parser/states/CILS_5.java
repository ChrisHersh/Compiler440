package parser.states;
import tokenizer.Token;
import tokenizer.TokenTypes;


/**
 * @author Jessica Schlesiger
 */
public class CILS_5 extends State {
	/**
	 * Changes state to CILS_4
	 * @auther Jessica Schlesiger
	 */
	public void shiftRightBrace() throws ParserException	{
		changeToState(new CILS_4());
	}
}
