package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;

/**
 * JCTM_7 State
 * @author Daniel Breitigan
 *
 */
public class JCTM_7 extends State
{
    //Shift left parenthesis
    @Override
    public void shiftLeftPara() throws ParserException
    {
        changeToState(new JCTM_8());
    }
}
