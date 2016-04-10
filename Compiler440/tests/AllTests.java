import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import parser.TestParser;
import parser.states.*;
import parser.states.TestState;
import symboltable.TestClasses;
import symboltable.TestMainMethod;
import symboltable.TestMethods;
import symboltable.TestSymbolTable;
import symboltable.TestVariables;
import symboltable.testClass;
import tokenizer.TestToken;
import tokenizer.TestTokenTypes;
import tokenizer.TestTokenizer;

@RunWith(Suite.class) 
@Suite.SuiteClasses
( 
	{  
		TestMainMethod.class,
		testClass.class,
		TestClasses.class,
		TestMethods.class,
		TestVariables.class,
		TestParser.class,
		TestTokenizer.class,
		TestToken.class,
		TestTokenTypes.class,
		TestClasses.class,
		TestSymbolTable.class,
		TestState.class,

		TestJMCC_5.class,
		TestJMCC_7.class,
		TestJMCC_23.class,
		TestJMCC_27.class,
		
		TestCRM_1.class,
		TestCRM_2.class,
		TestCRM_3.class,
		TestCRM_6.class,
		TestCRM_7.class,
		TestCRM_8.class,
		TestCRM_9.class,
		TestCRM_10.class,
		TestCRM_11.class,
		TestCRM_12.class,
		TestCRM_13.class,
		TestCRM_16.class,
		
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
		TestMDJ_21.class,
		TestMDJ_22.class,
		TestMDJ_23.class,
		TestMDJ_25.class,
		TestMDJ_27.class,
		TestMDJ_28.class,
		
		TestCILS_2.class,
		TestCILS_7.class,
		TestCILS_12.class,
		TestCILS_15.class,
		TestCILS_16.class,
		TestCILS_19.class,
		TestCILS_20.class,
		TestCILS_25.class,
		TestCILS_26.class,
	}
) 
 
public class AllTests 
{ 
} 
