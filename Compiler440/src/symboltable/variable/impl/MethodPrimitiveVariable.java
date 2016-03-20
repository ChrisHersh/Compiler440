package symboltable.variable.impl;

import symboltable.Variable;
import symboltable.VariableScope;
import symboltable.VariableType;

/**
 * Class to store method primitive variables (Parameters)
 * @author Curtis
 *
 */
public class MethodPrimitiveVariable extends Variable
{

	/**
	 * @param name the name of the variable
	 * @param className name of the class (where the method of the variable is located)
	 * @param methodName the name of the method where the variable is located
	 * @param scope the scope of the variable (METHOD)
	 * @param type the type of the variable
	 */
	public MethodPrimitiveVariable(String name, String className, String methodName, VariableScope scope, VariableType type) 
	{
		super(name, className, "", methodName, scope, type);
	}

}
