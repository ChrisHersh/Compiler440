package parser.states;

/**
 * 
 * @author Chris Hersh
 *
 */
public class JMCC_9 extends State {

    @Override
    public void shiftOP2() throws ParserException
    {
        changeToState(new JMCC_5());
    }
    
    @Override
    public void shiftAnd() throws ParserException
    {
        changeToState(new JMCC_10());
    }
}
