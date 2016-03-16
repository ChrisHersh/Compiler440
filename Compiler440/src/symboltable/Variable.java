package symboltable;

/**
 * Variable that is inserted into a symbol table.
 * @author Chris Hersh, Ian Keefer
 *
 */
public abstract class Variable
{

	private String name;
    private String className; 
    private String methodName; // only for method and local
    private String id; // object
    private VariableScope scope;
    private VariableType type;
    
	public Variable(String name, String className, String id, String methodName, VariableScope scope, VariableType type) 
	{
		this.name = name;
		this.className = className;
		this.methodName = methodName;
		this.id = id;
		this.scope = scope;
		this.type = type;
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
	 * @return the className
	 */
	public String getClassName() 
	{
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) 
	{
		this.className = className;
	}

	/**
	 * @return the methodName
	 */
	public String getMethodName() 
	{
		return methodName;
	}

	/**
	 * @param methodName the methodName to set
	 */
	public void setMethodName(String methodName) 
	{
		this.methodName = methodName;
	}

	/**
	 * @return the id
	 */
	public String getId() 
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) 
	{
		this.id = id;
	}

	/**
	 * @return the scope
	 */
	public VariableScope getScope() 
	{
		return scope;
	}

	/**
	 * @param scope the scope to set
	 */
	public void setScope(VariableScope scope) 
	{
		this.scope = scope;
	}
	
	/**
	 * @return the type
	 */
	public VariableType getType() 
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(VariableType type) 
	{
		this.type = type;
	}
    
}
