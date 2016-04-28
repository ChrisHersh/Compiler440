package intermediate.process;

import tokenizer.Token;

/**
 * Process the OP1 rules.
 * @author Chad Nunemaker
 */
public class ProcessOP1
{
	/**
	 * Pass 1 passes parent class and method info to children nodes and then traverses them.
	 * @param subject the token to process
	 */
	public static void processPass1(Token subject)
	{
		// Do nothing, nothing to check.
	}

	/**
	 * Pass 2 checks that all types are valid.
	 * @param subject the token to process
	 */
	public static void processPass2(Token subject)
	{
		// Do nothing, nothing to check.
	}

	/**
	 * Pass 3 creates intermediate code.
	 * @param subject the token to process
	 */
	public static void processPass3(Token subject)
	{
		subject.getCode().append(" || ");
	}
}
