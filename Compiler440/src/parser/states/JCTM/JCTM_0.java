package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_32;

/**
 * 
 * @author Matt Mousetis
 *
 */

public class JCTM_0 extends State 
{
	/**
	 * Shift on exp7
	 */
	@Override
	public void shiftEXP7() throws ParserException 
	{
		changeToState(new JMCC_32());
	}
	
	/**
	 * Shift on this
	 */
	@Override
	public void shiftThis() throws ParserException 
	{
		changeToState(new JCTM_17());
	}
	/**
	 * Shift on left Para
	 */
	@Override
	public void shiftLeftPara() throws ParserException 
	{
		changeToState(new JCTM_29());
	}
	
	/**
	 * Shift on id
	 */
	@Override
	public void shiftId() throws ParserException 
	{
		changeToState(new JCTM_1());
	}
	
	/**
	 * Shift on false
	 */
	@Override
	public void shiftFalse() throws ParserException 
	{
		changeToState(new JCTM_16());
	}
	
	/**
	 * Shift on !
	 */
	@Override
	public void shiftNot() throws ParserException
	{
		changeToState(new JCTM_27());
	}
	
	/**
	 * Shift on intLiteral
	 */
	@Override
	public void shiftIntegerLiteral() throws ParserException 
	{
		changeToState(new JCTM_18());
	}
	
	/**
	 * Shift on new
	 */
	@Override
	public void shiftNew() throws ParserException 
	{
		changeToState(new JCTM_19());
	}
	
	/**
	 * Shift on true
	 */
	@Override
	public void shiftTrue() throws ParserException 
	{
		changeToState(new JCTM_15());
	}
}
