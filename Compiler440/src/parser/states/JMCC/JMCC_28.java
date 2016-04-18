package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;


/**
 * Reduce to EXP6
 * @author Daniel Breitigan
 *
 */
public class JMCC_28 extends State
{
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(3, TokenTypes.EXP6);
    }
}
