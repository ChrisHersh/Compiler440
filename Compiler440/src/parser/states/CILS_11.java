package parser.states;
/*
 * @author Mohammed
 */
public class CILS_11 extends State {

	/**
	 * If the input is EXP1, this shifts to CILS_15
	 */
	@Override
	public void shiftEXP1()
	{
		changeToState(new CILS_15());
	}
	
	
}
