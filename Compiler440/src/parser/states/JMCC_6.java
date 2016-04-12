package parser.states;

import tokenizer.TokenTypes;

/**
 * 
 * @author Chris Hersh
 *
 */
public class JMCC_6 extends State {

    @Override
    protected void invalidState() throws ParserException
    {
        reduceToState(new JMCC_3(), TokenTypes.EXP2);
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
    
    @Override
    public void shiftOP3() throws ParserException
    {
        changeToState(new JMCC_30());
    }
}
