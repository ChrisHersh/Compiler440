import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import parser.TestParser;
import parser.states.*;
import parser.states.CILS.TestCILS_1;
import parser.states.CILS.TestCILS_10;
import parser.states.CILS.TestCILS_11;
import parser.states.CILS.TestCILS_12;
import parser.states.CILS.TestCILS_13;
import parser.states.CILS.TestCILS_14;
import parser.states.CILS.TestCILS_15;
import parser.states.CILS.TestCILS_16;
import parser.states.CILS.TestCILS_17;
import parser.states.CILS.TestCILS_19;
import parser.states.CILS.TestCILS_2;
import parser.states.CILS.TestCILS_20;
import parser.states.CILS.TestCILS_22;
import parser.states.CILS.TestCILS_24;
import parser.states.CILS.TestCILS_25;
import parser.states.CILS.TestCILS_26;
import parser.states.CILS.TestCILS_27;
import parser.states.CILS.TestCILS_28;
import parser.states.CILS.TestCILS_29;
import parser.states.CILS.TestCILS_3;
import parser.states.CILS.TestCILS_30;
import parser.states.CILS.TestCILS_31;
import parser.states.CILS.TestCILS_32;
import parser.states.CILS.TestCILS_5;
import parser.states.CILS.TestCILS_6;
import parser.states.CILS.TestCILS_7;
import parser.states.CILS.TestCILS_8;
import parser.states.CILS.TestCILS_9;
import parser.states.CRM.TestCRM_1;
import parser.states.CRM.TestCRM_10;
import parser.states.CRM.TestCRM_11;
import parser.states.CRM.TestCRM_12;
import parser.states.CRM.TestCRM_13;
import parser.states.CRM.TestCRM_16;
import parser.states.CRM.TestCRM_18;
import parser.states.CRM.TestCRM_2;
import parser.states.CRM.TestCRM_3;
import parser.states.CRM.TestCRM_31;
import parser.states.CRM.TestCRM_32;
import parser.states.CRM.TestCRM_33;
import parser.states.CRM.TestCRM_34;
import parser.states.CRM.TestCRM_35;
import parser.states.CRM.TestCRM_36;
import parser.states.CRM.TestCRM_38;
import parser.states.CRM.TestCRM_39;
import parser.states.CRM.TestCRM_40;
import parser.states.CRM.TestCRM_41;
import parser.states.CRM.TestCRM_6;
import parser.states.CRM.TestCRM_7;
import parser.states.CRM.TestCRM_8;
import parser.states.CRM.TestCRM_9;
import parser.states.JMCC.TestJMCC_0;
import parser.states.JMCC.TestJMCC_1;
import parser.states.JMCC.TestJMCC_15;
import parser.states.JMCC.TestJMCC_19;
import parser.states.JMCC.TestJMCC_23;
import parser.states.JMCC.TestJMCC_24;
import parser.states.JMCC.TestJMCC_27;
import parser.states.JMCC.TestJMCC_3;
import parser.states.JMCC.TestJMCC_30;
import parser.states.JMCC.TestJMCC_31;
import parser.states.JMCC.TestJMCC_32;
import parser.states.JMCC.TestJMCC_33;
import parser.states.JMCC.TestJMCC_4;
import parser.states.JMCC.TestJMCC_5;
import parser.states.JMCC.TestJMCC_6;
import parser.states.JMCC.TestJMCC_7;
import parser.states.JMCC.TestJMCC_9;
import parser.states.MDJ.TestMDJ_0;
import parser.states.MDJ.TestMDJ_1;
import parser.states.MDJ.TestMDJ_10;
import parser.states.MDJ.TestMDJ_11;
import parser.states.MDJ.TestMDJ_12;
import parser.states.MDJ.TestMDJ_13;
import parser.states.MDJ.TestMDJ_14;
import parser.states.MDJ.TestMDJ_15;
import parser.states.MDJ.TestMDJ_16;
import parser.states.MDJ.TestMDJ_17;
import parser.states.MDJ.TestMDJ_18;
import parser.states.MDJ.TestMDJ_19;
import parser.states.MDJ.TestMDJ_20;
import parser.states.MDJ.TestMDJ_21;
import parser.states.MDJ.TestMDJ_22;
import parser.states.MDJ.TestMDJ_23;
import parser.states.MDJ.TestMDJ_24;
import parser.states.MDJ.TestMDJ_25;
import parser.states.MDJ.TestMDJ_26;
import parser.states.MDJ.TestMDJ_27;
import parser.states.MDJ.TestMDJ_28;
import parser.states.MDJ.TestMDJ_4;
import parser.states.MDJ.TestMDJ_5;
import parser.states.MDJ.TestMDJ_6;
import parser.states.MDJ.TestMDJ_7;
import parser.states.MDJ.TestMDJ_8;
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
		TestJMCC_3.class,
		TestJMCC_4.class,
		TestJMCC_5.class,
		TestJMCC_6.class,
		TestJMCC_7.class,
		TestJMCC_9.class,
		TestJMCC_15.class,
		TestJMCC_19.class,
		TestJMCC_23.class,
		TestJMCC_24.class,
		TestJMCC_27.class,
		TestJMCC_30.class,
		TestJMCC_31.class,
		TestJMCC_32.class,
		TestJMCC_33.class,
		
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
		TestCRM_18.class,
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
		TestCILS_19.class,
		TestCILS_20.class,
		TestCILS_22.class,
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
