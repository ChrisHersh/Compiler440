package parser.states;
/**
 * 
 * @author Jason LoBianco
 *
 */
public class CRM_15 extends State
{
	/**
	 * Changes to state CRM_16
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	public void shiftVAR_DECL() throws ParserException
	{
		changeToState(new CRM_16());
	}

	/**
	 * Changes to state CRM_6
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	public void shiftTYPE() throws ParserException
	{
		changeToState(new CRM_6());
	}
	
	/**
	 * Changes to state CRM_9
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	public void shiftInt() throws ParserException
	{
		changeToState(new CRM_9());
	}
	
	/**
	 * Changes to state CRM_12
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	public void shiftId() throws ParserException
	{
		changeToState(new CRM_12());
	}
	
	/**
	 * Changes to state CRM_13
	 * @author Jason LoBianco
	 * @throws ParserException
	 */
	public void shiftBoolean() throws ParserException
	{
		changeToState(new CRM_13());
	}
}
