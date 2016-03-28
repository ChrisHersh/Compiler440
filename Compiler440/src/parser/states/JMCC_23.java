package parser.states;

import parser.states.JCTM_1;
import jdk.nashorn.internal.runtime.ParserException;

public class JMCC_23 extends State
{
    @Override
    public void shiftEXP6() throws ParserException
    {
        changeToState(new JMCC_24());
    }
    
    @Override
    public void shiftEXP7() throws ParserException
    {
        changeToState(new JMCC_29());
    }
    
    public void shiftid() throws ParserException
    {
        changeToState(new JCTM_1());
    }
    
    public void shiftTHIS() throws ParserException
    {
        changeToState(new JCTM_17());
    }
}
