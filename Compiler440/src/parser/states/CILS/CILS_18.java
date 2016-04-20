package parser.states.CILS;

import parser.states.ParserException;
import parser.states.State;
import parser.states.JMCC.JMCC_2;
import parser.states.JMCC.JMCC_31;

/**
 * @author Manal Ibrahim
 * this CILS_18 class is reponsabile for transaction:
 * STMT -> id = EXP1�;
 * EXP1 -> EXP1 �op1 EXP2
 * op1 -> ||
 */
public class CILS_18 extends State {
	
	/**
	 * @auther Manal Ibrahim
	 * Changes state to CILS_21
	 * STMT -> id = EXP1�; 
	 */
	@Override
	public void shiftSemiColon() throws ParserException	
	{
		changeToState(new CILS_21());
	}
	

	
}
