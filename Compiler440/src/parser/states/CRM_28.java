package parser.states;
/**
 * Implements the methods from state CRM_28
 * @author TJ Renninger
 */
public class CRM_28 extends State
{
	/**
	 * changes to state CRM_29
	 * @author TJ Renninger
	 */
	@Override
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new CRM_29());
	}
}
