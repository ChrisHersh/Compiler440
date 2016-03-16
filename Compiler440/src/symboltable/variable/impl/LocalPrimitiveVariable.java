package symboltable.variable.impl;

import symboltable.Variable;
import symboltable.VariableScope;
import symboltable.VariableType;

/**
 * 
 * @author Ian Keefer
 *
 */
public class LocalPrimitiveVariable extends Variable 
{

	public LocalPrimitiveVariable(String name, String className, String methodName, VariableScope scope, VariableType type) 
	{
		super(name, className, "", methodName, scope, type);
	}

}
