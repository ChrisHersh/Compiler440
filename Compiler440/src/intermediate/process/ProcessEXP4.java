package intermediate.process;

import tokenizer.Token;

/**
 * Processing class for EXP4 token
 * Handles DFS passes 1-3
 * @author Corey Peregord
 */
public class ProcessEXP4 
{

	/**
	 * Cycles through each child, setting class and parent
	 * Visits child
	 * Gets type from child if needed
	 * @author Corey Peregord
	 */
	public static void processPass1(Token subject) 
	{
		if(subject.getChildren() != null)
		{
			for(int i = 0; i < subject.getChildren().size(); i++)
			{
				Token child = subject.getChildren().get(i);
				child.setParentClass(subject.getParentClass());
				child.setParentMethod(subject.getParentMethod());
			}
			
			Token.pass1(subject.getChildren());
			
			if(subject.getChildren().size() == 3)
			{
				Token child = subject.getChildren().get(2);
				subject.setToken(child.getType());
			}
			else if(subject.getChildren().size() == 1)
			{
				Token child = subject.getChildren().get(0);
				subject.setToken(child.getType());
			}
		}
	}

	/**
	 * Cycles through each child and triggers type check
	 * Performs type check on current node
	 * @author Corey Peregord
	 * @throws ProcessException 
	 */
	public static void processPass2(Token subject) throws ProcessException 
	{
		if(subject.getChildren() != null)
		{
			Token.pass2(subject.getChildren());
			
			if(subject.getChildren().size() == 3)
			{
				Token exp4 = subject.getChildren().get(0);
				Token exp5 = subject.getChildren().get(2);
				
				if(!exp4.getType().equals(exp5.getType()))
				{
					throw new ProcessException();
				}
			}
		}
	}

	/**
	 * Cycles through each child, triggers child to perform pass 3
	 * Generates code at this level
	 * @author Corey Peregord
	 */
	public static void processPass3(Token subject) 
	{
		if(subject.getChildren() != null)
		{
			Token.pass3(subject.getChildren());
			
			if(subject.getChildren().size() == 3)
			{
				//Token exp4 = subject.getChildren().get(0);
				//Token exp5 = subject.getChildren().get(2);
				//Token op = subject.getChildren().get(1);
				
				subject.setCode(new StringBuffer("OP4.getOperater(), EXP4_B.getValue() ,EXP5.getValue() , EXP4_A.setValue(result)"));
			} 
			else if(subject.getChildren().size() == 1)
			{
				subject.setCode(new StringBuffer("EXP4.setValue(EXP5.getValue())"));
			}
		}
	}

}
