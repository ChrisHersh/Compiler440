package parser.states;

/**
 * shift on {
 * @author Shannon Lee
 *
 */
public class MDJ_21 extends State{

	@Override
	public void shiftLeftBracket() throws ParserException
	{
		changeToState(new MDJ_23());
	}
}
