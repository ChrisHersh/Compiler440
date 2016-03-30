package parser.states;

/*
 * @author Jared Good
 */
public class MDJ_10 extends State 
{
	@Override
    public void shiftStatic() throws ParserException
    {
        changeToState(new MDJ_11());
    }
}
