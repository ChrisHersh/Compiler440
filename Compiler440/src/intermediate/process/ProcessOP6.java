package intermediate.process;
/**
 * op2 rules
 * @author Mohammed 
 */
import tokenizer.Token;

public class ProcessOP6 {
	//Pass 1 -> Gather name and type of all variables, methods, classes
	public static void processPass1(Token subject) {
		//Does not do any thing because there is nothing to check
		
	}
	//Pass 2 -> Check that all types are valid
	public static void processPass2(Token subject) {
		//Does not do any thing because there is nothing to check
		
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
