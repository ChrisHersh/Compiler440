package parser.states;
/**
 * Implements the methods from state CRM_10
 * @author Jason LoBianco
 */
public class CRM_10 extends State 
{
	/**
	 * changes to state CRM_11
	 * @author Jason LoBianco
	 */
	public void shiftRightBracket() throws ParserException
	{
		changeToState(new CRM_11());
	}
}
