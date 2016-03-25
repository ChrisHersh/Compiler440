package parser.states;
/**
 * 
 * @author Ledny Joseph, Jason LoBianco, TJ Renninger, Chris Kjeldgaard
 *
 */

public class JMCC_5 extends State
{
	/**
	 * @author Ledny Joseph
	 */
	public void shiftEXP3()
	{
	    changeToState(new JMCC_6());
	}
	/**
	 * @author Ledny Joseph
	 */
	public void shiftEXP4()
	{
	    changeToState(new JMCC_8());
	}
	/**
	 * @author Ledny Joseph
	 */
	public void shiftEXP5()
	{
	    changeToState(new JMCC_20());
	}
	/**
	 * @author Ledny Joseph
	 */
	public void shiftEXP6()
	{
	    changeToState(new JMCC_32());
	}
	/**
	 * @author Jason LoBianco
	 */
	public void shiftEXP7()
	{
	    changeToState(new JMCC_29());
	}
	/**
	 * @author Jason LoBianco
	 */
	public void shiftId()
	{
	    changeToState(new JCTM_1());
	}
	/**
	 * @author Jason LoBianco
	 */
	public void shiftIntegerLiteral()
	{
	    changeToState(new JCTM_18());
	}
	/**
	 * @author TJ Renninger
	 */
	public void shiftTrue()
	{
	    changeToState(new JCTM_15());
	}
	/**
	 * @author TJ Renninger
	 */
	public void shiftFalse()
	{
	    changeToState(new JCTM_16());
	}
	/**
	 * @author TJ Renninger
	 */
	public void shiftThis()
	{
	    changeToState(new JCTM_17());
	}
	/**
	 * @author Chris Kjeldgaard
	 */
	public void shiftNew()
	{
	    changeToState(new JCTM_19());
	}
	/**
	 * @author Chris Kjeldgaard
	 */
	public void shiftExclamation()
	{
	    changeToState(new JCTM_27());
	}
	/**
	 * @author Chris Kjeldgaard
	 */
	public void shiftLeftBrace()
	{
	    changeToState(new JCTM_29());
	}
}
