package parser.states;
import tokenizer.Token;
import tokenizer.TokenTypes;


/**
 * @author Jessica Schlesiger
 */
public class CILS_6 extends State {
	/**
	 * Changes state to CILS_5
	 * @auther Jessica Schlesiger
	 */
	public void shiftSTMT_P() throws ParserException	{
		changeToState(new CILS_5());
	}
}
