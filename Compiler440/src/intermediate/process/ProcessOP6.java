package intermediate.process;

import java.io.PrintWriter;

import tokenizer.Token;
import tokenizer.TokenTypes;

public class ProcessOP6 {
	public static void processPass1(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass3(Token subject) {
	/*	PrintWriter pw = null;
		if(subject.getTokenName() == TokenTypes.Mult.name()){
 			pw.print("*");
 		} else if (subject.getTokenName() == TokenTypes.Div.name()){
 			pw.print("/");
 		}
 	I have tried to run the Symbol Div but i could not because it does not exist in the toknizer
		*/
		
		subject.getCode().append(" * ");
	}
}
