package intermediate.process;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import tokenizer.Token;
import tokenizer.TokenTypes;

public class ProcessSTMT {
	public static void processPass1(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass3(Token subject) {
		// TODO sigh.....
		Token child = subject.getChildren().get(0);
		
		PrintWriter pw = null;
		
		try {
			FileWriter fw = new FileWriter("intermediate.txt",true);
			pw = new PrintWriter(fw);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(child.getTokenName() == TokenTypes.If.name())
		{
			Token exp = subject.getChildren().get(2);
			Token stmt1 = subject.getChildren().get(4);
			Token stmt2 = subject.getChildren().get(6);
			
			// TODO Need proper labels
			
			pw.println("START_EXP1:");
			
			exp.Pass3(exp.getChildren());
			
			pw.println("\tJMP [Value], ELSE");
			
			stmt1.Pass3(stmt1.getChildren());
			
			pw.println("\tJMP END");
			pw.println("ELSE:");
			
			stmt2.Pass3(stmt2.getChildren());
			
			pw.println("END:");
			
			
		}
		
		else if(child.getTokenName() == TokenTypes.LBrace.name())
		{
			
			Token stmtp = subject.getChildren().get(1);
			
			stmtp.Pass3(stmtp.getChildren());
			
		}
		
		else if(child.getTokenName() == TokenTypes.While.name())
		{
			
			Token exp = subject.getChildren().get(2);
			Token stmt = subject.getChildren().get(4);
			
			pw.println("START_EXP1:");
			
			exp.Pass3(exp.getChildren());

			pw.println("\tJMP [Value], END");
			pw.println("WHILE:");
			
			stmt.Pass3(stmt.getChildren());

			pw.println("\tJMP START_EXP1");
			pw.println("END:");
			
			
		}
		else if(child.getTokenName() == TokenTypes.SystemOutPrintln.name())
		{
			Token exp = subject.getChildren().get(2);
			
			exp.Pass3(exp.getChildren());
			
			// TODO fix this
			pw.println("\tLI [Value], OUTPUT_REGISTER?");
			pw.println("\tSYSCALL");
			
		}
		else if(child.getTokenName() == TokenTypes.Id.name())
		{
			
			if(subject.getChildren().get(1).getTokenName() == TokenTypes.Assignment.name())
			{
				Token exp = subject.getChildren().get(2);
				
				exp.Pass3(exp.getChildren());
				pw.println("SW [Value], [id]");
			}
			
			else if(subject.getChildren().get(1).getTokenName() == TokenTypes.LBracket.name())
			{
				Token exp1 = subject.getChildren().get(2);
				Token exp2 = subject.getChildren().get(5);
				
				exp1.Pass3(exp1.getChildren());
				exp2.Pass3(exp2.getChildren());
				
				pw.println("SLL [Value1], 2, [Value1]");
				pw.println("ADD [Value1], [id], [Value1]");
				pw.println("SW [Value2], [Value1]");
			}
		}
		
		
		pw.close();
	}
}
