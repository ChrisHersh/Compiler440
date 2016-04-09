package parser.states;

public class MDJ_25 extends State
{
	/**
	 * Method used to shift on  METH_DECL_L and change to state 27
	 * @author Shannon Jones
	 */
	@Override
	public void shiftMETH_DECL_L() throws ParserException
	{
		changeToState(new MDJ_27());
	}

	
}
