package parser.states.JMCC;
import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * 
 * @author Ian Keefer
 *
 */
public class JMCC_25 extends State 
{
	
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(1, TokenTypes.OP6);
    }

}

