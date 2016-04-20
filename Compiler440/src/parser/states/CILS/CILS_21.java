
package parser.states.CILS;

import parser.states.State;
import tokenizer.TokenTypes;

/**
 *This class is CILS_21 which represents this:
 * STMT -> id = EXP1;�
 * @author Manal Ibrahim
 */
public class CILS_21 extends State 
{
	/**
	 * Since there can be no more inputs, reduce to CILS_5
	 */
	@Override
	public void invalidState()
	{
		reduceNumberOfStates(5, TokenTypes.SemiColon);
	}
}

