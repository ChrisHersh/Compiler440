package parser.states;
/**
 * shift on METH_DECL_L
 * change to State 31
 * @author Shannon Lee
 *
 */
public class MDJ_29 extends State
{
	@Override
	public void shiftMETH_DECL_L() throws ParserException
	{
		changeToState(new MDJ_31());
	}

}
