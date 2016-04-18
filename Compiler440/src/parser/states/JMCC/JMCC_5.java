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
 * Implements the methods from state JMCC_5.
 * @author Ledny Joseph, Jason LoBianco, TJ Renninger, Chris Kjeldgaard
 */

public class JMCC_5 extends State
{
	/**
	 * changes to state JMCC_6
	 * @author Ledny Joseph
	 */
	public void shiftEXP3()
	{
	    changeToState(new JMCC_6());
	}
	
	/**
	 * changes to state JMCC_8
	 * @author Ledny Joseph
	 */
	public void shiftEXP4()
	{
	    changeToState(new JMCC_8());
	}
	
	/**
	 * changes to state JMCC_20
	 * @author Ledny Joseph
	 */
	public void shiftEXP5()
	{
	    changeToState(new JMCC_20());
	}
	
	/**
	 * changes to state JMCC_32
	 * @author Ledny Joseph
	 */
	public void shiftEXP6()
	{
	    changeToState(new JMCC_32());
	}
	
	/**
	 * changes to state JMCC_29
	 * @author Jason LoBianco
	 */
	public void shiftEXP7()
	{
	    changeToState(new JMCC_29());
	}
	
	/**
	 * changes to state JCTM_1
	 * @author Jason LoBianco
	 */
	public void shiftId()
	{
	    changeToState(new JCTM_1());
	}
	
	/**
	 * changes to state JCTM_18
	 * @author Jason LoBianco
	 */
	public void shiftIntegerLiteral()
	{
	    changeToState(new JCTM_18());
	}
	
	/**
	 * changes to state JCTM_15
	 * @author TJ Renninger
	 */
	public void shiftTrue()
	{
	    changeToState(new JCTM_15());
	}
	
	/**
	 * changes to state JCTM_16
	 * @author TJ Renninger
	 */
	public void shiftFalse()
	{
	    changeToState(new JCTM_16());
	}
	
	/**
	 * changes to state JCTM_17
	 * @author TJ Renninger
	 */
	public void shiftThis()
	{
	    changeToState(new JCTM_17());
	}
	
	/**
	 * changes to state JCTM_19
	 * @author Chris Kjeldgaard
	 */
	public void shiftNew()
	{
	    changeToState(new JCTM_19());
	}
	
	/**
	 * changes to state JCTM_27
	 * @author Chris Kjeldgaard
	 */
	public void shiftExclamation()
	{
	    changeToState(new JCTM_27());
	}
	
	/**
	 * changes to state JCTM_29
	 * @author Chris Kjeldgaard
	 */
	public void shiftLeftBrace()
	{
	    changeToState(new JCTM_29());
	}
}
