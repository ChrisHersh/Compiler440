package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;
/**
 * Implement JMCC_8
 * @author Daniel Breitigan
 *
 */
public class JMCC_8 extends State 
{

    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.EXP3);
    }
    
    @Override
    public void shiftOP4() throws ParserException
    {
        changeToState(new JMCC_7());
    }
    @Override
    public void shiftGt() throws ParserException
    {
        changeToState(new JMCC_11());
    }
    
    @Override
    public void shiftLt() throws ParserException
    {
        changeToState(new JMCC_12());
    }
    
    @Override
    public void shiftGtEquals() throws ParserException
    {
        changeToState(new JMCC_13());
    }
    
    @Override
    public void shiftLtEquals() throws ParserException
    {
        changeToState(new JMCC_14());
    }
}
