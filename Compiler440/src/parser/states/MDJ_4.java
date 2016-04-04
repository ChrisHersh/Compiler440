package parser.states;

/*
 * reduce to state MDJ_1
 * Auther Mohammed 
 */
public class MDJ_4 extends State{

		/**
		 * Because we do not have more inputs we do reduce to MDJ_1
		 */
		@Override
		protected void invalidState() throws ParserException
		{
			reduceToState(new MDJ_1(), TokenTypes.CLASS_DECL);
		}
	}


