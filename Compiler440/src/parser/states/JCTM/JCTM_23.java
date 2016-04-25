package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * 
 * @author Ian Keefer
 *
 */
public class JCTM_23 extends State {
	
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(4, TokenTypes.RBracket);
    }

}
