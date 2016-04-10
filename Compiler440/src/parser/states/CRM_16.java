package parser.states;
/**
 * Implements the methods from state CRM_16
 * @author Jason LoBianco
 */
public class CRM_16 extends State
{
	/**
	 * changes to state CRM_18
	 * @author Jason LoBianco
	 */
	public void shiftMETH_DECL_L()
	{
		changeToState(new CRM_18());
	}
}
