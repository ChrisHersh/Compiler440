package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 *This class is CILS_32 which represents this: STMT -> While ( EXP1 ) STMT
 * 
 * @author Mohammed
 */
public class CILS_32 extends State 
{
	/**
	 * because we do not have no more inputs, reduce to CILS_5
	 */
	@Override
	public void invalidState() throws ParserException
	{
		reduceNumberOfStates(5, TokenTypes.STMT);
	}
}
