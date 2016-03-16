package symboltable.variable.impl;

import symboltable.Variable;
import symboltable.VariableScope;
import symboltable.VariableType;

/**
 * 
 * @author Ian Keefer
 *
 */
public class InstanceObjectVariable extends Variable 
{

	public InstanceObjectVariable(String name, String className, String id, VariableScope scope, VariableType type) 
	{
		super(name, className, id, "", scope, type);
	}
	

}
