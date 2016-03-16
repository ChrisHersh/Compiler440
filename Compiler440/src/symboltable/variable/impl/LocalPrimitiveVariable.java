package symboltable.variable.impl;

import symboltable.Variable;
import symboltable.VariableScope;

/**
 * 
 * @author Ian Keefer
 *
 */
public class LocalPrimitiveVariable extends Variable 
{

	public LocalPrimitiveVariable(String name, String className, String methodName, VariableScope scope) 
	{
		super(name, className, "", methodName, scope);
	}

}
