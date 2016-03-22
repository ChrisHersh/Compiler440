package symboltable;

import java.util.ArrayList;

/**
 * Method that is inserted into a symbol table.
 * 
 * NOTE: at the moment, this does not take into account MethodObjectVariables (Objects)
 * 			it only handles primitives
 * @author Curtis Rabe
 *@update by Mohammed 
 *change the privet class classname to string classname 
 *remove the abstract from the method class declaration 
 */

public class Method
{
	private String name;
    private String className;
    private VariableType type;
    private ArrayList<Variable> params = new ArrayList<Variable>();
    /**
     * @param name the Method name
     * @param className the name of the class in which the method is located
     * @param type the return type
     * @param params the parameters of the method
     */
    public Method(String name, String className, VariableType type, ArrayList<Variable> params)
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
}
