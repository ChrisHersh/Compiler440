package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * 
 * @author Chris Hersh
 *
 */
public class JMCC_9 extends State 
{
	/**
	 * Reduce state
	 */
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.EXP1);
    }
    
    /**
     * Shift on OP2
     */
    @Override
    public void shiftOP2() throws ParserException
    {
        changeToState(new JMCC_5());
    }
    
    /**
     * Shift on and
     */
    @Override
    public void shiftAnd() throws ParserException
    {
        changeToState(new JMCC_10());
    }
}
