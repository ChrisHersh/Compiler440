package parser.states;

/**
 * @author Chris Hersh
 *
 */
public class JMCC_15 extends State
{
    @Override
    public void shiftOP3() throws ParserException
    {
        changeToState(new JMCC_30());
    }
    
    @Override
    public void shiftNotEquals() throws ParserException
    {
        changeToState(new JMCC_17());
    }
    
    @Override
    public void shiftEquals() throws ParserException
    {
        changeToState(new JMCC_16());
    }
}
