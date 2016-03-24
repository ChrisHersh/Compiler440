package parser.states;

/**
 * 
 * @author Ian Keefer
 */
public class JCTM_27 extends State {
	
	public void shiftTrue()
	{
	    changeToState(new JCTM_15());
	}

	public void shiftFalse()
	{
	    changeToState(new JCTM_16());
	}

	public void shiftThis()
	{
	    changeToState(new JCTM_17());
	}
	
	public void shiftId()
	{
	    changeToState(new JCTM_1());
	}

}
