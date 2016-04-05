package parser.states;

/**
 * shift EXP1
 * change to state 16
 * @author Shannon Lee
 *
 */
public class CILS_12 extends State
{

	@Override
	public void shiftEXP1() throws ParserException
	{
		changeToState(new CILS_16());
	}
}
