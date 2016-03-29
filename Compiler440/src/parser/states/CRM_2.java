package parser.states;

public class CRM_2 extends State
{
	public void shiftVAR_DECL() throws ParserException
	{
		changeToState(new CRM_3());
	}
}
