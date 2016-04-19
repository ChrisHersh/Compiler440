package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;
/**
 * @author Matt Mousetis
 */
public class JCTM_12 extends State 
{
	/**
	 * Reduces to EXP_L
	 */
    @Override
    public void invalidState() throws ParserException
    {
    	reduceNumberOfStates(2, TokenTypes.EXP_L);
    }
}
