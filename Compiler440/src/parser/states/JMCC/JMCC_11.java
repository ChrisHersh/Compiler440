package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * Reduce to OP4
 * @author Daniel Breitigan
 *
 */
public class JMCC_11 extends State
{
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.OP4);
    }
}
