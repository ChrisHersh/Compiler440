package intermediate.process;

import symboltable.SymbolTable;
import symboltable.VariableScope;
import symboltable.VariableType;
import symboltable.variable.impl.LocalPrimitiveVariable;
import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * Handles passing for FORMAL_L -> TYPE id FORMAL_R
 * @author Jessica Schlesiger
 */
public class ProcessFORMAL_L {
	/**
	 * Gather names and types of all methods
	 * @param subject info being passed in
	 * @author Jessica Schlesiger
	 */
	public static void processPass1(Token subject) {

		// Gives parentClass and parentMethod to all children
		for(int x = 0; x < subject.getChildren().size(); x++)
		{
			subject.getChildren().get(x).setParentClass(subject.getParentClass());
			subject.getChildren().get(x).setParentMethod(subject.getParentMethod());
			subject.getChildren().get(x).setVisited();
		}
		Token.pass1(subject.getChildren());
		subject.setType(subject.getChildren().get(0).getType());


		// Determines type of var
		VariableType type = null;
		if(subject.getChildren().get(0).getType().toLowerCase().equals("boolean"))
		{
			type = VariableType.BOOLEAN;
		}
		else if(subject.getChildren().get(0).getType().toLowerCase().equals("integer"))
		{
			// int array
			if(subject.getChildren().get(0).getChildren().size() == 3)
			{
				type = VariableType.INTARRAY;
			}
			// int
			else
			{
				type = VariableType.INTEGER;
			}
		}
		else
		{
			type = VariableType.OBJECT;
		}



		//Gather info from ID so store into Symbol Table
		String tokenName = subject.getChildren().get(1).getToken().toString();
		String parentMethod = subject.getChildren().get(1).getParentMethod().toString();
		String parentClass = subject.getChildren().get(1).getParentClass().getName();
		VariableScope scope = VariableScope.LOCAL;

		LocalPrimitiveVariable varDecl = new LocalPrimitiveVariable(tokenName,parentMethod, parentClass, scope, type);

		SymbolTable.getInstance().addVariable(tokenName, varDecl);
	}
	/**
	 * No types to check for this state
	 * @param subject info being passed in
	 * @author Jessica Schlesiger
	 */
	public static void processPass2(Token subject) throws ProcessException {
		subject.pass2(subject.getChildren());
	}
	/**
	 * No intermediate code for this state
	 * @param subject info being passed in
	 * @author Jessica Schlesiger
	 */
	public static void processPass3(Token subject) {
		
	}
}