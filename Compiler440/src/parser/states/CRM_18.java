package parser.states;
/**
 * Implements the methods from state CRM_18
 * @author Jason LoBianco
 */
public class CRM_18 extends State
{
	/**
	 * changes to state CRM_19
	 * @author Jason LoBianco
	 */
	public void shiftMETH_DECL()
	{
		changeToState(new CRM_19());
	}
	
	/**
	 * changes to state CRM_20
	 * @author Jason LoBianco
	 */
	public void shiftPublic()
	{
		changeToState(new CRM_20());
	}
}
