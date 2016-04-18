package parser.states.JCTM;

import org.junit.Before;

import parser.Parser;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * 
 * @author Matt Mousetis
 * 
 * reduces state back to EXP 7 
 */
public class JCTM_17 extends State 
{
	
    @Override
    public void invalidState() throws ParserException
    {
    	reduceNumberOfStates(1, TokenTypes.EXP7);
    }
}
