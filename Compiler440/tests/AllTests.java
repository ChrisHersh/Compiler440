import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import parser.TestParser;
import symboltable.*;
import tokenizer.TestToken;
import tokenizer.TestTokenTypes;
import parser.states.TestMDJ_4;
import tokenizer.TestTokenizer;
import parser.states.*;

@RunWith(Suite.class) 
@Suite.SuiteClasses
( 
	{  
		TestCheckMainMethod.class,
		testClass.class,
		TestClasses.class,
		TestMainMethod.class,
		TestMethods.class,
		TestVariables.class,
		TestParser.class,
		TestTokenizer.class,
		TestToken.class,
		TestTokenTypes.class,
		TestClasses.class,
		TestSymbolTable.class,
		TestState.class,
		
		TestJMCC_27.class,
		TestJMCC_5.class,
		TestJMCC_23.class,
		TestJMCC_7.class,
		TestCRM_1.class,
		TestCRM_2.class,
		TestCRM_3.class,
		
		TestMDJ_21.class,
		TestMDJ_22.class,
		TestMDJ_23.class,
		TestMDJ_25.class,
		TestMDJ_27.class,
		TestMDJ_28.class,
		
		
		TestMDJ_0.class,
		TestMDJ_1.class,
		TestMDJ_4.class,
		TestMDJ_5.class,
		TestMDJ_6.class,
		TestMDJ_7.class,
		TestMDJ_8.class,
		TestMDJ_10.class,
		TestMDJ_11.class,
		TestMDJ_12.class,
		TestMDJ_13.class,
		TestMDJ_14.class,
	}
) 
 
public class AllTests 
{ 
} 
