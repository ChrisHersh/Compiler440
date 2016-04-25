package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * JMCC_13
 * Reduce to OP4
 * @author Daniel Breitigan
 *
 */
public class JMCC_13 extends State
{
    //Reduce to OP4
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.OP4);
    }
}
