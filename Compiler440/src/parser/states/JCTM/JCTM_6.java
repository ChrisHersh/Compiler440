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
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(3, TokenTypes.EXP7);
    }
}
