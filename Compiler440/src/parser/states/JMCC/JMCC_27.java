package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JCTM.JCTM_1;
import parser.states.JCTM.JCTM_15;
import parser.states.JCTM.JCTM_16;
import parser.states.JCTM.JCTM_17;
import parser.states.JCTM.JCTM_18;
import parser.states.JCTM.JCTM_19;
import parser.states.JCTM.JCTM_27;
import parser.states.JCTM.JCTM_29;

/**
 * 
 * @author Ian Keefer, Chris Hersh, Daniel Breitigan, Matt Mousetis
 *
 */
public class JMCC_27 extends State
{
	
	/**
	 * Shift to JMCC_32 if the shift is EXP6.
	 */
	@Override
	public void shiftEXP6() throws ParserException
	{
		changeToState(new JMCC_32());
	}
	
	/**
	 * Shift state to {@link JMCC_28} on a EXP7 token
	 */
    @Override
    public void shiftEXP7() throws ParserException
    {
        changeToState(new JMCC_28());
    }
    
    /**
     * Shift state to {@link JMCC_18} on an IntegerLiteral token
     */
    @Override
    public void shiftIntegerLiteral() throws ParserException
    {
        changeToState(new JCTM_18());
    }
    
	/**
	 * Shift to JMCC_15 if the shift is true.
	 */
    @Override
	public void shiftTrue() throws ParserException
	{
	    changeToState(new JCTM_15());
	}
    
	/**
	 * Shift to JMCC_16 if the shift is false.
	 */
    @Override
	public void shiftFalse() throws ParserException
	{
	    changeToState(new JCTM_16());
	}

	/**
	 * Shift to JMCC_17 if the shift is this.
	 */
    @Override
	public void shiftThis()throws ParserException
	{
	    changeToState(new JCTM_17());
	}
	
	/**
	 * Shift to JMCC_1 if the shift is id.
	 */
    @Override
	public void shiftId() throws ParserException
	{
	    changeToState(new JCTM_1());
	}
    
	/**
	 * Shift to JMCC_19 if the shift is new.
	 */
    @Override
    public void shiftNew() throws ParserException
    {
        changeToState(new JCTM_19());
    }
    
	/**
	 * Shift to JMCC_27 if the shift is exclamation.
	 */
    @Override
    public void shiftExclamation() throws ParserException
    {
        changeToState(new JCTM_27());
    }
    
	/**
	 * Shift to JMCC_29 if the shift is left para.
	 */
    @Override
    public void shiftLeftPara() throws ParserException
    {
        changeToState(new JCTM_29());
    }
}
