package intermediate.process;

import symboltable.SymbolTable;
import symboltable.VariableScope;
import symboltable.VariableType;
import symboltable.variable.impl.LocalPrimitiveVariable;
import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Chad Nunemaker
 */
public class ProcessEXP1
{
	/**
	 * Pass 1 passes parent class and method info to children nodes and then traverses them.
	 * @param subject the token to process
	 */
	public static void processPass1(Token subject)
	{
		// Handle EXP1_A -> EXP1_B op1 EXP2
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP1.name()))
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
			subject.setType(subject.getChildren().get(2).getType()); // Type = EXP2.getType()
			
			LocalPrimitiveVariable exp1 = new LocalPrimitiveVariable(myName,
					myClass, myMethod, myScope, myType);
			SymbolTable.getInstance().addVariable(myName, exp1);
			
		} // Handle EXP1 -> EXP2
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
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
			
			LocalPrimitiveVariable exp1 = new LocalPrimitiveVariable(myName,
					myClass, myMethod, myScope, myType);
			SymbolTable.getInstance().addVariable(myName, exp1);
		}
	}

	/**
	 * Pass 2 checks that all types are valid.
	 * @param subject the token to process
	 * @throws ProcessException a process handling error has occurred
	 */
	public static void processPass2(Token subject) throws ProcessException
	{
		// Handle EXP1_A -> EXP1_B op1 EXP2
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP1.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
			subject.setVisited();
			
			// If EXP1.getType and EXP2.getType don't match throw a fit otherwise
			final String exp1BType = subject.getChildren().get(0).getType();
			final String exp2Type = subject.getChildren().get(2).getType();
			if (!exp1BType.equals(exp2Type))
			{
				throw new ProcessException();
			}

		} // Handle EXP1 -> EXP2
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
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
		// Handle EXP1_A -> EXP1_B op1 EXP2
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP1.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass3(subject.getChildren());
			}
			subject.setVisited();
			
			// Append code.
			Token exp1B = subject.getChildren().get(0);
			Token op1 = subject.getChildren().get(1);
			Token exp2 = subject.getChildren().get(2);
			
			String code = exp1B.getCode().toString();
			subject.getCode().append(code);
			
			code = op1.getCode().toString();
			subject.getCode().append(code);
			
			code = exp2.getCode().toString();
			subject.getCode().append(code);
		} // Handle EXP1 -> EXP2
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
		{
			// Do children passes.
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass3(subject.getChildren());
			}
			subject.setVisited();
			
			// Append code.
			Token exp2 = subject.getChildren().get(0);
			String code = exp2.getCode().toString();
			subject.getCode().append(code);
		}
	}
}
