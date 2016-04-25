package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * State for JCTM 26
 * @author Chris Hersh
 *
 */
public class JCTM_26 extends State
{

	/**
	 * Reduce tokens
	 */
	@Override
	public void invalidState() throws ParserException 
	{
		reduceNumberOfStates(4, TokenTypes.EXP7);
	}
	
}
