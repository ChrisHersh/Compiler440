package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * 
 * @author Chris Hersh
 *
 */
public class JMCC_4 extends State
{
	/**
	 * Reduce State
	 */
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(3, TokenTypes.EXP1);
    }
    
    /**
     * Shift on and
     */
    @Override
    public void shiftAnd() throws ParserException
    {
        changeToState(new JMCC_10());
    }
    
    /**
     * Shift on OP2
     */
    @Override
    public void shiftOP2() throws ParserException
    {
        changeToState(new JMCC_5());
    }
}
