package intermediate.process;

import java.io.*;

import tokenizer.Token;

public class ProcessEXP3 {
	/**
	 * Cycles through each child, triggers child to perform pass 1
	 * @author Corey Peregord
	 */
	public static void processPass1(Token subject) {
		for(int i = 0; i < subject.getChildren().size(); i++){
			Token child = subject.getChildren().get(i);
			//pass class to child
			//pass method to child
			child.Pass1(child.getChildren());
		}
	}

	/**
	 * Cycles through each child, triggers child to perform pass 2
	 * @author Corey Peregord
	 */
	public static void processPass2(Token subject) {
		for(int i = 0; i < subject.getChildren().size(); i++){
			Token child = subject.getChildren().get(i);
			child.Pass2(child.getChildren());
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
			child.Pass3(child.getChildren());
		} else if(subject.getChildren().size() == 3){
			Token exp3 = subject.getChildren().get(0);
			Token exp4 = subject.getChildren().get(2);
			Token op = subject.getChildren().get(1);
			
			pw.println();
			op.Pass3(op.getChildren());
			exp3.Pass3(exp3.getChildren());
			exp4.Pass3(exp4.getChildren());
			pw.print("EXP3-MyAddress?");
		}
		
	}
}
