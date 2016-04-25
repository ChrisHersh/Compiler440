package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_2;

/**
 * 
 * @author Ian Keefer
 *
 */
public class JCTM_22 extends State {
	
    @Override
    public void shiftOr() throws ParserException
    {
        changeToState(new JMCC_2());
    }

}
