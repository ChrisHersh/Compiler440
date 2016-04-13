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
	@Override
	public void shiftEXP7() throws ParserException 
	{
		changeToState(new JMCC_32());
	}
	
	@Override
	public void shiftThis() throws ParserException 
	{
		changeToState(new JCTM_17());
	}
	
	@Override
	public void shiftLeftBrace() throws ParserException 
	{
		changeToState(new JCTM_29());
	}
	
	@Override
	public void shiftId() throws ParserException 
	{
		changeToState(new JCTM_1());
	}
	
	@Override
	public void shiftFalse() throws ParserException 
	{
		changeToState(new JCTM_16());
	}
	
	@Override
	public void shiftNot() throws ParserException
	{
		changeToState(new JCTM_27());
	}
	
	@Override
	public void shiftIntegerLiteral() throws ParserException 
	{
		changeToState(new JCTM_18());
	}
	
	@Override
	public void shiftNew() throws ParserException 
	{
		changeToState(new JCTM_19());
	}
	
	@Override
	public void shiftTrue() throws ParserException 
	{
		changeToState(new JCTM_15());
	}
}
