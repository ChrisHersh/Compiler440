package parser.states.JMCC;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;
/**
 * JMCC_29
 * Reduce to EXP6
 * @author Daniel Breitigan
 *
 */
public class JMCC_29 extends State 
{
    //Reduce to EXP6
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.EXP6);
    }
}
