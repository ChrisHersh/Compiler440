package parser.states;
/**
 * shift if
 * change state to 7
 * @author Shannon Lee
 *
 */
public class CILS_2 extends State
{

	@Override
	public void shiftIf() throws ParserException
	{
		changeToState(new CILS_7());
	}

}
