package symboltable;

import java.util.ArrayList;

/**
 * Class to handle the classes 
 * @author Michael Zimmerman
 * 
 */
public class Class { 
	
	private String name;
    private Class ext; 
    private ArrayList<Variable> instanceVariables;
    /**
     * @param name the class name
     * @param instanceVariables 
     * @param ext 
     */
    public Class(String name, ArrayList<Variable> instanceVariables, Class ext)
    {
    	this.name = name;
    	this.ext = ext;
    	this.instanceVariables = instanceVariables;
    }
    
	/**
	 * Returns the name of a class
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Returs the instance vars of a class
	 * @return the instance vars of a class
	 */
	public ArrayList<Variable> getInstanceVars()
	{
		ArrayList<Variable> v = new ArrayList<Variable>();
		v.addAll(instanceVariables);
		if(ext != null)
		{
			v.addAll(ext.getInstanceVars());
		}
		return v;
	}
	
	
	/**
	 * @return the extension of the class
	 */
	public Class getExtention() 
	{
		return ext; 
	} 
    
}
