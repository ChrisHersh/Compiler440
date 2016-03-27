package parser.states;

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
}
