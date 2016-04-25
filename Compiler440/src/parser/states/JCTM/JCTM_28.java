package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_2;
import parser.states.JMCC.JMCC_3;
import tokenizer.TokenTypes;

/**
 * State for JCTM_28
 * @author Chris Hersh
 *
 */
public class JCTM_28 extends State 
{
	/**
	 * Shift on OP1
	 */
	@Override
	public void shiftOP1() throws ParserException 
	{
		changeToState(new JMCC_3());
	}
	
	/**
	 * Shift on OP1
	 */
	@Override
	public void shiftOr() throws ParserException 
	{
		changeToState(new JMCC_2());
	}
	
	/**
	 * Shift on OP1
	 */
	@Override
	public void invalidState() throws ParserException 
	{
		reduceNumberOfStates(2, TokenTypes.EXP7);
	}
}
