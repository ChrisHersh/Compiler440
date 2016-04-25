package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * JCTM_6 State
 * @author Daniel Breitigan
 *
 */
public class JCTM_6 extends State
{
    //Reduce state to EXP7
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(3, TokenTypes.EXP7);
    }
}
