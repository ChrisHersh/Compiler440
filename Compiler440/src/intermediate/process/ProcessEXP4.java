package intermediate.process;

import java.io.*;

import tokenizer.Token;

public class ProcessEXP4 {

	/**
	 * Cycles through each child, triggers child to perform pass 1
	 * @author Corey Peregord
	 */
	public static void processPass1(Token subject) {
		for(int i = 0; i < subject.getChildren().size(); i++){
			Token child = subject.getChildren().get(i);
			child.pass1(child.getChildren());
		}
	}

	/**
	 * Cycles through each child, triggers child to perform pass 2
	 * @author Corey Peregord
	 */
	public static void processPass2(Token subject) {
		for(int i = 0; i < subject.getChildren().size(); i++){
			Token child = subject.getChildren().get(i);
			child.pass2(child.getChildren());
		}
		
		//Type check
	}

	/**
	 * Cycles through each child, triggers child to perform pass 3
	 * @author Corey Peregord
	 */
	public static void processPass3(Token subject) {
		PrintWriter pw = null;
 		
 		try {
 			FileWriter fw = new FileWriter("intermediate.txt",true);
 			pw = new PrintWriter(fw);	
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
		
		if(subject.getChildren().size() == 1){
			Token child = subject.getChildren().get(0);
			child.pass3(child.getChildren());
		} else if(subject.getChildren().size() == 3){
			Token exp4 = subject.getChildren().get(0);
			Token exp5 = subject.getChildren().get(2);
			Token op = subject.getChildren().get(1);
			
			pw.println();
			op.pass3(op.getChildren());
			exp4.pass3(exp4.getChildren());
			exp5.pass3(exp5.getChildren());
			pw.print("EXP4-MyAddress?");
		}
		
	}

}
