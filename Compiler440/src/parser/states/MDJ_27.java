package parser.states;
/**
 * shift on VAR_DECL_L
 * change to state 29
 * @author Shannon Lee
 *
 */
public class MDJ_27 extends State
{
	@Override
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new MDJ_29());
	}
}
