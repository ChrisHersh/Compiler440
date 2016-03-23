import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import parser.TestParser;
import symboltable.TestClasses;
import symboltable.TestMethods;
import symboltable.TestSymbolTable;
import symboltable.TestVariables;
import tokenizer.TestTokenizer;

@RunWith(Suite.class) 
@Suite.SuiteClasses
( 
	{  
		TestMethods.class,
		TestVariables.class,
		TestParser.class,
		TestTokenizer.class,
		TestClasses.class,
		TestSymbolTable.class
	}
) 
 
public class AllTests 
{ 
} 
