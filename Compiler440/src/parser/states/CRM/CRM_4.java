package parser.states.CRM;

import parser.states.ParserException;
import parser.states.State;
import parser.states.CILS.CILS_10;
import parser.states.CILS.CILS_3;
import parser.states.CILS.CILS_6;
import parser.states.CILS.CILS_7;
import parser.states.CILS.CILS_8;
import parser.states.CILS.CILS_9;
/**
 * Implements the methods from state CRM_4
 * @author TJ Renninger, Jason LoBianco
 */
public class CRM_4 extends State
{
	/**
	 * Changes the state to CRM_5
	 * @author TJ Renninger
	 */
	public void shiftRightBrace() throws ParserException
	{
		changeToState(new CRM_5());
	}
	
	/**
	 * Changes the state to CILS_3
	 * @author Jason LoBianco
	 */
	public void shiftSTMT()
	{
		changeToState(new CILS_3());
	}
	
	/**
	 * Changes the state to CILS_7
	 * @author Jason LoBianco
	 */
	public void shiftIf()
	{
		changeToState(new CILS_7());
	}
	
	/**
	 * Changes the state to CILS_6
	 * @author Jason LoBianco
	 */
	public void shiftLeftBrace()
	{
		changeToState(new CILS_6());
	}
	
	/**
	 * Changes the state to CILS_10
	 * @author Jason LoBianco
	 */
	public void shiftWhile()
	{
		changeToState(new CILS_10());
	}
	
	/**
	 * Changes the state to CILS_8
	 * @author Jason LoBianco
	 */
	public void shiftSystemOutPrintln()
	{
		changeToState(new CILS_8());
	}
	
	/**
	 * Changes the state to CILS_9
	 * @author Jason LoBianco
	 */
	public void shiftId()
	{
		changeToState(new CILS_9());
	}
}