package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;


/**
 * JMCC_28
 * Reduce to EXP6
 * @author Daniel Breitigan, Ian Keefer
 *
 */
public class JMCC_28 extends State
{
    //Reduce to EXP6
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(3, TokenTypes.EXP6);
    }
}
