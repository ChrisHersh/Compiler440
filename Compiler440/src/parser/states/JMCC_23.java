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
    
    @Override
    public void shiftNew() throws ParserException
    {
        changeToState(new JCTM_19());
    }
    
    @Override
    public void shiftExclamation() throws ParserException
    {
        changeToState(new JCTM_27());
    }
    
    @Override
    public void shiftLeftPara() throws ParserException
    {
        changeToState(new JCTM_29());
    }
}
