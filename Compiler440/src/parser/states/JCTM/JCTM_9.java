package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Ian Keefer
 *
 */
public class JCTM_9 extends State
{
	
    @Override
    public void shiftRightPara() throws ParserException
    {
        changeToState(new JCTM_10());
    }

}