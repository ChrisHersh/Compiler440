package symboltable;

import java.util.ArrayList;

import symboltable.variable.impl.MethodPrimitiveVariable;

/**
 * Method that is inserted into a symbol table.
 * 
 * NOTE: at the moment, this does not take into account MethodObjectVariables (Objects)
 * 			it only handles primitives
 * @author Curtis Rabe
 *
 */

public abstract class Method
{
	private String name;
    private String className;
    private VariableType type;
    private ArrayList<MethodPrimitiveVariable> params = new ArrayList<MethodPrimitiveVariable>();
    /**
     * @param name the Method name
     * @param className the name of the class in which the method is located
     * @param type the return type
     * @param params the parameters of the method
     */
    public Method(String name, String className, VariableType type, ArrayList<MethodPrimitiveVariable> params)
    {
    	this.name = name;
    	this.className = className;
    	this.type = type;
    	this.params = params;
    }
    
    //Getter for name - not my job
    //Getter for className - also not my job
    //Getter for type - also also not my job
    
    
    //Getter for params - IS my job :'(
    /**
     * Returns the arraylist of parameters
     * @return the parameters of the method
     */
    public ArrayList<MethodPrimitiveVariable> getParams()
    {
    	return params;
    }
    
    //Getter for Method Name - MM
    /*
     * Returns the method name
     * @return the name of the method
     */
    public string getMethodName()
    {
    	return name;
    }
    //Setter for method Name - MM
    /*
     * sets the name of the method
     * @param String s the desired name of the method
     */
    public string setMethodName(String s)
    {
    	name = s;
    }
}
