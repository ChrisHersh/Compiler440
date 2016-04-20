package symboltable;

/**
 * @author Curtis, Ian
 * Variable scope options for variables
 */
public enum VariableScope
{
    /**
     * instance scope - for instance variables
     */
    INSTANCE,
    /**
     * method scope - for method variables (parameters)
     */
    METHOD,
    /**
     * local scope - for all other variables
     */
    LOCAL
}
