package parser.states;

/**
 * @author Jared Good
 */
public class MDJ_14 extends State 
{
	@Override
    public void shiftRightPara() throws ParserException
    {
        changeToState(new MDJ_15());
    }
}
