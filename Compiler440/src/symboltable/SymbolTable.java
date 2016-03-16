package symboltable;

import java.util.ArrayList;
import java.util.HashMap;

public class SymbolTable
{

    //mapping from name to list of all variables with that name
    HashMap<String, ArrayList<Variable>> table = new HashMap<String, ArrayList<Variable>>();
}
