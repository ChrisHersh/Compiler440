package parser.states;

/**
 * This class is MDJ_22 which represents this: CLASS_DECL -> class id { VAR_DECL_L • METH_DECL_L }
 * 
 * @author Raistlin Hess
 */
public class MDJ_22 extends State
{
	/**
	 * If the input is METH_DECL_L, this shifts to MDJ_24
	 */
	@Override
	public void shiftMETH_DECL_L()
	{
		changeToState(new MDJ_24());
	}
	
	/**
	 * If the input is VAR_DECL, this shifts to CRM_3
	 */
	@Override
	public void shiftVAR_DECL()
	{
		changeToState(new CRM_3());
	}
	
	/**
	 * If the input is TYPE, this shifts to CRM_6 
	 */
	@Override
	public void shiftTYPE()
	{
		changeToState(new CRM_6());
	}
	
	/**
	 * If the input is int, this shifts to CRM_9 
	 */
	@Override
	public void shiftInt()
	{
		changeToState(new CRM_9());
	}
	
	/**
	 * If the input is boolean, this shifts to CRM_13
	 */
	@Override
	public void shiftBoolean()
	{
		changeToState(new CRM_13());
	}
	
	/**
	 * If the input is id, this shifts to CRM_12
	 */
	@Override
	public void shiftId()
	{
		changeToState(new CRM_12());
	}
	
	/**
	 * If the input is anything else, treat it as epsilon here and shift to CRM_33
	 */
	@Override
	public void invalidState()
	{
		changeToState(new CRM_33());
	}
}
