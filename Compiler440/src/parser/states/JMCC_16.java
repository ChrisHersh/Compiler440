package parser.states;

import tokenizer.TokenTypes;

/**
 * 
 * @author Chris Hersh
 *
 */
public class JMCC_16 extends State
{
    @Override
    protected void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.OP3);
    }
}
