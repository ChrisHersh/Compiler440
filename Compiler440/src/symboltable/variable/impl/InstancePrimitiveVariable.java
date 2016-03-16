package symboltable.variable.impl;

import symboltable.Variable;
import symboltable.VariableScope;

/**
 * 
 * @author Ian Keefer
 *
 */
public class InstancePrimitiveVariable extends Variable 
{

	public InstancePrimitiveVariable(String name, String className, VariableScope scope) 
	{
		super(name, className, "", "", scope);
	}

}
