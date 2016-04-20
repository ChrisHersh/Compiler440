package parser.states.JCTM;


import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_3;


/**
 * 
 * @author Matt Mousetis
 * 
 */
public class JCTM_11 extends State 
{	
	//Shifts to JMCC_3
	@Override 
    public void shiftOP1() throws ParserException
    {
		changeToState(new JMCC_3());
    }
	//Shifts to JCTM_12
	@Override
	public void shiftEXP_R() throws ParserException
	{
		changeToState(new JCTM_12());
	}
	//Shifts to JCTM_13 also shiftComa is missing an M
	@Override
	public void shiftComa() throws ParserException
	{
		changeToState(new JCTM_13());
	}
}