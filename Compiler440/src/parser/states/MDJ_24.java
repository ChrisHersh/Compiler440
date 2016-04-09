package parser.states;

/**
 * This class is MDJ_24 which represents this: CLASS_DECL -> class id { VAR_DECL_L METH_DECL_L • }
 * 
 * @author Raistlin Hess
 */
public class MDJ_24 extends State
{
	/**
	 * If the input is }, this shifts to MDJ_26
	 */
	@Override
	public void shiftRightBrace()
	{
		changeToState(new MDJ_26());
	}
	
	/**
	 * If the input is METH_DECL, this shifts to CRM_35
	 */
	@Override
	public void shiftMETH_DECL()
	{
		changeToState(new CRM_35());
	}
	
	/**
	 * If the input is public, this shifts to CRM_36 
	 */
	@Override
	public void shiftPublic()
	{
		changeToState(new CRM_36());
	}
}
