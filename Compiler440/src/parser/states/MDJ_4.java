package parser.states;

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
		protected void invalidState() throws ParserException
		{
			reduceToState(new MDJ_3(), TokenTypes.CLASS_DECL);
		}
	}


