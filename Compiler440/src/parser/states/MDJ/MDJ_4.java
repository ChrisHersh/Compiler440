package parser.states.MDJ;

import parser.states.ParserException;
import parser.states.State;
import tokenizer.TokenTypes;

/*
 * reduce to state MDJ_3
 * Auther Mohammed 
 */
public class MDJ_4 extends State{

		/**
		 * Because we do not have more inputs we do reduce to MDJ_3
		 */
		@Override
		public void invalidState() throws ParserException
		{
			reduceNumberOfStates(3, TokenTypes.CLASS_DECL);
		}
	}


