package symboltable.method.impl;

import java.util.ArrayList;

import symboltable.Method;
import symboltable.Variable;
import symboltable.VariableType;

import symboltable.Class;

/**
 * Concrete version of a method to use for Parameters
 * @author Curtis Rabe
 *
 */
public class PublicMethod extends Method
{
	/**
	 * @param name the name of the method
	 * @param className the name of the class in which the method is located
	 * @param type the return type of the method
	 * @param params the parameters of the method
	 */
	public PublicMethod(String name, Class className, VariableType type, ArrayList<Variable> params)
	{
		super(name, className, type, params);
	}
}
