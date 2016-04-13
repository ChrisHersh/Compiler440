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
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(3, TokenTypes.EXP1);
    }
    
    @Override
    public void shiftAnd() throws ParserException
    {
        changeToState(new JMCC_10());
    }
    
    @Override
    public void shiftOP2() throws ParserException
    {
        changeToState(new JMCC_5());
    }
}
