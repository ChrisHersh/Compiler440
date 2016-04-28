package intermediate.process;

import tokenizer.Token;

/**
 * Processing class for OP4 token
 * Handles DFS passes 1-3
 * @author Corey Peregord
 */
public class ProcessOP4 
{
	/**
	 * Does nothing, OP4 has no children
	 * @author Corey Peregord
	 */
	public static void processPass1(Token subject) 
	{
		//Do nothing, I have no children
	}

	/**
	 * Does nothing, OP4 has no children
	 * @author Corey Peregord
	 */
	public static void processPass2(Token subject)
	{
		//Do nothing, I have nothing to check
	}

	/**
	 * Generates node level intermediate code
	 * @param subject token currently processing
	 * @author Corey Peregord
	 */
	public static void processPass3(Token subject)
	{
		subject.setCode(new StringBuffer("OP4.getOperater()"));
	}
}
