package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

/**
 * ProcessEXP7.java
 * Process EXP7 rules for the intermediate code generator
 * @author Chris Hersh, Matt Mousetis, Daniel Breitigan
 *
 */
public class ProcessEXP7
{

    /**
     * Processes pass 1
     * @param subject
     */
    public static void processPass1(Token subject)
    {

        //Should be done with every case
        subject.setVisited();

        switch (subject.getChildren().get(0).getTokenName())
        {
        case "This":
            //EXP7 -> this
            subject.setType(subject.getParentClass().getName());
            break;

        case "New":
            if(subject.getChildren().get(1).getTokenName() == "Id")
            {
                //EXP7 -> new id()
                subject.getChildren().get(1).setParentClass(subject.getParentClass());
                subject.getChildren().get(1).setParentMethod(subject.getParentMethod());
                
                //get Token for ID
                subject.setToken(subject.getChildren().get(1).getToken());
                subject.setType("Id()");
                
                if (subject.getChildren().get(2).isVisited() == false)
                {
                    Token.pass1(subject.getChildren().get(2));
                }
            }
            else if(subject.getChildren().get(1).getTokenName() == "Int")
            {
              //EXP7 -> new int [ EXP1 ]
                //Tell EXP1 of it's class and method
                subject.getChildren().get(3).setParentClass(subject.getParentClass());
                subject.getChildren().get(3).setParentMethod(subject.getParentMethod());
                subject.setType("int[]");

                if (subject.getChildren().get(3).isVisited() == false)
                {
                    Token.pass1(subject.getChildren().get(3));
                }
            }
            break;

        case "Id":
            if (subject.getChildren().size() == 1)
            {
                //EXP7 -> id
                //Sets the token to match the id
                subject.setToken(subject.getChildren().get(0).getToken());
                break;
            } else {
                for (int i = 0; i < subject.getChildren().size(); i++)
                {
                    subject.getChildren().get(i).setParentClass(subject.getParentClass());
                    subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
                }
                if (subject.getChildren().get(0).isVisited() == false)
                {
                    Token.pass1(subject.getChildren());
                }
                subject.setType(subject.getChildren().get(0).getType());
            }
            break;
        case "true":
            //EXP7 -> true
            subject.setType(subject.getType());
            break; 
        case "false":
            //EXP7 -> false
        	subject.setType(subject.getType());
            break;     
        case "INTEGER_LITERAL":
            //EXP7 -> INTEGER_LITERAL
        	subject.setType(subject.getType());
            break;
        case "EXP_L":
            for (int i = 0; i < subject.getChildren().size(); i++)
            {
                subject.getChildren().get(i).setParentClass(subject.getParentClass());
                subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
            }
            if (subject.getChildren().get(0).isVisited() == false)
            {
                Token.pass1(subject.getChildren());
            }
            subject.setType(subject.getChildren().get(0).getType());

            break;
        case "LBrace":
            for (int i = 0; i < subject.getChildren().size(); i++)
            {
                subject.getChildren().get(i).setParentClass(subject.getParentClass());
                subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
            }
            if (subject.getChildren().get(0).isVisited() == false)
            {
                Token.pass1(subject.getChildren());
            }
            subject.setType(subject.getChildren().get(0).getType());

            break;
        case "RBrace":
            for (int i = 0; i < subject.getChildren().size(); i++)
            {
                subject.getChildren().get(i).setParentClass(subject.getParentClass());
                subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
            }
            if (subject.getChildren().get(0).isVisited() == false)
            {
                Token.pass1(subject.getChildren());
            }
            subject.setType(subject.getChildren().get(0).getType());

            break;
        case "Length":
            for (int i = 0; i < subject.getChildren().size(); i++)
            {
                subject.getChildren().get(i).setParentClass(subject.getParentClass());
                subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
            }
            if (subject.getChildren().get(0).isVisited() == false)
            {
                Token.pass1(subject.getChildren());
            }
            subject.setType(subject.getChildren().get(0).getType());

            break;
        case "Not":
            //EXP7 -> ! EXP1
            //Tell EXP1 its class and method
            subject.getChildren().get(1).setParentClass(subject.getParentClass());
            subject.getChildren().get(1).setParentMethod(subject.getParentMethod());
            subject.setType(subject.getChildren().get(1).getType());
            
            if (subject.getChildren().get(1).isVisited() == false)
            {
                Token.pass1(subject.getChildren().get(1));
            }
            break;
        case "LPara":
            //EXP7 -> ( EXP1 )
          //Tell EXP1 its class and method
            subject.getChildren().get(1).setParentClass(subject.getParentClass());
            subject.getChildren().get(1).setParentMethod(subject.getParentMethod());
            subject.setType(subject.getChildren().get(1).getType());
            
            if (subject.getChildren().get(1).isVisited() == false)
            {
                Token.pass1(subject.getChildren().get(1));
            }
            break;
        }

    }

    /**
     * Processes pass 2
     * @param subject
     * @throws ProcessException 
     */
    public static void processPass2(Token subject) throws ProcessException
    {
        //Only a few of EXP7s need type checking
        switch (subject.getChildren().get(0).getTokenName())
        {
        case "New":
            if(subject.getChildren().get(1).getTokenName() == "Int")
            {
                if (!subject.getChildren().get(4).getType().equals("int"))
                		throw new ProcessException();
            }
        }
    }

    /**
     * Processes pass 3
     * @param subject
     */
    public static void processPass3(Token subject)
    {
        switch (subject.getChildren().get(0).getTokenName())
        {
        case "EXP_L":
            subject.getCode().append("intermediate code for exp_l");
            break;
        case "LBrace":
            subject.getCode().append("intermediate code for lbrace");
            break;
        case "RBrace":
            subject.getCode().append("intermediate code for rbrace");
            break;
        case "Id":
            subject.getCode().append("intermediate code for id");
            break;
        case "This":
            subject.setCode(new StringBuffer("intermediate code for this"));
            break;
        case "New":
            if(subject.getChildren().get(1).getTokenName() == "Int")
            {
                subject.setCode(new StringBuffer("intermediate code for new int [ EXP1 ]"));
            }
            else
            {
                //Get Token for ID
                Token NewId = subject.getChildren().get(1);
                subject.getCode().append("New_" + NewId.getToken() + "()_" + NewId.getLineNumber() + ":\n");
                
            }
            break;
        case "Length":
            subject.getCode().append("intermediate code for length");
            break;
        case "true":
        	subject.setCode(new StringBuffer("intermediate code for true"));
            break; 
        case "false":
        	subject.setCode(new StringBuffer("intermediate code for false"));
            break;     
        case "INTEGER_LITERAL":
        	subject.setCode(new StringBuffer("intermediate code for INTEGER_LITERAL"));
            break;
        case "Not":
            //Get token for EXP1
            Token NotId = subject.getChildren().get(1);
            subject.getCode().append("!_" + NotId.getTokenName() + "_" + NotId.getLineNumber() + ":\n");
            break;
        case "LPara":
            //Get token for EXP1
            Token LParaId = subject.getChildren().get(1);
            subject.getCode().append("(_" + LParaId.getTokenName() + "_)_" + LParaId.getLineNumber() + ":\n");
            break; 
        

        }
    }
}
