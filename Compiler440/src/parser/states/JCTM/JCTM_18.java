package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;

/**
 * 
 * @author Matt Mousetis
 * 
 * reduces state back to EXP 7 
 */
public class JCTM_18 extends State 
{
    @Override
    public void invalidState() throws ParserException
    {
        reduceToState(new JCTM_0(), TokenTypes.EXP7);
    }
}
