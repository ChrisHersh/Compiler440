package parser.states.CILS;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 *This class is CILS_4 which represents this: STMT -> {STMP_P}•
 * 
 * @author Raistlin Hess
 */
public class CILS_4 extends State
{
	/**
	 * Since there can be no more inputs, reduce to CILS_2
	 */
	@Override
	public void invalidState()
	{
		reduceNumberOfStates(3, TokenTypes.STMT);
	}
}
