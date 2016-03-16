package symboltable.variable.impl;

import symboltable.Variable;
import symboltable.VariableScope;
import symboltable.VariableType;

/**
 * 
 * @author Ian Keefer
 *
 */
public class InstancePrimitiveVariable extends Variable 
{

	public InstancePrimitiveVariable(String name, String className, VariableScope scope, VariableType type) 
	{
		super(name, className, "", "", scope, type);
	}

}
