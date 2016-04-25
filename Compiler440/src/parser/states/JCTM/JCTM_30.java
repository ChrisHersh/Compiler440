package parser.states.JCTM;

import org.junit.Before;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_2;
import parser.states.JMCC.JMCC_3;

/**
 * State for JCTM_30
 * @author Chris Hersh
 *
 */
public class JCTM_30 extends State
{
	
	/**
	 * Reset the parser
	 */
    @Before
    public void setUp()
    {
        Parser.resetParser();
    }
    
	/**
	 * Shift on OP1
	 */
	@Override
	public void shiftOP1() throws ParserException 
	{
		changeToState(new JMCC_3());
	}
	
	/**
	 * Shift on OP1
	 */
	@Override
	public void shiftOr() throws ParserException 
	{
		changeToState(new JMCC_2());
	}
	
	/**
	 * Shift on OP1
	 */
	@Override
	public void shiftRightPara() throws ParserException 
	{
		changeToState(new JCTM_31());
	}

	
}
