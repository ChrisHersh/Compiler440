package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Chad Nunemaker
 */
public class ProcessEXP2
{
	public static void processPass1(Token subject)
	{
		// Handle EXP2_A	-> EXP2 op2 EXP3
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
		{
			ProcessEXP2.processPass1(subject.getChildren().get(0));
			ProcessOP2.processPass1(subject.getChildren().get(1));
			ProcessEXP3.processPass1(subject.getChildren().get(2));
			
//			EXP2.setClassName(classname)
//			EXP2.setMethodName(methodName)
//			EXP3.setClassName(classname)
//			EXP3.setMethodName(methodName)
			
		} // Handle EXP2 -> EXP3
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP3.name()))
		{
			ProcessEXP3.processPass1(subject.getChildren().get(0));
			
//			EXP3.setClassName(classname)
//			EXP3.setMethodName(methodName)

		}
	}

	public static void processPass2(Token subject)
	{
		// Handle EXP2_A	-> EXP2 op2 EXP3
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
		{
			ProcessEXP2.processPass1(subject.getChildren().get(0));
			ProcessOP2.processPass1(subject.getChildren().get(1));
			ProcessEXP3.processPass1(subject.getChildren().get(2));
			
//			If EXP2.getType and EXP3.getType don't match throw a fit otherwise
//			Type = EXP3.getType()

		} // Handle EXP2 -> EXP3
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP3.name()))
		{
			ProcessEXP3.processPass1(subject.getChildren().get(0));
			
//			Type = EXP3.getType()
		}
	}

	public static void processPass3(Token subject)
	{
		// Handle EXP2_A	-> EXP2 op2 EXP3
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
		{
			ProcessEXP2.processPass1(subject.getChildren().get(0));
			ProcessOP2.processPass1(subject.getChildren().get(1));
			ProcessEXP3.processPass1(subject.getChildren().get(2));
			
//			OP2.getOperater(), EXP2_B.getValue(), EXP3.getValue(), EXP2_A.setValue(result)
			
		} // Handle EXP2 -> EXP3
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP3.name()))
		{
			ProcessEXP3.processPass1(subject.getChildren().get(0));
			
//			EXP2.setValue(EXP3.getValue())
		}
	}
}
