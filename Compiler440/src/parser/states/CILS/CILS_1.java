
package parser.states.CILS;

import parser.states.State;
import tokenizer.TokenTypes;

/**
 * This class is CILS_1 which represents this: STMT_P ->•STMT_P STMT
 *											   STMT_P ->•ε
 * 
 * @author Raistlin Hess
 */
public class CILS_1 extends State
{
	/**
	 * If the input is STMT_P, this shifts to CILS_2
	 */
	@Override
	public void shiftSTMT_P()
	{
		changeToState(new CILS_2());
	}
	
	/**
	 * Treat input as epsilon, reduce to CILS_1
	 */
	@Override
	public void invalidState()
	{
		reduceToState(new CILS_1(), TokenTypes.Epsilon);
	}
}
