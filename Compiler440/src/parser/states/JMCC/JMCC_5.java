package parser.states.JMCC;

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
 * @author Ledny Joseph, Jason LoBianco, TJ Renninger, Chris Kjeldgaard
 *
 */

public class JMCC_5 extends State
{
	/**
	 * Shift on EXP3
	 * @author Ledny Joseph
	 */
	public void shiftEXP3()
	{
	    changeToState(new JMCC_6());
	}
	/**
	 * Shift on EXP4
	 * @author Ledny Joseph
	 */
	public void shiftEXP4()
	{
	    changeToState(new JMCC_8());
	}
	/**
	 * Shift on EXP5
	 * @author Ledny Joseph
	 */
	public void shiftEXP5()
	{
	    changeToState(new JMCC_20());
	}
	/**
	 * Shift on EXP6
	 * @author Ledny Joseph
	 */
	public void shiftEXP6()
	{
	    changeToState(new JMCC_32());
	}
	/**
	 * Shift on EXP7
	 * @author Jason LoBianco
	 */
	public void shiftEXP7()
	{
	    changeToState(new JMCC_29());
	}
	/**
	 * Shift on id
	 * @author Jason LoBianco
	 */
	public void shiftId()
	{
	    changeToState(new JCTM_1());
	}
	/**
	 * Shift on integer literal
	 * @author Jason LoBianco
	 */
	public void shiftIntegerLiteral()
	{
	    changeToState(new JCTM_18());
	}
	/**
	 * Shift on true
	 * @author TJ Renninger
	 */
	public void shiftTrue()
	{
	    changeToState(new JCTM_15());
	}
	/**
	 * Shift on false
	 * @author TJ Renninger
	 */
	public void shiftFalse()
	{
	    changeToState(new JCTM_16());
	}
	/**
	 * Shift on this
	 * @author TJ Renninger
	 */
	public void shiftThis()
	{
	    changeToState(new JCTM_17());
	}
	/**
	 * Shift on new
	 * @author Chris Kjeldgaard
	 */
	public void shiftNew()
	{
	    changeToState(new JCTM_19());
	}
	/**
	 * Shift on !
	 * @author Chris Kjeldgaard
	 */
	public void shiftExclamation()
	{
	    changeToState(new JCTM_27());
	}
	/**
	 * Shift on {
	 * @author Chris Kjeldgaard
	 */
	public void shiftLeftBrace()
	{
	    changeToState(new JCTM_29());
	}
}
