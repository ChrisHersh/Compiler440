package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;

public class JMCC_1 extends State {

    @Override
    public void shiftOP1() throws ParserException
    {
        changeToState(new JMCC_3());
    }
    
    @Override
    public void shiftOr() throws ParserException
    {
        changeToState(new JMCC_2());
    }
}
