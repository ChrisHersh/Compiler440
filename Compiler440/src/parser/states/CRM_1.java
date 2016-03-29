package parser.states;

public class CRM_1 extends State
{
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new CRM_2());
	}
}
