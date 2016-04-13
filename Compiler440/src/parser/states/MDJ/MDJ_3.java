package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * 
 * @author Jessica Schlesiger
 * MDJ_3 state. Ensure this state can properly shift to MDJ_17 on "class" token
 */
public class MDJ_3 extends State
{
	/**
	 * Changes to state MDJ_17 on "class" token
	 */
	@Override
	public void shiftClass() throws ParserException
	{
		changeToState(new MDJ_17());
	}
	
	/**
	 * Changes to state MDJ_4 on "CLASS_DECL" token
	 */
	@Override
	public void shiftCLASS_DECL() throws ParserException
	{
		changeToState(new MDJ_4());
	}
	
	/**
	 * Reduces to MDJ_0 and generates the token "PROG"
	 */
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(new MDJ_0(), TokenTypes.PROG);
	}
}