package parser.states;
/**
 * Implements the methods from state CRM_23
 * @author TJ Renninger
 */
public class CRM_23 extends State
{
	/**
	 * changes to state CRM_
	 * @author TJ Renninger
	 */
	@Override
	public void shiftInt() throws ParserException
	{
		changeToState(new CRM_9());
	}

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
	 * changes to state CRM_13
	 * @author TJ Renninger
	 */
	@Override
	public void shiftBoolean() throws ParserException
	{
		changeToState(new CRM_13());
	}

	/**
	 * changes to state CRM_25
	 * @author TJ Renninger
	 */
	@Override
	public void shiftFORMAL_L() throws ParserException
	{
		changeToState(new CRM_25());
	}

	/**
	 * changes to state CRM_35
	 * @author TJ Renninger
	 */
	@Override
	public void shiftTYPE() throws ParserException
	{
		changeToState(new CRM_35());
	}
}
