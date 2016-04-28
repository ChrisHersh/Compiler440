package intermediate.process;


/**
 * @author Manal Ibrahim 
 * Handle Class EXP5, OP5
 */
import symboltable.SymbolTable;
import symboltable.VariableScope;
import symboltable.VariableType;
import symboltable.variable.impl.LocalPrimitiveVariable;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class ProcessEXP5
{
	/**
	 * Pass 1 passes parent class and method info to children nodes and then traverses them.
	 * @param subject the token to process
	 */
	public static void processPass1(Token subject)
	{
		// Handle EXP5_A -> EX5_B op5 EXP6
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP5.name()))
		{
			// Pass info down to children.
			subject.getChildren().get(0).setParentClass(subject.getParentClass());
			subject.getChildren().get(0).setParentMethod(subject.getParentMethod());
			subject.getChildren().get(1).setParentClass(subject.getParentClass());
			subject.getChildren().get(1).setParentMethod(subject.getParentMethod());
			subject.getChildren().get(2).setParentClass(subject.getParentClass());
			subject.getChildren().get(2).setParentMethod(subject.getParentMethod());
			
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
			subject.setVisited();
			
			// Create variable and add it to symbol table.
			String myName = subject.getTokenName().toString();
			String myClass = subject.getParentMethod().toString();
			String myMethod = subject.getParentClass().toString();
			VariableScope myScope = VariableScope.LOCAL;
			VariableType myType = VariableType.BOOLEAN;
			subject.setType(subject.getChildren().get(2).getType());
			
			LocalPrimitiveVariable exp5 = new LocalPrimitiveVariable(myName,
					myClass, myMethod, myScope, myType);
			SymbolTable.getInstance().addVariable(myName, exp5);
			
		} // Handle EXP5 -> EXP6
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP6.name()))
		{
			// Pass info down to children.
			subject.getChildren().get(0).setParentClass(subject.getParentClass());
			subject.getChildren().get(0).setParentMethod(subject.getParentMethod());
			
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
			subject.setVisited();
			
			// Create variable and add it to symbol table.
			String myName = subject.getTokenName().toString();
			String myClass = subject.getParentMethod().toString();
			String myMethod = subject.getParentClass().toString();
			VariableScope myScope = VariableScope.LOCAL;
			VariableType myType = VariableType.BOOLEAN;
			subject.setType(subject.getChildren().get(0).getType()); 
			
			LocalPrimitiveVariable exp5 = new LocalPrimitiveVariable(myName,
					myClass, myMethod, myScope, myType);
			SymbolTable.getInstance().addVariable(myName, exp5);
		}
	}

	/**
	 * Pass 2 checks that all types are valid.
	 * @param subject the token to process
	 */
	public static void processPass2(Token subject) 
	{
		// Handle EXP5_A -> EXP5_B op5 EXP6
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP5.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
			subject.setVisited();
			
			// If EXP5.getType and EXP6.getType don't match throw a fit otherwise
			final String exp6BType = subject.getChildren().get(0).getType();
			final String exp7Type = subject.getChildren().get(2).getType();
			if (!exp6BType.equals(exp7Type))
			{
				try {
					throw new ProcessException();
				} catch (ProcessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} // Handle EXP5 -> EXP6
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP6.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
			subject.setVisited();
		}
	}

	/**
	 * Pass 3
	 * @param subject the token to process
	 */
	public static void processPass3(Token subject)
	{
		// Handle EXP5_A -> EXP5_B op5 EXP6
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP5.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass3(subject.getChildren());
			}
			subject.setVisited();
			
			// Append code.
			Token exp5B = subject.getChildren().get(0);
			Token op5 = subject.getChildren().get(1);
			Token exp6 = subject.getChildren().get(2);
			
			String code = exp5B.getCode().toString();
			subject.getCode().append(code);
			
			code = op5.getCode().toString();
			subject.getCode().append(code);
			
			code = exp6.getCode().toString();
			subject.getCode().append(code);
		} // Handle EXP5 -> EXP6
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP6.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass3(subject.getChildren());
			}
			subject.setVisited();
			
			// Append code.
			Token exp6 = subject.getChildren().get(0);
			String code = exp6.getCode().toString();
			subject.getCode().append(code);
		}
	}
}
