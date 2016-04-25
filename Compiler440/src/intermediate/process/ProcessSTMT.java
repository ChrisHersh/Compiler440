package intermediate.process;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe
 * 
 * Process class for STMT (the big one)
 */
public class ProcessSTMT
{
	/**
	 * Using DFS, go through the possible STMT variations to process the STMT token
	 * 
	 * @param subject the incoming token
	 */
	public static void processPass1(Token subject)
	{
		//switch on the first child.getName...
		switch(subject.getChildren().get(0).getTokenName())
		{
		//TODO - finish the stuff
			case "LBrace":
				if(subject.getChildren().get(1).getTokenName().equals(TokenTypes.STMT_P.name()))
				{
					ProcessSTMT_P.processPass1(subject.getChildren().get(1));
				}
			default:
				break;
		}
		
	}

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * Generates intermediate code for STMT
	 * 
	 * @author Jared Good
	 * @param subject token to be processed
	 */
	public static void processPass3(Token subject) {
		// TODO sigh.....
		
		if( subject.getChildren() != null)
		{
		
			// First child token
			Token child = subject.getChildren().get(0);
			
			PrintWriter pw = null;
			
			// Opens the PrintWriter to write the intermediate code
			try {
				FileWriter fw = new FileWriter("intermediate.txt",true);
				pw = new PrintWriter(fw);	
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// Generates the code for the rule:
			// if ( EXP ) STMT1 else STMT2
			if( child.getTokenName().equals( TokenTypes.If.name() ) )
			{
				
				// Non-terminal tokens
				Token exp = subject.getChildren().get(2);
				Token stmt1 = subject.getChildren().get(4);
				Token stmt2 = subject.getChildren().get(6);
				
				// TODO Need proper labels
				
				// Adds start label for the EXP1 to the intermediate code
				pw.println("START_EXP1:");
				
				// Processes EXP1 to generate its intermediate code
				ProcessEXP1.processPass3(exp);
				
				// Jumps to the ELSE label based on the value of EXP1
				// Should fall into the if if the value is "true"
				pw.println("\tJMP [Value], ELSE");
				
				// Processes STMT1 to generate its intermediate code
				ProcessSTMT.processPass3(stmt1);
				
				// Jumps to END and skips the else
				pw.println("\tJMP END");
				
				// Start of the else
				pw.println("ELSE:");
				
				// Processes STMT2 to generate its intermediate code
				ProcessSTMT.processPass3(stmt2);
				
				// Adds the END label
				pw.println("END:");
				
				
			}
			
			// Generates the code for the rule:
			// { STMT_P }
			else if( child.getTokenName().equals( TokenTypes.LBrace.name() ) )
			{
				// Non-terminal token
				Token stmtp = subject.getChildren().get(1);
				
				// Processes STMT_P to generate its intermediate code
				ProcessSTMT_P.processPass3(stmtp);
				
			}
			
			// Generates the code for the rule:
			// while ( EXP ) STMT
			else if( child.getTokenName().equals( TokenTypes.While.name() ) )
			{
				
				// Non-terminal tokens
				Token exp = subject.getChildren().get(2);
				Token stmt = subject.getChildren().get(4);
				
				// Adds start label to intermediate code
				pw.println("START_EXP1:");
				
				// Processes EXP1 to generate its intermediate code
				ProcessEXP1.processPass3(exp);
	
				// Jumps to the end of the while loop if the value indicates so
				pw.println("\tJMP [Value], END");
				
				// Processes STMT to generate its intermediate code
				ProcessSTMT.processPass3(stmt);
	
				// Jumps back to the evaluation of EXP1
				pw.println("\tJMP START_EXP1");
				
				// End label
				pw.println("END:");
				
				
			}
			
			// Generates the code for the rule:
			// System.out.Println ( EXP1 ) ;
			else if( child.getTokenName().equals( TokenTypes.SystemOutPrintln.name() ) )
			{
				// Non-terminal token
				Token exp = subject.getChildren().get(2);
				
				// Processes EXP1 to generate its intermediate code
				ProcessEXP1.processPass3(exp);
				
				// TODO fix this
				// Puts the value of EXP1 in the output register
				// And the type in the output type register
				pw.println("\tLI [Value], OUTPUT_REGISTER?");
				pw.println("\tLI [TYPE], OUTPUT_REGISTER2?");
				
				// System call to output the value
				pw.println("\tSYSCALL");
				
			}
			
			// Generates the code for the id rules
			else if( child.getTokenName().equals( TokenTypes.Id.name() ) )
			{
				// Generates the code for the rule:
				// id = EXP1 ;
				if( subject.getChildren().get(1).getTokenName().equals( TokenTypes.Assignment.name() ) )
				{
					// Non-terminal token
					Token exp = subject.getChildren().get(2);
					
					// Processes EXP1 to generate its intermediate code
					ProcessEXP1.processPass3(exp);
					
					// Stores the value of EXP1 to location of id
					pw.println("\tSW [Value], [id]");
				}
				
				// Generates the code for the rule:
				// id [ EXP1 ] = EXP1 ;
				else if( subject.getChildren().get(1).getTokenName().equals( TokenTypes.LBracket.name() ) )
				{
					// Non-terminal tokens
					Token exp1 = subject.getChildren().get(2);
					Token exp2 = subject.getChildren().get(5);
					
					// Processes both EXP1's to generate their intermediate code
					ProcessEXP1.processPass3(exp1);
					ProcessEXP1.processPass3(exp2);
					
					// Shifts the value of the first EXP1 left 2
					// Resulting in a multiply of 4 to get address offset
					pw.println("\tSLL [Value1], 2, [Value1]");
					
					// Adds the offset to the id address
					pw.println("\tADD [Value1], [id], [Value1]");
					
					// Stores the value of the second EXP2 to the address
					pw.println("\tSW [Value2], [Value1]");
				}
			}
			
			// Closes the PrintWriter
			pw.close();
		}
	}
}
