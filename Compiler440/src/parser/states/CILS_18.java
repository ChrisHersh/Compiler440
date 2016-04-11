package parser.states;
/**
 * @author Manal Ibrahim
 * this CILS_18 class is reponsabile for transaction:
 * STMT -> id = EXP1•;
 * EXP1 -> EXP1 •op1 EXP2
 * op1 -> ||
 */
public class CILS_18 extends State {
	
	/**
	 * @auther Manal Ibrahim
	 * Changes state to CILS_21
	 * STMT -> id = EXP1•; 
	 */
	@Override
	public void shiftSemiColon() throws ParserException	
	{
		changeToState(new CILS_21());
	}
	
	/**
	 * @auther Manal Ibrahim
	 * Changes state to JMCC_2
	 * EXP1 -> EXP1 •op1 EXP2 
	 * op1 -> ||
	 */
	@Override
	public void shiftOP1() throws ParserException	
	{
		changeToState(new JMCC_2());
	}
	
}
