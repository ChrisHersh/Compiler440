package parser.states;
/**
 * Implements the methods from state CRM_30
 * @author TJ Renninger
 */
public class CRM_30 extends State
{
	/**
	 * changes to state CRM_3
	 * @author TJ Renninger
	 */
	@Override
	public void shiftSTMT() throws ParserException
	{
		changeToState(new CRM_3());
	}

	/**
	 * changes to state CRM_7
	 * @author TJ Renninger
	 */
	@Override
	public void shiftIf() throws ParserException
	{
		changeToState(new CRM_7());
	}

	/**
	 * changes to state CRM_6
	 * @author TJ Renninger
	 */
	@Override
	public void shiftLeftBrace() throws ParserException
	{
		changeToState(new CRM_6());
	}

	/**
	 * changes to state CRM_10
	 * @author TJ Renninger
	 */
	@Override
	public void shiftWhile() throws ParserException
	{
		changeToState(new CRM_10());
	}

	/**
	 * changes to state CRM_8
	 * @author TJ Renninger
	 */
	@Override
	public void shiftSystemOutPrintln() throws ParserException
	{
		changeToState(new CRM_8());
	}

	/**
	 * changes to state CRM_9
	 * @author TJ Renninger
	 */
	@Override
	public void shiftId() throws ParserException
	{
		changeToState(new CRM_9());
	}
}
