package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_2;
import parser.states.JMCC.JMCC_3;
import tokenizer.TokenTypes;

/**
 * State for JCTM_31
 * @author Chris Hersh
 *
 */
public class JCTM_31 extends State 
{
	@Override
	public void invalidState() throws ParserException 
	{
		reduceNumberOfStates(3, TokenTypes.EXP7);
	}
		
}
