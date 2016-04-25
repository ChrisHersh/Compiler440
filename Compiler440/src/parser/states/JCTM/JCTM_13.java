package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_1;
import parser.states.JMCC.JMCC_15;
import parser.states.JMCC.JMCC_20;
import parser.states.JMCC.JMCC_32;
import parser.states.JMCC.JMCC_8;
import parser.states.JMCC.JMCC_9;

/**
 * @author Matt Mousetis
 */

public class JCTM_13 extends State
{
	/**
	 * Shift on EXP1
	 */
	@Override
	public void shiftEXP1() throws ParserException {
		changeToState(new JCTM_14());
	}
	
	/**
	 * Shift on EXP2
	 */
	@Override
	public void shiftEXP2() throws ParserException {
		changeToState(new JMCC_9());
	}
	
	/**
	 * Shift on EXP3
	 */
	@Override
	public void shiftEXP3() throws ParserException {
		changeToState(new JMCC_15());
	}
	
	/**
	 * Shift on EXP4
	 */
	@Override
	public void shiftEXP4() throws ParserException {
		changeToState(new JMCC_8());
	}
	
	/**
	 * Shift on EXP5
	 */
	@Override
	public void shiftEXP5() throws ParserException {
		changeToState(new JMCC_20());
	}
	
	/**
	 * Shift on EXP6
	 */
	@Override
	public void shiftEXP6() throws ParserException {
		changeToState(new JMCC_32());
	}
	
	/**
	 * Shift on EXP7
	 */
	@Override
	public void shiftEXP7() throws ParserException {
		changeToState(new JMCC_32());
	}
	
	/**
	 * Shift on id
	 */
	@Override
	public void shiftId() throws ParserException {
		changeToState(new JCTM_1());
	}
	
	/**
	 * Shift on false
	 */
	@Override
	public void shiftFalse() throws ParserException {
		changeToState(new JCTM_16());
	}
	
	/**
	 * Shift on true
	 */
	@Override
	public void shiftTrue() throws ParserException {
		changeToState(new JCTM_15());
	}
	
	/**
	 * Shift on integer literal
	 */
	@Override
	public void shiftIntegerLiteral() throws ParserException {
		changeToState(new JCTM_18());
	}
	
	/**
	 * Shift on !
	 */
	@Override
	public void shiftNot() throws ParserException {
		changeToState(new JCTM_27());
	}
	
	/**
	 * Shift on New
	 */
	@Override
	public void shiftNew() throws ParserException {
		changeToState(new JCTM_19());
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
	 * Shift on this
	 */
	@Override
	public void shiftThis() throws ParserException 
	{
		changeToState(new JCTM_17());
	}
}
