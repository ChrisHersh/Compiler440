package parser.states;
/**
 * @author Chris Kjeldgaard, Jason LoBianco
 */
import tokenizer.TokenTypes;

public class CRM_1 extends State
{
	/**
	 * Changes to state CRM_2
	 * @author Chris Kjeldgaard
	 */
	public void shiftVAR_DECL_L() throws ParserException
	{
		changeToState(new CRM_2());
	}
	
	/**
	 * reduces to the current state and generates the token VAR_DECL_L
	 * @author Jason LoBianco
	 */
	@Override
	protected void invalidState() throws ParserException
	{
		reduceToState(this, TokenTypes.VAR_DECL_L);
	}
}
