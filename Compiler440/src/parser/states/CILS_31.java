package parser.states;

/**
 *This class is CILS_31 which represents this: STMT -> While ( EXP1 ) STMT
 * 
 * @author Mohammed
 */
public class CILS_31 extends State 
{
	/**
	 * If the input is STMT, this shifts to CILS_30
	 */
	@Override
	public void shiftSTMT()
	{
		changeToState(new CILS_32());
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
	 * If the input is SYSO, this shifts to CILS_8 
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
