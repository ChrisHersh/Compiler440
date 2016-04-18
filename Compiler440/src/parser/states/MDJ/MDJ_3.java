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
	 * @author Corey Peregord 
	 * Changes to state MDJ_4 on "CLASS_DECL" token
	 */
	@Override
	public void shiftCLASS_DECL() throws ParserException
	{
		changeToState(new MDJ_4());
	}
	
	/**
	 * @author Corey Peregord 
	 * Reduces to MDJ_0 and generates the token "PROG"
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(2, TokenTypes.PROG);
	}
}