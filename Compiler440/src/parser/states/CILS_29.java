package parser.states;

/**
 *This class is CILS_29 which represents this: STMT -> if ( EXP1 ) STMT else • STMT
 * 
 * @author Raistlin Hess
 */
public class CILS_29 extends State 
{
	/**
	 * If the input is STMT, this shifts to CILS_30
	 */
	@Override
	public void shiftSTMT()
	{
		changeToState(new CILS_30());
	}
	
	/**
	 * If the input is if, this shifts to CILS_7
	 */
	@Override
	public void shiftIf()
	{
		changeToState(new CILS_7());
	}
	
	/**
	 * If the input is {, this shifts to CILS_6 
	 */
	@Override
	public void shiftLeftBrace()
	{
		changeToState(new CILS_6());
	}
	
	/**
	 * If the input is while, this shifts to CILS_10 
	 */
	@Override
	public void shiftWhile()
	{
		changeToState(new CILS_10());
	}
	
	/**
	 * If the input is SOP, this shifts to CILS_8 
	 */
	@Override
	public void shiftSystemOutPrintln()
	{
		changeToState(new CILS_8());
	}
	
	/**
	 * If the input is id, this shifts to CILS_9
	 */
	@Override
	public void shiftId()
	{
		changeToState(new CILS_9());
	}
}
