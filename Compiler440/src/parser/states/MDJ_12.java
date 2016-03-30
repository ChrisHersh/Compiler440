package parser.states;

/**
 * @author Jared Good
 */
public class MDJ_12 extends State 
{
	@Override
    public void shiftMain() throws ParserException
    {
        changeToState(new MDJ_13());
    }
}