package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Ian Keefer
 *
 */
public class JCTM_24 extends State {
	
    @Override
    public void shiftLeftPara() throws ParserException
    {
        changeToState(new JCTM_25());
    }

}
