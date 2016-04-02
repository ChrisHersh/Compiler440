package parser.states;
/**
 * 
 * @author Jessica Schlesiger
 * MDJ_3 state. Ensure this state can properly shift to MDJ_17 on "class" token
 */
public class MDJ_3 extends State
{
	/**
	 * Changes to state MDJ_17 on "class" token
	 */
	@Override
	public void shiftClass() throws ParserException
	{
		changeToState(new MDJ_17());
	}
}