package symboltable;

import java.util.ArrayList;

import symboltable.variable.impl.InstancePrimitiveVariable;

/**
 * Class to handle the classes 
 * @author Michael Zimmerman
 * 
 */
public class Class { 
	
	private String name;
    private Class ext; 
    private boolean extend = false;
    private ArrayList<Method> methods = new ArrayList<Method>();
    private ArrayList<InstancePrimitiveVariable> vars = new ArrayList<InstancePrimitiveVariable>();
    /**
     * @param name the class name
     * @param methods 
     * @param vars 
     * @param ext 
     */
    public Class(String name, ArrayList<Method> methods, ArrayList<InstancePrimitiveVariable> vars, Class ext)
    {
    	this.name = name;
    	this.ext = ext;
    	this.methods = methods;
    	this.vars = vars;
    	
    	if(ext != null)
    	{
    		extend = true;
    	}
    }
    
	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * @return the extension of the class
	 */
	public Class getExtention() 
	{
		return ext; 
	}

	/**
	 * @param ext the extension of the class
	 */
	public void setExtention(Class ext) 
	{
		this.ext = ext;
		extend = true;
	}
	
	/**
	 * 
	 * @return true or false if the class has an extension 
	 */
	public boolean checkExtension()
	{
		return extend;
	}

	/**
	 * @return the arraylist of methods 
     */
    public ArrayList<Method> getMethods()
    {
    	return methods;
    }
    
    /**
     * @param methods sets the methods of a class
     */
    public void setMethods(ArrayList<Method> methods)
    {
    	this.methods = methods;
    }
    /**
     * checks for the potential super class if there is one 
     * for instance variables within that superclass
     * @return the variables of the class
     */
    public ArrayList<InstancePrimitiveVariable> getVars()
    {
    	if(ext != null)
    		if(!ext.vars.isEmpty())
    		{
    			vars.addAll(ext.vars);
    		}
    	return vars;
    }
    
    /**
     * @param vars sets the variables of the class 
     */
    public void setVars(ArrayList<InstancePrimitiveVariable> vars)
    {
    	this.vars = vars;
    }
    
    
}
