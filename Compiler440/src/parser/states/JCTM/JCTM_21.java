package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Ian Keefer
 *
 */
public class JCTM_21 extends State {
	
    @Override
    public void shiftEXP1() throws ParserException
    {
        changeToState(new JCTM_22());
    }

}
