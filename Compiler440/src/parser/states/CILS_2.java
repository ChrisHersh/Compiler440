package parser.states;

import tokenizer.Token;
/**
 * @author Jessica Schlesiger
 */
import tokenizer.TokenTypes;

public class CILS_2 extends State
{
	/**
	 * Changes state to CILS_3
	 * @auther Jessica Schlesiger
	 */
	public void shiftSTMT() throws ParserException	{
		changeToState(new CILS_3());
	}
	
	/**
	 * Changes state to CILS_3
	 * @auther Jessica Schlesiger
	 */
	public void shiftLeftBrace() throws ParserException	{
		changeToState(new CILS_6());
	}
	

}
