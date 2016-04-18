package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Chris Hersh
 *
 */
public class JMCC_1 extends State 
{

	/**
	 * Shift on OP1
	 */
    @Override
    public void shiftOP1() throws ParserException
    {
        changeToState(new JMCC_3());
    }
    
    /**
     * Shift on or
     */
    @Override
    public void shiftOr() throws ParserException
    {
        changeToState(new JMCC_2());
    }
}
