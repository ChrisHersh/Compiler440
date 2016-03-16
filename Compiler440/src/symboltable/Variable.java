package symboltable;

public class Variable
{
    String name;
    VariableType type;
    
    String id; //Only if type is OBJECT
    
    VariableScope scope;
    String classname; 
    String methodname; // only for method and local
    
    //Non object variables
    public Variable(String name, VariableType type, VariableScope scope, String classname)
    {
        
    }
    
    //Object variables
    public Variable(String name, VariableType type, String id, VariableScope scope, String classname)
    {
        
    }

    //Non object variables + method/local variable
    public Variable(String name, VariableType type, VariableScope scope, String classname, String methodname)
    {
        
    }
    
    //Object variables + method/local variable
    public Variable(String name, VariableType type, String id, VariableScope scope, String classname, String methodname)
    {
        
    }
}
