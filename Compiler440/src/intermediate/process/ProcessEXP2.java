package intermediate.process;

import symboltable.SymbolTable;
import symboltable.VariableScope;
import symboltable.VariableType;
import symboltable.variable.impl.LocalPrimitiveVariable;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * Process the EXP2 rules.
 * @author Chad Nunemaker
 */
public class ProcessEXP2
{
	/**
	 * Pass 1 passes parent class and method info to children nodes and then traverses them.
	 * @param subject the token to process
	 */
	public static void processPass1(Token subject)
	{
		// Handle EXP2_A -> EXP2_B op2 EXP3
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
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
			subject.setType(subject.getChildren().get(2).getType()); // Type = EXP3.getType()
			
			LocalPrimitiveVariable exp2 = new LocalPrimitiveVariable(myName,
					myClass, myMethod, myScope, myType);
			SymbolTable.getInstance().addVariable(myName, exp2);
			
		} // Handle EXP2 -> EXP3
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP3.name()))
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
			subject.setType(subject.getChildren().get(0).getType()); // Type = EXP2.getType()
			
			LocalPrimitiveVariable exp2 = new LocalPrimitiveVariable(myName,
					myClass, myMethod, myScope, myType);
			SymbolTable.getInstance().addVariable(myName, exp2);
		}
	}

	/**
	 * Pass 2 checks that all types are valid.
	 * @param subject the token to process
	 * @throws ProcessException a process handling error has occurred
	 */
	public static void processPass2(Token subject) throws ProcessException
	{
		// Handle EXP2_A -> EXP2_B op2 EXP3
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
			subject.setVisited();
			
			// If EXP2.getType and EXP3.getType don't match throw a fit otherwise
			final String exp2BType = subject.getChildren().get(0).getType();
			final String exp3Type = subject.getChildren().get(2).getType();
			if (!exp2BType.equals(exp3Type))
			{
				throw new ProcessException();
			}

		} // Handle EXP2 -> EXP3
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP3.name()))
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
	 * Pass 3 creates intermediate code.
	 * @param subject the token to process
	 */
	public static void processPass3(Token subject)
	{
		// Handle EXP2_A -> EXP2_B op2 EXP3
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass3(subject.getChildren());
			}
			subject.setVisited();
			
			// Append code.
			Token exp2B = subject.getChildren().get(0);
			Token op2 = subject.getChildren().get(1);
			Token exp3 = subject.getChildren().get(2);
			
			String code = exp2B.getCode().toString();
			subject.getCode().append(code);
			
			code = op2.getCode().toString();
			subject.getCode().append(code);
			
			code = exp3.getCode().toString();
			subject.getCode().append(code);
		} // Handle EXP2 -> EXP3
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP3.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass3(subject.getChildren());
			}
			subject.setVisited();
			
			// Append code.
			Token exp3 = subject.getChildren().get(0);
			String code = exp3.getCode().toString();
			subject.getCode().append(code);
		}
	}
}
