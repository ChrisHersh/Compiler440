package intermediate.process;

import tokenizer.Token;

/**
 * Processing class for OP3 token
 * Handles DFS passes 1-3
 * @author Corey Peregord
 */
public class ProcessOP3 
{
	/**
	 * Does nothing, OP3 has no children
	 * @author Corey Peregord
	 */
	public static void processPass1(Token subject) 
	{
		//Do nothing, I have no children
	}

	/**
	 * Does nothing, OP3 has no children
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
        subject.setCode(new StringBuffer("OP3.getOperater()"));
	}
}
