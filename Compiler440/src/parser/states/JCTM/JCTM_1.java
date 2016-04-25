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

    //Shift Period
    @Override
    public void shiftPeriod() throws ParserException
    {
        changeToState(new JCTM_3());
    }
    
  //Shift Left Brace
    @Override
    public void shiftLeftBrace() throws ParserException
    {
        changeToState(new JCTM_2());
    }
    
  //Reduce to EXP7
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.EXP7);
    }
}
