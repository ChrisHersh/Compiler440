package symboltable;

import java.util.ArrayList;

/**
 * Method that is inserted into a symbol table.
 * 
 * NOTE: at the moment, this does not take into account MethodObjectVariables (Objects)
 * 			it only handles primitives
 * @author Curtis Rabe 
 */

public abstract class Method
{
	private String name;
    private Class className;
    private VariableType type;
    private ArrayList<Variable> params = new ArrayList<Variable>();
    /**
     * @param name the Method name
     * @param className the name of the class in which the method is located
     * @param type the return type
     * @param params the parameters of the method
     */
    public Method(String name, Class className, VariableType type, ArrayList<Variable> params)
    {
    	this.name = name;
    	this.className = className;
    	this.type = type;
    	this.params = params;
    	
    }
    
    /**
     * Getter to return the return type of the method
     * @return the return type (in the form of a "VariableType"
     */
    public VariableType getType()
    {
    	return type;
    }
    
    /**
     * Getter for the className variable
     * @return the class name
     */
    public String getClassName()
    {
    	return className.getName();
    }
    
    
    //Getter for params
    /**
     * Returns the arraylist of parameters
     * @return the parameters of the method
     */
    public ArrayList<Variable> getParams()
    {
    	return params;
    }
    
    //Getter for Method Name - MM
   /**
     * Returns the method name
     * @return the name of the method
     */
    public String getMethodName()
    {
    	return name;
    }
 
    /**
     * Validates parameter comparison against current method
     * @param vars Variables to test
     * @return If parameters are in correct order, correct type, correct count
     */
    public boolean validParameters(ArrayList<Variable> vars)
    {
    	if(vars.size() != params.size()) {
    		return false;
    	}
    	
    	for(int i = 0; i < vars.size(); i++) {
    		if(params.get(i).getType() != vars.get(i).getType()) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
}
