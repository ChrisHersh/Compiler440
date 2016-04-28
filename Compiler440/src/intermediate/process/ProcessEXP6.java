package intermediate.process;


/**
 * @author Mohammed 
 * Handle Class EXP6, OP6
 */
import symboltable.SymbolTable;
import symboltable.VariableScope;
import symboltable.VariableType;
import symboltable.variable.impl.LocalPrimitiveVariable;
import tokenizer.Token;
import tokenizer.TokenTypes;

public class ProcessEXP6
{
	/**
	 * Pass 1 passes parent class and method info to children nodes and then traverses them.
	 * @param subject the token to process
	 */
	public static void processPass1(Token subject)
	{
		// Handle EXP6_A -> EXP6_B op6 EXP7
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP6.name()))
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
			subject.setType(subject.getChildren().get(2).getType()); // Type = EXP6.getType()
			
			LocalPrimitiveVariable exp6 = new LocalPrimitiveVariable(myName,
					myClass, myMethod, myScope, myType);
			SymbolTable.getInstance().addVariable(myName, exp6);
			
		} // Handle EXP6 -> EXP7
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP7.name()))
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
			subject.setType(subject.getChildren().get(0).getType()); // Type = EXP6.getType()
			
			LocalPrimitiveVariable exp6 = new LocalPrimitiveVariable(myName,
					myClass, myMethod, myScope, myType);
			SymbolTable.getInstance().addVariable(myName, exp6);
		}
	}

	/**
	 * Pass 2 checks that all types are valid.
	 * @param subject the token to process
	 */
	public static void processPass2(Token subject) 
	{
		// Handle EXP6_A -> EXP6_B op6 EXP7
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP6.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
			subject.setVisited();
			
			// If EXP6.getType and EXP7.getType don't match throw a fit otherwise
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

		} // Handle EXP6 -> EXP7
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP7.name()))
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
		// Handle EXP6_A -> EXP6_B op6 EXP7
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP6.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass3(subject.getChildren());
			}
			subject.setVisited();
			
			// Append code.
			Token exp2B = subject.getChildren().get(0);
			Token op6 = subject.getChildren().get(1);
			Token exp7 = subject.getChildren().get(2);
			
			String code = exp2B.getCode().toString();
			subject.getCode().append(code);
			
			code = op6.getCode().toString();
			subject.getCode().append(code);
			
			code = exp7.getCode().toString();
			subject.getCode().append(code);
		} // Handle EXP6 -> EXP7
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP7.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass3(subject.getChildren());
			}
			subject.setVisited();
			
			// Append code.
			Token exp7 = subject.getChildren().get(0);
			String code = exp7.getCode().toString();
			subject.getCode().append(code);
		}
	}
}
