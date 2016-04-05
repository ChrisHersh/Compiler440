package parser.states;

/**
 * shift (
 * change to state 12
 * @author Shannon Lee
 *
 */
public class CILS_7 extends State
{

	@Override
	public void shiftLeftBrace() throws ParserException
	{
		changeToState(new CILS_12());
	}
}
