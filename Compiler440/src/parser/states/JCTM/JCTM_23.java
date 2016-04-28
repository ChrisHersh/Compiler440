package parser.states.JCTM;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/**
 * JCTM_23 State
 * @author Ian Keefer
 *
 */
public class JCTM_23 extends State {
	
	// Reduce state to EXP7
    @Override
    public void invalidState() throws ParserException
    {
        reduceNumberOfStates(5, TokenTypes.EXP7);
    }

}
