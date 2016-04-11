package parser.states;

import parser.states.JCTM_1;
import parser.states.JCTM_15;
import parser.states.JCTM_16;
import parser.states.JCTM_17;
import parser.states.JCTM_18;
import parser.states.JCTM_19;
import parser.states.JCTM_27;
import parser.states.JCTM_29;
import parser.states.JMCC_24;
import parser.states.JMCC_29;
import parser.states.ParserException;
import parser.states.State;

/*
 * @author Manal Ibrahim, 
 * */
public class JMCC_23 extends State
{
	
	/**
	 * Shift to JMCC_20 if the shift is EXP5.
	 */
	@Override
	public void shiftEXP5() throws ParserException
	{
		changeToState(new JMCC_20());
	}
	
	/**
	 * Shift to JMCC_24 if the shift is EXP6
	 */
    @Override
    public void shiftEXP6() throws ParserException
    {
        changeToState(new JMCC_24());
    }
    
    @Override
    public void shiftEXP7() throws ParserException
    {
        changeToState(new JMCC_29());
    }
    
    /*
     * @author Manal Ibrahim, 
     * */
    @Override
    public void shiftIntegerLiteral() throws ParserException
    {
        changeToState(new JCTM_18());
    }
    
    /*
     * @author Manal Ibrahim, 
     * */ 
    
    @Override
 	public void shiftTrue() throws ParserException
 	{
 	    changeToState(new JCTM_15());
 	}
    
    /*
     * @author Manal Ibrahim, 
     * */ 
     @Override
 	public void shiftFalse() throws ParserException
 	{
 	    changeToState(new JCTM_16());
 	}
 
    @Override
    public void shiftNew() throws ParserException
    {
        changeToState(new JCTM_19());
    }
    
    @Override
    public void shiftExclamation() throws ParserException
    {
        changeToState(new JCTM_27());
    }
    
    @Override
    public void shiftLeftPara() throws ParserException
    {
        changeToState(new JCTM_29());
    }
    
    @Override
    public void shiftId() throws ParserException
    {
        changeToState(new JCTM_1());
    }
    
    @Override
    public void shiftThis() throws ParserException
    {
        changeToState(new JCTM_17());
    }
}
