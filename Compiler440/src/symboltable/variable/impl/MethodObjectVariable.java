package symboltable.variable.impl;

import symboltable.Variable;
import symboltable.VariableScope;
import symboltable.VariableType;

/**
 * Class to store method Object variables (Parameters)
 * @author Curtis Rabe
 */
public class MethodObjectVariable extends Variable
{

	/**
	 * @param name the name of the variable
	 * @param className name of the class (where the method of the variable is located)
	 * @param id the id of the variable
	 * @param methodName the name of the method where the variable is located
	 * @param scope the scope of the variable (METHOD)
	 * @param type the type of the variable
	 */
	public MethodObjectVariable(String name, String className, String id, String methodName, VariableScope scope, VariableType type) 
	{
		super(name, className, id, methodName, scope, type);
	}

}
