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
  //Shift Right Bracket
    @Override
    public void shiftRightBracket() throws ParserException
    {
        changeToState(new JCTM_5());
    }
    
  //Shift OP1
    @Override
    public void shiftOP1() throws ParserException
    {
        changeToState(new JMCC_3());
    }
    
  //Shift Or
    @Override
    public void shiftOr() throws ParserException
    {
        changeToState(new JMCC_2());
    }
}
