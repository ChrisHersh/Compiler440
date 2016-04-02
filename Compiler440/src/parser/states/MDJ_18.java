package parser.states;
/**
 * 
 * @author Jessica Schlesiger
 * MDJ_18 state. Ensure this state can properly shift to MDJ_20 on "{" token
 */
public class MDJ_18 extends State
{
	/**
	 * Changes to state MDJ_20 on "{" token
	 */
	@Override
	public void shiftLeftBrace() throws ParserException
	{
		changeToState(new MDJ_20());
	}
}