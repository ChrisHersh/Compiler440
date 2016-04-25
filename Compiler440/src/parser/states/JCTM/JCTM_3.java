package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;

/**
 * JCTM_3 state
 * @author Daniel Breitigan
 *
 */
public class JCTM_3 extends State
{

    //shift Length
    public void shiftLength() throws ParserException
    {
        changeToState(new JCTM_6());
    }
    
    //shift Id
    public void shiftId() throws ParserException
    {
        changeToState(new JCTM_7());
    }
    
}
