package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * 
 * @author Chris Hersh
 *
 */
public class JMCC_6 extends State 
{

	/**
	 * Reduce state
	 */
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(3, TokenTypes.EXP2);
    }
    
    /**
     * Shift on !=
     */
    @Override
    public void shiftNotEquals() throws ParserException
    {
        changeToState(new JMCC_17());
    }
    
    /**
     * Shift on ==
     */
    @Override
    public void shiftEquals() throws ParserException
    {
        changeToState(new JMCC_16());
    }
    
    /**
     * Shift on OP3
     */
    @Override
    public void shiftOP3() throws ParserException
    {
        changeToState(new JMCC_30());
    }
}
