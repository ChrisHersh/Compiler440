package parser.states;

/*
 * @author Jared Good
 */
public class MDJ_13 extends State 
{
	@Override
    public void shiftLeftPara() throws ParserException
    {
        changeToState(new MDJ_14());
    }
}