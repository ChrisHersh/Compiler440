package parser.states;
/**
 * shift on METH_DECL_L
 * change to state 23
 * @author Shannon Lee
 *
 */
public class MDJ_25 extends State
{
	@Override
	public void shiftMETH_DECL_L() throws ParserException
	{
		changeToState(new MDJ_27());
	}

	
}
