package parser.states;

/**
 * shift ) 
 * change to state 23
 * @author Shannon Lee
 *
 */
public class CILS_16 extends State
{

	@Override
	public void shiftRightBrace() throws ParserException
	{
		changeToState(new CILS_23());
	}
}
