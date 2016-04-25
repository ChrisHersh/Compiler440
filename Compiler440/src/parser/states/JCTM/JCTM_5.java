package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * JCTM_5 State
 * @author Daniel Breitigan
 *
 */
public class JCTM_5 extends State
{
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(4, TokenTypes.EXP7);
    }
}
