package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_3;
import tokenizer.TokenTypes;

/**
 * @author Matt Mousetis
 */

public class JCTM_14 extends State 
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
     * reduce to EXP_R
     */
    
    @Override
    public void invalidState() throws ParserException
    {
    	reduceNumberOfStates(1, TokenTypes.EXP_R);
    }
}
