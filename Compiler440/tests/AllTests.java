import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import parser.TestParser;
import symboltable.*;
import tokenizer.TestTokenizer;
import parser.states.*;

@RunWith(Suite.class) 
@Suite.SuiteClasses
( 
	{  
		TestMethods.class,
		TestVariables.class,
		TestParser.class,
		TestTokenizer.class,
		TestClasses.class,
		TestSymbolTable.class,
		
		TestJMCC_27.class,
	}
) 
 
public class AllTests 
{ 
} 
