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
    private String value;
    
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
	
	/**
	 * @return the value
	 */
	public String getValue() 
	{
		return value;
	}

	/**
	 * Type checks to see if the value is valid before assigning it.
	 * Will NOT assign if the types do not match.
	 * @param id the id to set
	 */
	public void setValue(String value, String id) 
	{
		if(isAssignablePrimitive(value)) {
			this.value = value;
		} else if(isAssignableObject(value, id));
	}
	
	/**
	 * Type checks for assigned values.
	 * @param value to type check
	 * @return if types match
	 */
	public boolean isAssignablePrimitive(String value) {
		if(type == VariableType.INTEGER) {
			if(value.matches("-?\\d+(\\.\\d+)?")) {
				return true;
			}
		} else if(type == VariableType.BOOLEAN) {
			if(value.matches("true") || value.matches("false")) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Type checks for objects
	 * @param value
	 * @param id
	 * @return if type matches
	 */
	public boolean isAssignableObject(String value, String id) {
		 if(type == VariableType.OBJECT) {
			if(this.id.equals(id)) {
				return true;
			}
		 }
		 return false;
	}
    

	/**
	 * Checks if operator can be used on this variable
	 * @author Jessica Schlesiger
	 * @return if it can be done
	 */
	public boolean validOperator(String value) {
		if (type == VariableType.INTEGER) {
			String validOp[] = {"+","-","/","*",">","<",">=","<=","==","!="};
			for(int i=0;i<validOp.length;i++) {
				if (value.equals(validOp[i]))
					return true;
			}
			return false;
		} else if (type == VariableType.BOOLEAN) {
			String validOp[] = {"||","&&","!"};
			for(int i=0;i<validOp.length;i++) {
				if (value.equals(validOp[i]))
					return true;
			}
			return false;
		} else if (type == VariableType.OBJECT) {
			return false;
		}
		return false;
	}
	
	/**
	 * Checcks to see if an operation can be done between two variables.
	 * @author TJ Renninger
	 * @return true if it is valid, else false
	 */
	public boolean isValidOperation(Variable var2, String op)
	{
		return validOperator(op) && type == var2.getType();
		//TODO The way it sits now operations are not valid between objects.
	}
}
