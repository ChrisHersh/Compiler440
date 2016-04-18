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
    /**
     * @param name the class name
     * @param ext 
     */
    public Class(String name, Class ext)
    {
    	this.name = name;
    	this.ext = ext;
    	
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

    
    
}
