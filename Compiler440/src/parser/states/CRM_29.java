package parser.states;
/**
 * Implements the methods from state CRM_29
 * @author TJ Renninger
 */
public class CRM_29 extends State
{
	/**
	 * changes to state CRM_12
	 * @author TJ Renninger
	 */
	@Override
	public void shiftId() throws ParserException
	{
		changeToState(new CRM_12());
	}

	/**
	 * changes to state CRM_9
	 * @author TJ Renninger
	 */
	@Override
	public void shiftInt() throws ParserException
	{
		changeToState(new CRM_9());
	}

	/**
	 * changes to state CRM_13
	 * @author TJ Renninger
	 */
	@Override
	public void shiftBoolean() throws ParserException
	{
		changeToState(new CRM_13());
	}

	/**
	 * changes to state CRM_6
	 * @author TJ Renninger
	 */
	@Override
	public void shiftTYPE() throws ParserException
	{
		changeToState(new CRM_6());
	}

	/**
	 * changes to state CRM_3
	 * @author TJ Renninger
	 */
	@Override
	public void shiftVAR_DECL() throws ParserException
	{
		changeToState(new CRM_3());
	}

	/**
	 * changes to state CRM_30
	 * @author TJ Renninger
	 */
	@Override
	public void shiftSTMT_P() throws ParserException
	{
		changeToState(new CRM_30());
	}
}
