package intermediate.process;
import symboltable.SymbolTable;
import symboltable.VariableScope;
import symboltable.VariableType;
import symboltable.variable.impl.LocalPrimitiveVariable;
import tokenizer.Token;

/**
 * Responsible for storing all of the correct information for VAR_DECL
 * 
 * @author Raistlin Hess
 */
public class ProcessVAR_DECL 
{
	/**
	 * Pass class and method information up and down
	 */
	public static void processPass1(Token subject) 
	{
		//Give parentClass and parentMethod to all children
		for(int x = 0; x < subject.getChildren().size(); x++)
		{
			subject.getChildren().get(x).setParentClass(subject.getParentClass());
			subject.getChildren().get(x).setParentMethod(subject.getParentMethod());
			subject.getChildren().get(x).setVisited();
		}
		Token.pass1(subject.getChildren());
		subject.setType(subject.getChildren().get(0).getType());
		
		//Gather info from ID so store into Symbol Table
		String tokenName = subject.getChildren().get(1).getToken().toString();
		String parentMethod = subject.getChildren().get(1).getParentMethod().toString();
		String parentClass = subject.getChildren().get(1).getParentClass().getName();
		VariableScope scope = VariableScope.LOCAL;
		
		//Determine variable type
		VariableType type = null;
		if(subject.getChildren().get(0).getType().toLowerCase().equals("boolean"))
		{
			type = VariableType.BOOLEAN;
		}
		else if(subject.getChildren().get(0).getType().toLowerCase().equals("integer"))
		{
			//The type is an array of ints
			if(subject.getChildren().get(0).getChildren().size() == 3)
			{
				type = VariableType.INTARRAY;
			}
			//The type is just int
			else
			{
				type = VariableType.INTEGER;
			}
		}
		else
		{
			type = VariableType.OBJECT;
		}
		
		LocalPrimitiveVariable varDecl = new LocalPrimitiveVariable(tokenName,parentMethod, parentClass, scope, type);
		
		SymbolTable.getInstance().addVariable(tokenName, varDecl);
	}

	/**
	 * There are no types to check for this state
	 */
	public static void processPass2(Token subject) throws ProcessException
	{
		Token.pass2(subject.getChildren());
	}

	/**
	 * There is no intermediate code to generate for this state
	 */
	public static void processPass3(Token subject) 
	{
		
	}
}
