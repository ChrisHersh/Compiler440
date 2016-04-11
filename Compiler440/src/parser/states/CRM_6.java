package parser.states;
/**
 * Implements the methods from state CRM_6
 * @author Jason LoBianco
 */
public class CRM_6 extends State 
{
	/**
	 * changes the state to CRM_7
	 * @author Jason LoBianco
	 */
	public void shiftId() throws ParserException
	{
		changeToState(new CRM_7());
	}
}
