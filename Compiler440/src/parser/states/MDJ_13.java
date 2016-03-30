package parser.states;

/**
 * @author Jared Good
 */
public class MDJ_13 extends State 
{
	/**
	 * Changes to state MDJ_14
	 */
	@Override
    public void shiftLeftPara() throws ParserException
    {
        changeToState(new MDJ_14());
    }
}