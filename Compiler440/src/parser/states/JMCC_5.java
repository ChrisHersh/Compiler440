package parser.states;


public class JMCC_5 extends State
{
	/**
	 * @author Ledny Joseph
	 */
	public void shiftEXP3()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JMCC_6());
	}
	/**
	 * @author Ledny Joseph
	 */
	public void shiftEXP4()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JMCC_8());
	}
	/**
	 * @author Ledny Joseph
	 */
	public void shiftEXP5()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JMCC_20());
	}
	/**
	 * @author Ledny Joseph
	 */
	public void shiftEXP6()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JMCC_32());
	}
	/**
	 * @author Jason LoBianco
	 */
	public void shiftEXP7()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JMCC_29());
	}
	/**
	 * @author Jason LoBianco
	 */
	public void shiftId()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JCTM_1());
	}
	/**
	 * @author Jason LoBianco
	 */
	public void shiftIntegerLiteral()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JCTM_18());
	}
	/**
	 * @author TJ Renninger
	 */
	public void shiftTrue()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JCTM_15());
	}
	/**
	 * @author TJ Renninger
	 */
	public void shiftFalse()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JCTM_16());
	}
	/**
	 * @author TJ Renninger
	 */
	public void shiftThis()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JCTM_17());
	}
	/**
	 * @author Chris Kjeldgaard
	 */
	public void shiftNew()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JCTM_19());
	}
	/**
	 * @author Chris Kjeldgaard
	 */
	public void shiftExclamation()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JCTM_27());
	}
	/**
	 * @author Chris Kjeldgaard
	 */
	public void shiftLeftBracket()
	{
		currentParser.pushHoldStack(currentParser.popInputStack());
		currentParser.pushStateStack(this);
		currentParser.changeState(new JCTM_29());
	}
}
