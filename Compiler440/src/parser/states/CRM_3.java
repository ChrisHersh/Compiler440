package parser.states;

import tokenizer.TokenTypes;

public class CRM_3 extends State
{
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(new CRM_1(), TokenTypes.VAR_DECL_L);
	}
//	public void shiftVAR_DECL()
//	{
//		invalidState();
//	}
}
