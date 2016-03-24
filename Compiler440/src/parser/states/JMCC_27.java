package parser.states;

public class JMCC_27 extends State
{
    @Override
    public void shiftEXP7() throws ParserException
    {
        changeToState(new JMCC_28());
    }
    
    @Override
    public void shiftIntegerLiteral() throws ParserException
    {
        changeToState(new JCTM_18());
    }
}
