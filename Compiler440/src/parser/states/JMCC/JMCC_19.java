package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * JMCC_19
 * A reduce state for EXP4
 * @author Daniel Breitigan
 *
 */

public class JMCC_19 extends State 
{
    //Override the invalidState so that we can reduce when none of the other options are found.
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(3, TokenTypes.EXP3);
    }
  //Shift OP4
    @Override
    public void shiftOP4() throws ParserException
    {
        changeToState(new JMCC_31());
    }
    
  //Shift Greater Than
    @Override
    public void shiftGt() throws ParserException
    {
        changeToState(new JMCC_11());
    }
    
  //Shift Less Than
    @Override
    public void shiftLt() throws ParserException
    {
        changeToState(new JMCC_12());
    }
    
  //Shift Greater Than Equals
    @Override
    public void shiftGtEquals() throws ParserException
    {
        changeToState(new JMCC_13());
    }
    
  //Shift Less Than Equals
    @Override
    public void shiftLtEquals() throws ParserException
    {
        changeToState(new JMCC_14());
    }
    
    
}
