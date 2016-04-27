package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * 
 * @author Ian Keefer
 *
 */
public class JMCC_24 extends State
{
	
	/**
	 * Invalidity of state
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(3, TokenTypes.EXP5);
		
	}

}
