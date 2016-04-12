package parser.states;

/**
 * 
 * @author Matt Mousetis
 * 
 * reduces state back to EXP 7 
 */
public class JCTM_15 extends State 
{
    @Override
    protected void invalidState() throws ParserException
    {
        reduceToState(new JCTM_0(), TokenTypes.EXP7);
    }
}
