package parser.states;

/**
 * This state is: EXP4 -> EXP4 op4 ⚫ EXP5
 * 
 */
public class JMCC_7 extends State
{
	@Override
	public void shiftThis()
	{
		JCTM_17 st = new JCTM_17();
		changeToState(st);
	}
	
	@Override
	public void shiftLeftPara()
	{
		JCTM_29 st = new JCTM_29();
		changeToState(st);
	}
	
	@Override
	public void shiftEXP5()
	{
		JMCC_33 st = new JMCC_33();
		changeToState(st);
	}
}
