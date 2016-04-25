package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Chad Nunemaker
 */
public class ProcessEXP1
{
	public static void processPass1(Token subject)
	{
		// Handle EXP1_A -> EXP1 op1 EXP2
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP1.name()))
		{
			ProcessEXP1.processPass1(subject.getChildren().get(0));
			ProcessOP1.processPass1(subject.getChildren().get(1));
			ProcessEXP2.processPass1(subject.getChildren().get(2));
			
//			EXP1.setClassName(classname)
//			EXP1.setMethodName(methodName)
//			EXP2.setClassName(classname)
//			EXP2.setMethodName(methodName)
			
		} // Handle EXP1 -> EXP2
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
		{
			ProcessEXP2.processPass1(subject.getChildren().get(0));
			
//			EXP2.setClassName(classname)
//			EXP2.setMethodName(methodName)

		}
	}

	public static void processPass2(Token subject)
	{
		// Handle EXP1_A -> EXP1 op1 EXP2
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP1.name()))
		{
			ProcessEXP1.processPass1(subject.getChildren().get(0));
			ProcessOP1.processPass1(subject.getChildren().get(1));
			ProcessEXP2.processPass1(subject.getChildren().get(2));
			
//			If EXP1.getType and EXP2.getType don't match throw a fit otherwise
//			Type = EXP2.getType()

		} // Handle EXP1 -> EXP2
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
		{
			ProcessEXP2.processPass1(subject.getChildren().get(0));
			
//			Type = EXP2.getType()
		}
	}

	public static void processPass3(Token subject)
	{
		// Handle EXP1_A -> EXP1 op1 EXP2
		if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP1.name()))
		{
			ProcessEXP1.processPass1(subject.getChildren().get(0));
			ProcessOP1.processPass1(subject.getChildren().get(1));
			ProcessEXP2.processPass1(subject.getChildren().get(2));
			
//			OP1.getOperater(), EXP1_B.getValue() ,EXP2.getValue() , EXP1_A.setValue(result)
			
		} // Handle EXP1 -> EXP2
		else if (subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP2.name()))
		{
			ProcessEXP2.processPass1(subject.getChildren().get(0));
			
//			EXP1.setValue(EXP2.getValue())
		}
	}
}
