package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Ian Keefer
 *
 */
public class JCTM_25 extends State {
	
    @Override
    public void shiftRightPara() throws ParserException
    {
        changeToState(new JCTM_26());
    }

}
