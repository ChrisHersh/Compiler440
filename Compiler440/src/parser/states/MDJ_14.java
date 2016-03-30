package parser.states;

/**
 * @author Jared Good
 */
public class MDJ_14 extends State 
{
	/**
	 * Changes to state MDJ_15
	 */
	@Override
    public void shiftRightPara() throws ParserException
    {
        changeToState(new MDJ_15());
    }
}
