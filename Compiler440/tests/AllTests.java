import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import parser.TestParser;
import parser.states.TestCRM_1;
import parser.states.TestCRM_2;
import parser.states.TestCRM_3;
import parser.states.TestJMCC_23;
import parser.states.TestJMCC_27;
import parser.states.TestJMCC_5;
import parser.states.TestJMCC_7;
import parser.states.TestMDJ_0;
import parser.states.TestMDJ_1;
import parser.states.TestMDJ_10;
import parser.states.TestMDJ_11;
import parser.states.TestMDJ_12;
import parser.states.TestMDJ_13;
import parser.states.TestMDJ_14;
import parser.states.TestMDJ_21;
import parser.states.TestMDJ_22;
import parser.states.TestMDJ_23;
import parser.states.TestMDJ_25;
import parser.states.TestMDJ_27;
import parser.states.TestMDJ_28;
import parser.states.TestMDJ_5;
import parser.states.TestMDJ_6;
import parser.states.TestMDJ_7;
import parser.states.TestMDJ_8;
import parser.states.TestState;
import symboltable.TestCheckMainMethod;
import symboltable.TestClasses;
import symboltable.TestMainMethod;
import symboltable.TestMethods;
import symboltable.TestSymbolTable;
import symboltable.TestVariables;
import symboltable.testClass;
import tokenizer.TestTokenizer;

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
