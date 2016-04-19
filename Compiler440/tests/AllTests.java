import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import parser.TestParser;
import parser.states.*;
import parser.states.CILS.*;
import parser.states.CRM.*;
import parser.states.JCTM.*;
import parser.states.JMCC.*;
import parser.states.MDJ.*;
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

		TestJMCC_0.class,
		TestJMCC_1.class,
		TestJMCC_2.class,
		TestJMCC_3.class,
		TestJMCC_4.class,
		TestJMCC_5.class,
		TestJMCC_6.class,
		TestJMCC_7.class,
		TestJMCC_8.class,
		TestJMCC_9.class,
		TestJMCC_10.class,
		testJMCC_11.class,
		TestJMCC_12.class,
		TestJMCC_13.class,
		TestJMCC_14.class,
		TestJMCC_15.class,
		TestJMCC_16.class,
		TestJMCC_17.class,
		TestJMCC_19.class,
		TestJMCC_21.class,
		TestJMCC_22.class,
		TestJMCC_23.class,
		TestJMCC_24.class,
		TestJMCC_25.class,
		TestJMCC_26.class,
		TestJMCC_27.class,
		TestJMCC_28.class,
		TestJMCC_29.class,
		TestJMCC_30.class,
		TestJMCC_31.class,
		TestJMCC_32.class,
		TestJMCC_33.class,
		
		TestCRM_0.class,
		TestCRM_1.class,
		TestCRM_2.class,
		TestCRM_3.class,
		TestCRM_4.class,
		TestCRM_5.class,
		TestCRM_6.class,
		TestCRM_7.class,
		TestCRM_8.class,
		TestCRM_9.class,
		TestCRM_10.class,
		TestCRM_11.class,
		TestCRM_12.class,
		TestCRM_13.class,
		TestCRM_16.class,
		TestCRM_18.class,
		TestCRM_20.class,
		TestCRM_31.class,
		TestCRM_32.class,
		TestCRM_33.class,
		TestCRM_34.class,
		TestCRM_35.class,
		TestCRM_36.class,
		TestCRM_38.class,
		TestCRM_39.class,
		TestCRM_40.class,
		TestCRM_41.class,
		
		TestJCTM_0.class,
		TestJCTM_10.class,
		TestJCTM_11.class,
		TestJCTM_15.class,
		TestJCTM_16.class,
		TestJCTM_17Test.class,
		TestJCTM_18.class,
		
		TestMDJ_0.class,
		TestMDJ_1.class,
		TestMDJ_3.class,
		TestMDJ_4.class,
		TestMDJ_5.class,
		TestMDJ_6.class,
		TestMDJ_7.class,
		TestMDJ_8.class,
		TestMDJ_9.class,
		TestMDJ_10.class,
		TestMDJ_11.class,
		TestMDJ_12.class,
		TestMDJ_13.class,
		TestMDJ_14.class,
		TestMDJ_15.class,
		TestMDJ_16.class,
		TestMDJ_17.class,
		TestMDJ_18.class,
		TestMDJ_19.class,
		TestMDJ_20.class,
		TestMDJ_21.class,
		TestMDJ_22.class,
		TestMDJ_23.class,
		TestMDJ_24.class,
		TestMDJ_25.class,
		TestMDJ_26.class,
		TestMDJ_27.class,
		TestMDJ_28.class,
		
		TestCILS_1.class,
		TestCILS_2.class,
		TestCILS_3.class,
		TestCILS_5.class,
		TestCILS_6.class,
		TestCILS_7.class,
		TestCILS_8.class,
		TestCILS_9.class,
		TestCILS_10.class,
		TestCILS_11.class,
		TestCILS_12.class,
		TestCILS_13.class,
		TestCILS_14.class,
		TestCILS_15.class,
		TestCILS_16.class,
		TestCILS_17.class,
		TestCILS_18.class,
		TestCILS_19.class,
		TestCILS_20.class,
		TestCILS_21.class,
		TestCILS_22.class,
		TestCILS_23.class,
		TestCILS_24.class,
		TestCILS_25.class,
		TestCILS_26.class,
		TestCILS_27.class,
		TestCILS_28.class,
		TestCILS_29.class,
		TestCILS_30.class,
		TestCILS_31.class,
		TestCILS_32.class,
	}
) 
 
public class AllTests 
{ 
} 
