package parser.states;
/**
 * Implements the methods from state CRM_21
 * @author TJ Renninger
 */
public class CRM_21 extends State
{
	/**
	 * changes to state CRM_22
	 * @author TJ Renninger
	 */
	@Override
	public void shiftId() throws ParserException
	{
		changeToState(new CRM_22());
	}
}
