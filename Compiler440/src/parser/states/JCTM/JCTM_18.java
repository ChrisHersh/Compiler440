package parser.states.JCTM;


import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

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
    	reduceNumberOfStates(1, TokenTypes.EXP7);
    }
}
