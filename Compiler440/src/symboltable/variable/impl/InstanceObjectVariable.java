package symboltable.variable.impl;

import symboltable.Variable;
import symboltable.VariableScope;

/**
 * 
 * @author Ian Keefer
 *
 */
public class InstanceObjectVariable extends Variable 
{

	public InstanceObjectVariable(String name, String className, String id, VariableScope scope) 
	{
		super(name, className, id, "", scope);
	}
	

}
