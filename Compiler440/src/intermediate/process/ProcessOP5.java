package intermediate.process;
/**
 * @author Manal Ibrahim
 */
import java.io.PrintWriter;

import tokenizer.Token;
import tokenizer.TokenTypes;

public class ProcessOP5 {
	public static void processPass1(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass3(Token subject) {
		PrintWriter s = null;
		if(subject.getTokenName() == TokenTypes.Equals.name()){
 			s.print("+");
 		} else if (subject.getTokenName() == TokenTypes.NotEquals.name()){
 			s.print("-");
 		}
		
	}
}
