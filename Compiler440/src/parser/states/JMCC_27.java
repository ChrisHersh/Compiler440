package parser.states;

/**
 * 
 * @author Ian Keefer, Chris Hersh, Daniel Breitigan, Matt Mousetis
 *
 */
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
    
    @Override
	public void shiftTrue() throws ParserException
	{
	    changeToState(new JCTM_15());
	}
    
    @Override
	public void shiftFalse() throws ParserException
	{
	    changeToState(new JCTM_16());
	}

    @Override
	public void shiftThis()throws ParserException
	{
	    changeToState(new JCTM_17());
	}
	
    @Override
	public void shiftId() throws ParserException
	{
	    changeToState(new JCTM_1());
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
