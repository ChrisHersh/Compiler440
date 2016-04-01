package parser.states;
/**
 * shift on VAR_DECL_L
 * @author Shannon Lee
 *
 */
public class MDJ_23 extends State
{
	
	@Override
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new MDJ_25());
	}

}
