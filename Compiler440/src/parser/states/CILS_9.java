package parser.states;

/**
 *This class is CILS_9 which represents this: STMT -> id • = EXP1;
 * 											  STMT -> id • [ EXP1] = EXP1;
 * 
 * @author Raistlin Hess
 */
public class CILS_9 extends State 
{
	/**
	 * If the input is =, this shifts to CILS_14
	 */
	@Override
	public void shiftEquals()
	{
		changeToState(new CILS_14());
	}
	
	/**
	 * If the input is [, this shifts to CILS_15
	 */
	@Override
	public void shiftLeftBrace()
	{
		changeToState(new CILS_15());
	}
}
