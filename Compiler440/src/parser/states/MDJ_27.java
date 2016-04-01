package parser.states;
/**
 * shift on }
 * change to state 29
 * @author Shannon Lee
 *
 */
public class MDJ_27 extends State
{
	@Override
	public void shiftRightBracket() throws ParserException
	{
		changeToState(new MDJ_28());
	}
}
