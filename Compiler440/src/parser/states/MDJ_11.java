package parser.states;

/*
 * @author Jared Good
 */
public class MDJ_11 extends State 
{
	@Override
    public void shiftVoid() throws ParserException
    {
        changeToState(new MDJ_12());
    }
}
