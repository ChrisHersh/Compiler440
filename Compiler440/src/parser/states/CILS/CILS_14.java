package parser.states.CILS;

import parser.states.State;
import parser.states.JCTM.JCTM_1;
import parser.states.JCTM.JCTM_15;
import parser.states.JCTM.JCTM_16;
import parser.states.JCTM.JCTM_17;
import parser.states.JCTM.JCTM_18;
import parser.states.JCTM.JCTM_19;
import parser.states.JCTM.JCTM_27;
import parser.states.JCTM.JCTM_29;
import parser.states.JMCC.JMCC_15;
import parser.states.JMCC.JMCC_20;
import parser.states.JMCC.JMCC_32;
import parser.states.JMCC.JMCC_33;
import parser.states.JMCC.JMCC_8;
import parser.states.JMCC.JMCC_9;

/**
 *This class is CILS_14 which represents this: STMT -> id =• EXP1;
 * 
 * @author Raistlin Hess
 */
public class CILS_14 extends State 
{
	/**
	 * If the input is EXP1, this shifts to CILS_18
	 */
	@Override
	public void shiftEXP1()
	{
		changeToState(new CILS_18());
	}
	
	/**
	 * If the input is EXP2, this shifts to JMCC_9
	 */
	@Override
	public void shiftEXP2()
	{
		changeToState(new JMCC_9());
	}
	
	/**
	 * If the input is EXP3, this shifts to JMCC_15
	 */
	@Override
	public void shiftEXP3()
	{
		changeToState(new JMCC_15());
	}
	
	/**
	 * If the input is EXP4, this shifts to JMCC_8
	 */
	@Override
	public void shiftEXP4()
	{
		changeToState(new JMCC_8());
	}
	
	/**
	 * If the input is EXP5, this shifts to JMCC_20
	 */
	@Override
	public void shiftEXP5()
	{
		changeToState(new JMCC_20());
	}
	
	/**
	 * If the input is EXP6, this shifts to JMCC_32
	 */
	@Override
	public void shiftEXP6()
	{
		changeToState(new JMCC_32());
	}
	
	/**
	 * If the input is EXP7, this shifts to JMCC_33
	 */
	@Override
	public void shiftEXP7()
	{
		changeToState(new JMCC_33());
	}
	
	/**
	 * If the input is true, this shifts to JCTM_15
	 */
	@Override
	public void shiftTrue()
	{
		changeToState(new JCTM_15());
	}
	
	/**
	 * If the input is new, this shifts to JCTM_19
	 */
	@Override
	public void shiftNew()
	{
		changeToState(new JCTM_19());
	}
	
	/**
	 * If the input is INT_LIT, this shifts to JCTM_18
	 */
	@Override
	public void shiftIntegerLiteral()
	{
		changeToState(new JCTM_18());
	}
	
	/**
	 * If the input is !, this shifts to JCTM_27
	 */
	@Override
	public void shiftNot()
	{
		changeToState(new JCTM_27());
	}
	
	/**
	 * If the input is false, this shifts to JCTM_16
	 */
	@Override
	public void shiftFalse()
	{
		changeToState(new JCTM_16());
	}
	
	/**
	 * If the input is id, this shifts to JCTM_1
	 */
	@Override
	public void shiftId()
	{
		changeToState(new JCTM_1());
	}
	
	/**
	 * If the input is (, this shifts to JCTM_29
	 */
	@Override
	public void shiftLeftPara()
	{
		changeToState(new JCTM_29());
	}
	
	/**
	 * If the input is this, this shifts to JCTM_17
	 */
	@Override
	public void shiftThis()
	{
		changeToState(new JCTM_17());
	}
}
