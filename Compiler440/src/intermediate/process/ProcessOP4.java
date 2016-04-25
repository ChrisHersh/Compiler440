package intermediate.process;

import java.io.*;

import tokenizer.Token;
import tokenizer.TokenTypes;

public class ProcessOP4 {
	public static void processPass1(Token subject) {
		//Do nothing, I have no children
	}

	public static void processPass2(Token subject) {
		//Do nothing, I have nothing to check
	}

	public static void processPass3(Token subject) {
		PrintWriter pw = null;
 		
 		try {
 			FileWriter fw = new FileWriter("intermediate.txt",true);
 			pw = new PrintWriter(fw);	
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 		
 		if(subject.getTokenName() == TokenTypes.Gt.name()){
 			pw.print(">");
 		} else if (subject.getTokenName() == TokenTypes.Lt.name()){
 			pw.print("<");
 		} else if (subject.getTokenName() == TokenTypes.GtEquals.name()){
 			pw.print(">=");
 		} else if (subject.getTokenName() == TokenTypes.LtEquals.name()){
 			pw.print("<=");
 		}
	}
}
