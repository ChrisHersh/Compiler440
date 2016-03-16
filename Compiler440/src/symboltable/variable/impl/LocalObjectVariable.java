package symboltable.variable.impl;

import symboltable.Variable;
import symboltable.VariableScope;

/**
 * 
 * @author Ian Keefer
 *
 */
public class LocalObjectVariable extends Variable 
{

	public LocalObjectVariable(String name, String className, String id, String methodName, VariableScope scope) 
	{
		super(name, className, id, methodName, scope);
	}
	

}
