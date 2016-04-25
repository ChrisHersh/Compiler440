package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.*;

/**
 * JCTM_4 State
 * @author Daniel Breitigan
 *
 */
public class JCTM_4 extends State
{
    @Override
    public void shiftRightBracket() throws ParserException
    {
        changeToState(new JCTM_5());
    }
    
    @Override
    public void shiftOP1() throws ParserException
    {
        changeToState(new JMCC_3());
    }
    
    @Override
    public void shiftOr() throws ParserException
    {
        changeToState(new JMCC_2());
    }
}
