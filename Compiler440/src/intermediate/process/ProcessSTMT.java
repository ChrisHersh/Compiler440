package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * @author Curtis Rabe, Jared Good
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
			case "LBrace":
				for(int i = 0; i < subject.getChildren().size(); i++)
				{
					subject.getChildren().get(i).setParentClass(subject.getParentClass());
					subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
				}
				if(subject.getChildren().get(0).isVisited() == false)
				{
					Token.pass1(subject.getChildren());
				}
				subject.setType(subject.getChildren().get(1).getType());
				break;
			case "If":
				for(int i = 0; i < subject.getChildren().size(); i++)
				{
					subject.getChildren().get(i).setParentClass(subject.getParentClass());
					subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
				}
				if(subject.getChildren().get(0).isVisited() == false)
				{
					Token.pass1(subject.getChildren());
				}
				subject.setType(subject.getChildren().get(2).getType());
				break;
			case "While":
				for(int i = 0; i < subject.getChildren().size(); i++)
				{
					subject.getChildren().get(i).setParentClass(subject.getParentClass());
					subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
				}
				if(subject.getChildren().get(0).isVisited() == false)
				{
					Token.pass1(subject.getChildren());
				}
				subject.setType(subject.getChildren().get(2).getType());
				break;
			case "SystemOutPrintLn":
				for(int i = 0; i < subject.getChildren().size(); i++)
				{
					subject.getChildren().get(i).setParentClass(subject.getParentClass());
					subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
				}
				if(subject.getChildren().get(0).isVisited() == false)
				{
					Token.pass1(subject.getChildren());
				}
				subject.setType(subject.getChildren().get(2).getType());
				break;
			case "Id":
				for(int i = 0; i < subject.getChildren().size(); i++)
				{
					subject.getChildren().get(i).setParentClass(subject.getParentClass());
					subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
				}
				if(subject.getChildren().get(1).getTokenName().equals(TokenTypes.Assignment.name()))
				{
					if(subject.getChildren().get(0).isVisited() == false)
					{
						Token.pass1(subject.getChildren());
					}
					subject.setType(subject.getChildren().get(0).getType());
				}else
				{
					if(subject.getChildren().get(0).isVisited() == false)
					{
						Token.pass1(subject.getChildren());
					}
					subject.setType(subject.getChildren().get(0).getType());
				}
				break;
			default:
				break;
		}
		subject.setVisited();
		
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
	public static void processPass3(Token subject) 
	{
		
		if( subject.getChildren() != null)
		{
		
			// First child token
			Token child = subject.getChildren().get(0);
			
			// Generates the code for the rule:
			// if ( EXP ) STMT1 else STMT2
			if( child.getTokenName().equals( TokenTypes.If.name() ) )
			{
				
				// Non-terminal tokens
				Token exp = subject.getChildren().get(2);
				Token stmt1 = subject.getChildren().get(4);
				Token stmt2 = subject.getChildren().get(6);
				String code;
				
				// TODO Need proper labels
				
				// Adds start label for the EXP1 to the intermediate code
				subject.getCode().append("START_EXP1:");
				
				// Processes EXP1 to generate its intermediate code
				Token.pass3(exp);
				
				// Adds the exp code to the current code
				code = exp.getCode().toString();
				subject.getCode().append(code);
				
				// Jumps to the ELSE label based on the value of EXP1
				// Should fall into the if if the value is "true"
				subject.getCode().append("\tJMP [Value], ELSE\n");
				
				// Processes STMT1 to generate its intermediate code
				Token.pass3(stmt1);
				
				// Adds the first statement code to the current code
				code = stmt1.getCode().toString();
				subject.getCode().append(code);
				
				// Jumps to END and skips the else
				subject.getCode().append("\tJMP END\n");
				
				// Start of the else
				subject.getCode().append("ELSE:\n");
				
				// Processes STMT2 to generate its intermediate code
				Token.pass3(stmt2);
				
				// Adds the second statement code to the current code
				code = stmt2.getCode().toString();
				subject.getCode().append(code);
				
				// Adds the END label
				subject.getCode().append("END:\n");
				
				
			}
			
			// Generates the code for the rule:
			// { STMT_P }
			else if( child.getTokenName().equals( TokenTypes.LBrace.name() ) )
			{
				// Non-terminal token
				Token stmtp = subject.getChildren().get(1);
				
				// Processes STMT_P to generate its intermediate code
				Token.pass3(stmtp);
				
				// Adds the STMT_P code to the STMT token
				String code = stmtp.getCode().toString();
				subject.getCode().append(code);
				
			}
			
			// Generates the code for the rule:
			// while ( EXP ) STMT
			else if( child.getTokenName().equals( TokenTypes.While.name() ) )
			{
				
				// Non-terminal tokens
				Token exp = subject.getChildren().get(2);
				Token stmt = subject.getChildren().get(4);
				String code;
				
				// Adds start label to intermediate code
				subject.getCode().append("START_EXP1:");
				
				// Processes EXP1 to generate its intermediate code
				Token.pass3(exp);
				
				// Adds the EXP1 code to the STMT token
				code = exp.getCode().toString();
				subject.getCode().append(code);
	
				// Jumps to the end of the while loop if the value indicates so
				subject.getCode().append("\tJMP [Value], END");
				
				// Processes STMT to generate its intermediate code
				Token.pass3(stmt);
				
				// Adds the STMT code to the current STMT token
				code = stmt.getCode().toString();
				subject.getCode().append(code);
	
				// Jumps back to the evaluation of EXP1
				subject.getCode().append("\tJMP START_EXP1");
				
				// End label
				subject.getCode().append("END:");
				
				
			}
			
			// Generates the code for the rule:
			// System.out.Println ( EXP1 ) ;
			else if( child.getTokenName().equals( TokenTypes.SystemOutPrintln.name() ) )
			{
				// Non-terminal token
				Token exp = subject.getChildren().get(2);
				
				// Processes EXP1 to generate its intermediate code
				Token.pass3(exp);
				
				// Adds the EXP1 code to the STMT token
				String code = exp.getCode().toString();
				subject.getCode().append(code);
				
				// TODO fix this
				// Puts the value of EXP1 in the output register
				// And the type in the output type register
				subject.getCode().append("\tLI [Value], OUTPUT_REGISTER?");
				subject.getCode().append("\tLI [TYPE], OUTPUT_REGISTER2?");
				
				// System call to output the value
				subject.getCode().append("\tSYSCALL");
				
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
					Token.pass3(exp);
					
					// Adds the EXP1 code to the STMT token
					String code = exp.getCode().toString();
					subject.getCode().append(code);
					
					// Stores the value of EXP1 to location of id
					subject.getCode().append("\tSW [Value], [id]");
				}
				
				// Generates the code for the rule:
				// id [ EXP1 ] = EXP1 ;
				else if( subject.getChildren().get(1).getTokenName().equals( TokenTypes.LBracket.name() ) )
				{
					// Non-terminal tokens
					Token exp1 = subject.getChildren().get(2);
					Token exp2 = subject.getChildren().get(5);
					String code;
					
					// Processes both EXP1's to generate their intermediate code
					Token.pass3(exp1);
					Token.pass3(exp2);
					
					// Adds the first EXP1 code to the STMT token
					code = exp1.getCode().toString();
					subject.getCode().append(code);
					
					// Adds the second EXP1 code to the STMT token
					code = exp2.getCode().toString();
					subject.getCode().append(code);
					
					// Shifts the value of the first EXP1 left 2
					// Resulting in a multiply of 4 to get address offset
					subject.getCode().append("\tSLL [Value1], 2, [Value1]");
					
					// Adds the offset to the id address
					subject.getCode().append("\tADD [Value1], [id], [Value1]");
					
					// Stores the value of the second EXP2 to the address
					subject.getCode().append("\tSW [Value2], [Value1]");
				}
			}
			
		}
	}
}
