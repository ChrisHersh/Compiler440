package parser.states;
/**
 * shift on }
 * change to state 32 reduce state
 * @author Shannon Lee
 *
 */

public class MDJ_31 extends State{

	@Override
	public void shiftRightBracket() throws ParserException
	{
		changeToState(new MDJ_32() );
	}
}
