package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * JCTM_1 State
 * @author Daniel Breitigan
 *
 */
public class JCTM_1 extends State 
{

    @Override
    public void shiftPeriod() throws ParserException
    {
        changeToState(new JCTM_3());
    }
    
    @Override
    public void shiftLeftBrace() throws ParserException
    {
        changeToState(new JCTM_2());
    }
    
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.EXP7);
    }
}
