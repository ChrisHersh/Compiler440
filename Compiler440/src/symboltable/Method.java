package symboltable;

import java.util.ArrayList;



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
    private Class className;
    private VariableType type;
    private ArrayList<Variable> params = new ArrayList<Variable>();
    private Class grandParent;
    
    /**
     * @param name the Method name
     * @param className the class in which the method is located
     * @param type the return type
     * @param params the parameters of the method
     */
    public Method(String name, Class className, VariableType type, ArrayList<Variable> params)
    {
    	this.name = name;
    	this.className = className;
    	this.type = type;
    	this.params = params;
    	
    	//Check to see if this Method has grandparents.  
    	if(className.checkExtension())
    	{
    		this.grandParent = className.getExtention();
    	}
    	else
    	{
    		this.grandParent = null;
    	}
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
    public Class getClassName()
    {
    	return className;
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
    //Setter for method Name - MM
   /**
     * sets the name of the method
     * @param String s the desired name of the method
     */
    public void setMethodName(String s)
    {
    	name = s;
    }//Not sure if this is needed since the name is passed through the constructor - Curtis R.
    
    /**
     * Getter for method inheritance
     * @return this method's grandparent, if any. Returns null if it has none.
     */
    public Class getGrandParent()
    {
    	return grandParent;
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
