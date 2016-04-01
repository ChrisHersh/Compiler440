package parser.states;
/**
 * shift on {
 * change to state 27
 * @author Shannon Lee
 *
 */
public class MDJ_25 extends State
{
	@Override
	public void shiftLeftBracket() throws ParserException
	{
		changeToState(new MDJ_27());
	}

	
}
