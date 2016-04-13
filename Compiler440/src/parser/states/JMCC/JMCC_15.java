package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * @author Chris Hersh
 *
 */
public class JMCC_15 extends State
{
    @Override
    protected void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.EXP2);
    }
    
    @Override
    public void shiftOP3() throws ParserException
    {
        changeToState(new JMCC_30());
    }
    
    @Override
    public void shiftNotEquals() throws ParserException
    {
        changeToState(new JMCC_17());
    }
    
    @Override
    public void shiftEquals() throws ParserException
    {
        changeToState(new JMCC_16());
    }
}
