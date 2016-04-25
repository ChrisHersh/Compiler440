package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;
/**
 * JMCC_8
 * @author Daniel Breitigan
 *
 */
public class JMCC_8 extends State 
{

    //Reduce to EXP3
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.EXP3);
    }
    
  //Shift OP4
    @Override
    public void shiftOP4() throws ParserException
    {
        changeToState(new JMCC_7());
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
    
    //Shift less Than Equals
    @Override
    public void shiftLtEquals() throws ParserException
    {
        changeToState(new JMCC_14());
    }
}
