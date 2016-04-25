package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Ian Keefer
 *
 */
public class JCTM_8 extends State
{
	
    @Override
    public void shiftEXP_L() throws ParserException
    {
        changeToState(new JCTM_9());
    }

}