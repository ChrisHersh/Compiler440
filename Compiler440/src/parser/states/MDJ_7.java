package parser.states;

/**
 * @author Jared Good
 */
public class MDJ_7 extends State
{
	/**
	 * Changes to state MDJ_10
	 */
	@Override
    public void shiftPublic() throws ParserException
    {
        changeToState(new MDJ_10());
    }
}
