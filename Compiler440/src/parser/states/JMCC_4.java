package parser.states;

/**
 * 
 * @author Chris Hersh
 *
 */
public class JMCC_4 extends State
{
    @Override
    public void shiftAnd() throws ParserException
    {
        changeToState(new JMCC_10());
    }
    
    @Override
    public void shiftOP2() throws ParserException
    {
        changeToState(new JMCC_5());
    }
}
