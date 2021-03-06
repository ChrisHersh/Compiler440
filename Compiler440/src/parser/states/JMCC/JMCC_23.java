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
import parser.states.JMCC.JMCC_24;
import parser.states.JMCC.JMCC_29;

/**
 * A parser state for JMCC_23.
 * @author Manal Ibrahim, Chad Nunemaker, Ian Keefer
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
	 * @author Chad Nunemaker
	 */
    @Override
    public void shiftEXP6() throws ParserException
    {
        changeToState(new JMCC_24());
    }
    
    /**
     * Shift to JMCC_29 if the shift is EXP7
     * @author Chad Nunemaker
     */
    @Override
    public void shiftEXP7() throws ParserException
    {
        changeToState(new JMCC_29());
    }
    
    /**
     * @author Manal Ibrahim, 
     * handle id transition Shift state to {JCTM_18} 
     * */
    @Override
    public void shiftIntegerLiteral() throws ParserException
    {
        changeToState(new JCTM_18());
    }
    
    /**
     * @author Manal Ibrahim, 
     * handle True transition Shift state to {JCTM_15} 
     * */ 
    
    @Override
 	public void shiftTrue() throws ParserException
 	{
 	    changeToState(new JCTM_15());
 	}
    
    /**
     * @author Manal Ibrahim,
     * handle False transition Shift state to {JCTM_16}  
     * */ 
     @Override
 	public void shiftFalse() throws ParserException
 	{
 	    changeToState(new JCTM_16());
 	}
 
 	/**
 	 * @author Corey Peregord 
 	 * Shift to JMCC_19 if the shift is new
 	 */
    @Override
    public void shiftNew() throws ParserException
    {
        changeToState(new JCTM_19());
    }
    
	/**
	 * @author Corey Peregord 
	 * Shift to JMCC_27 if the shift is !
	 */
    @Override
    public void shiftExclamation() throws ParserException
    {
        changeToState(new JCTM_27());
    }
    
	/**
	 * @author Corey Peregord 
	 * Shift to JMCC_2p if the shift is (
	 */
    @Override
    public void shiftLeftPara() throws ParserException
    {
        changeToState(new JCTM_29());
    }
    /**
     * Mohammed
     * handle id transition Shift state to {JCTM_1} 
     */
    @Override
    public void shiftId() throws ParserException
    {
        changeToState(new JCTM_1());
    }
    /**
     * Mohammed
     * handle THIS transition Shift state to {JCTM_17} 
     */
    
    @Override
    public void shiftThis() throws ParserException
    {
        changeToState(new JCTM_17());
    }
}
