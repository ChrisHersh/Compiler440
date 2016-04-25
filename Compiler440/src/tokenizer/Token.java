package tokenizer;

import java.util.ArrayList;

import intermediate.process.ProcessCLASS_DECL;
import intermediate.process.ProcessCLASS_DECL_L;
import intermediate.process.ProcessEXP1;
import intermediate.process.ProcessEXP2;
import intermediate.process.ProcessEXP3;
import intermediate.process.ProcessEXP4;
import intermediate.process.ProcessEXP5;
import intermediate.process.ProcessEXP6;
import intermediate.process.ProcessEXP7;
import intermediate.process.ProcessEXP_L;
import intermediate.process.ProcessEXP_R;
import intermediate.process.ProcessFORMAL_L;
import intermediate.process.ProcessFORMAL_R;
import intermediate.process.ProcessMAIN_CLASS;
import intermediate.process.ProcessMETH_BODY;
import intermediate.process.ProcessMETH_DECL;
import intermediate.process.ProcessMETH_DECL_L;
import intermediate.process.ProcessM_METH_BODY;
import intermediate.process.ProcessOP1;
import intermediate.process.ProcessOP2;
import intermediate.process.ProcessOP3;
import intermediate.process.ProcessOP4;
import intermediate.process.ProcessOP5;
import intermediate.process.ProcessOP6;
import intermediate.process.ProcessPROG;
import intermediate.process.ProcessSTMT;
import intermediate.process.ProcessSTMT_P;
import intermediate.process.ProcessTYPE;
import intermediate.process.ProcessVAR_DECL;
import intermediate.process.ProcessVAR_DECL_L;
import symboltable.Class;
import symboltable.Method;


/**
 * This class holds the information needed for the tokens
 * 
 * @author Chris Hersh, Ian Keefer, Chris Kjeldgaard, Raistlin Hess
 *
 */
public class Token
{
    String token;
    String tokenName;
    int lineNumber;
    ArrayList<Token> childTokens;
    Class parentClass;
    Method parentMethod;
    String type;
    StringBuffer intermediateCode;
    boolean visited;

    /**
     * Method to turn multiple tokens into one, and it marks the line number as the lowest
     * @param tokens the children tokens
     * @param type the type of the expected token
     * @return the new token
     */
    public static Token reduceTokens(ArrayList<Token> tokens, TokenTypes type)
    {
        int lowestLineNum = Integer.MAX_VALUE;
        for(Token t : tokens)
        {
            if(t.lineNumber < lowestLineNum)
                lowestLineNum = t.lineNumber;
        }
        Token newToken = new Token(type.name(), lowestLineNum, tokens);
        
        return newToken;
    }
    
    /**
     * Blank constructor
     */
    public Token()
    {
    }
    
    /**
     * constructor to set the values for nonterminal tokens
     * @param tokenName
     * @param lineNumber
     */
    public Token(TokenTypes token, ArrayList<Token> children)
    {
        this.token = token.name();
        this.tokenName = token.name();
        this.childTokens = children;
        for(Token t : children)
        {
            if(t.lineNumber < this.lineNumber)
                this.lineNumber = t.lineNumber;
        }
        this.parentClass = null;
        this.parentMethod = null;
        this.type = null;
        this.intermediateCode = new StringBuffer();
        visited = false;
    }
    
    
    /**
     * Constructor to set the values for the token
     * @param token
     * @param tokenName
     * @param lineNumber
     */
    public Token(String token, String tokenName, int lineNumber)
    {
        this.token = token;
        this.tokenName = tokenName;
        this.lineNumber = lineNumber;
        this.childTokens = new ArrayList<Token>();
        this.parentClass = null;
        this.parentMethod = null;
        this.type = null;
        this.intermediateCode = new StringBuffer();
        visited = false;
    }
    
    /**
     * Constructor for non terminals
     * @param tokenName
     * @param lineNumber
     * @param children
     */
    public Token(String tokenName, int lineNumber, ArrayList<Token> children)
    {
        this.tokenName = tokenName;
        this.lineNumber = lineNumber;
        this.childTokens = children;
        this.parentClass = null;
        this.parentMethod = null;
        this.intermediateCode = new StringBuffer();
        visited = false;
    }
    
    /**
     * @return token
     */
    public String getToken()
    {
        return token;
    }

    /**
     * @return tokenName
     */
    public String getTokenName()
    {
        return tokenName;
    }

    /**
     * @return lineNumber
     */
    public int getLineNumber()
    {
        return lineNumber;
    }
    
    /**
     * @return childTokens
     */
    public ArrayList<Token> getChildren() 
    {
    	return childTokens;
    }
    
    /**
     * Takes the children token and calls the switch statement on each of them.
     * @author chris Kjeldgaard
     * @param children
     */
    // Shouldn't this just use childTokens? allowing a passed in child array doesnt seem like the best route
    public void pass1 (ArrayList<Token> children)
    {
    	if(children != null)
    	{
	    	for(Token t: children)
	    	{
	    		pass1(t);
	    	}
    	}
    }
    /**
     * Takes the token and based on the token name calls the correct class based on the switch statement.
     * This method calls the class method that implements the Pass1 code for that token.
     * @author Chris Kjeldgard
     * @param subject
     */
    public void pass1 (Token subject)
    {
    	switch (subject.getTokenName())
        {
        case "EXP7":
            ProcessEXP7.processPass1(subject);
            break;
        case "EXP6":
            ProcessEXP6.processPass1(subject);
            break;
        case "EXP5":
            ProcessEXP5.processPass1(subject);
            break;
        case "EXP4":
            ProcessEXP4.processPass1(subject);
            break;
        case "EXP3":
            ProcessEXP3.processPass1(subject);
            break;
        case "EXP2":
            ProcessEXP2.processPass1(subject);
            break;
        case "EXP1":
            ProcessEXP1.processPass1(subject);
            break;
        case "VAR_DECL_L":
            ProcessVAR_DECL_L.processPass1(subject);
            break;
        case "VAR_DECL":
            ProcessVAR_DECL.processPass1(subject);
            break;
        case "PROG":
            ProcessPROG.processPass1(subject);
            break;
        case "CLASS_DECL_L":
            ProcessCLASS_DECL_L.processPass1(subject);
            break;
        case "MAIN_CLASS":
            ProcessMAIN_CLASS.processPass1(subject);
            break;
        case "CLASS_DECL":
            ProcessCLASS_DECL.processPass1(subject);
            break;
        case "M_METH_BODY":
            ProcessM_METH_BODY.processPass1(subject);
            break;
        case "METH_DECL_L":
            ProcessMETH_DECL_L.processPass1(subject);
            break;
        case "METH_DECL":
            ProcessMETH_DECL.processPass1(subject);
            break;
        case "METH_BODY":
            ProcessMETH_BODY.processPass1(subject);
            break;
        case "FORMAL_L":
            ProcessFORMAL_L.processPass1(subject);
            break;
        case "FORMAL_R":
            ProcessFORMAL_R.processPass1(subject);
            break;
        case "TYPE":
            ProcessTYPE.processPass1(subject);
            break;
        case "STMT":
            ProcessSTMT.processPass1(subject);
            break;
        case "STMT_P":
            ProcessSTMT_P.processPass1(subject);
            break;
        case "OP1":
            ProcessOP1.processPass1(subject);
            break;
        case "OP2":
            ProcessOP2.processPass1(subject);
            break;
        case "OP3":
            ProcessOP3.processPass1(subject);
            break;
        case "OP4":
            ProcessOP4.processPass1(subject);
            break;
        case "OP5":
            ProcessOP5.processPass1(subject);
            break;
        case "OP6":
            ProcessOP6.processPass1(subject);
            break;
        case "EXP_L":
            ProcessEXP_L.processPass1(subject);
            break;
        case "EXP_R":
            ProcessEXP_R.processPass1(subject);
            break;  
        default:
            break;
        }
    }
    /**
     * Takes the children token and calls the switch statement on each of them.
     * @author chris Kjeldgaard
     * @param children
     */
    public void pass2 (ArrayList<Token> children)
    {
    	if(children != null)
    	{
	    	for(Token t: children)
	    	{
	    		pass2(t);
	    	}
    	}
    }
    /**
     * Takes the token and based on the token name calls the correct class based on the switch statement.
     * This method calls the class method that implements the Pass2 code for that token.
     * @author Chris Kjeldgard
     * @param subject
     */
    public void pass2 (Token subject)
    {
    	switch (subject.getTokenName())
        {
        case "EXP7":
            ProcessEXP7.processPass2(subject);
            break;
        case "EXP6":
            ProcessEXP6.processPass2(subject);
            break;
        case "EXP5":
            ProcessEXP5.processPass2(subject);
            break;
        case "EXP4":
            ProcessEXP4.processPass2(subject);
            break;
        case "EXP3":
            ProcessEXP3.processPass2(subject);
            break;
        case "EXP2":
            ProcessEXP2.processPass2(subject);
            break;
        case "EXP1":
            ProcessEXP1.processPass2(subject);
            break;
        case "VAR_DECL_L":
            ProcessVAR_DECL_L.processPass2(subject);
            break;
        case "VAR_DECL":
            ProcessVAR_DECL.processPass2(subject);
            break;
        case "PROG":
            ProcessPROG.processPass2(subject);
            break;
        case "CLASS_DECL_L":
            ProcessCLASS_DECL_L.processPass2(subject);
            break;
        case "MAIN_CLASS":
            ProcessMAIN_CLASS.processPass2(subject);
            break;
        case "CLASS_DECL":
            ProcessCLASS_DECL.processPass2(subject);
            break;
        case "M_METH_BODY":
            ProcessM_METH_BODY.processPass2(subject);
            break;
        case "METH_DECL_L":
            ProcessMETH_DECL_L.processPass2(subject);
            break;
        case "METH_DECL":
            ProcessMETH_DECL.processPass2(subject);
            break;
        case "METH_BODY":
            ProcessMETH_BODY.processPass2(subject);
            break;
        case "FORMAL_L":
            ProcessFORMAL_L.processPass2(subject);
            break;
        case "FORMAL_R":
            ProcessFORMAL_R.processPass2(subject);
            break;
        case "TYPE":
            ProcessTYPE.processPass2(subject);
            break;
        case "STMT":
            ProcessSTMT.processPass2(subject);
            break;
        case "STMT_P":
            ProcessSTMT_P.processPass2(subject);
            break;
        case "OP1":
            ProcessOP1.processPass2(subject);
            break;
        case "OP2":
            ProcessOP2.processPass2(subject);
            break;
        case "OP3":
            ProcessOP3.processPass2(subject);
            break;
        case "OP4":
            ProcessOP4.processPass2(subject);
            break;
        case "OP5":
            ProcessOP5.processPass2(subject);
            break;
        case "OP6":
            ProcessOP6.processPass2(subject);
            break;
        case "EXP_L":
            ProcessEXP_L.processPass2(subject);
            break;
        case "EXP_R":
            ProcessEXP_R.processPass2(subject);
            break;  
        default:
            break;
        }
    }
    /**
     * Takes the children token and calls the switch statement on each of them.
     * @author chris Kjeldgaard
     * @param children
     */
    public void pass3 (ArrayList<Token> children)
    {
    	if(children != null)
    	{
	    	for(Token t: children)
	    	{
	    		pass3(t);
	    	}
    	}
    }
    /**
     * Takes the token and based on the token name calls the correct class based on the switch statement.
     * This method calls the class method that implements the Pass3 code for that token.
     * @author Chris Kjeldgard
     * @param subject
     */
    public void pass3 (Token subject)
    {
    	switch (subject.getTokenName())
        {
        case "EXP7":
            ProcessEXP7.processPass3(subject);
            break;
        case "EXP6":
            ProcessEXP6.processPass3(subject);
            break;
        case "EXP5":
            ProcessEXP5.processPass3(subject);
            break;
        case "EXP4":
            ProcessEXP4.processPass3(subject);
            break;
        case "EXP3":
            ProcessEXP3.processPass3(subject);
            break;
        case "EXP2":
            ProcessEXP2.processPass3(subject);
            break;
        case "EXP1":
            ProcessEXP1.processPass3(subject);
            break;
        case "VAR_DECL_L":
            ProcessVAR_DECL_L.processPass3(subject);
            break;
        case "VAR_DECL":
            ProcessVAR_DECL.processPass3(subject);
            break;
        case "PROG":
            ProcessPROG.processPass3(subject);
            break;
        case "CLASS_DECL_L":
            ProcessCLASS_DECL_L.processPass3(subject);
            break;
        case "MAIN_CLASS":
            ProcessMAIN_CLASS.processPass3(subject);
            break;
        case "CLASS_DECL":
            ProcessCLASS_DECL.processPass3(subject);
            break;
        case "M_METH_BODY":
            ProcessM_METH_BODY.processPass3(subject);
            break;
        case "METH_DECL_L":
            ProcessMETH_DECL_L.processPass3(subject);
            break;
        case "METH_DECL":
            ProcessMETH_DECL.processPass3(subject);
            break;
        case "METH_BODY":
            ProcessMETH_BODY.processPass3(subject);
            break;
        case "FORMAL_L":
            ProcessFORMAL_L.processPass3(subject);
            break;
        case "FORMAL_R":
            ProcessFORMAL_R.processPass3(subject);
            break;
        case "TYPE":
            ProcessTYPE.processPass3(subject);
            break;
        case "STMT":
            ProcessSTMT.processPass3(subject);
            break;
        case "STMT_P":
            ProcessSTMT_P.processPass3(subject);
            break;
        case "OP1":
            ProcessOP1.processPass3(subject);
            break;
        case "OP2":
            ProcessOP2.processPass3(subject);
            break;
        case "OP3":
            ProcessOP3.processPass3(subject);
            break;
        case "OP4":
            ProcessOP4.processPass3(subject);
            break;
        case "OP5":
            ProcessOP5.processPass3(subject);
            break;
        case "OP6":
            ProcessOP6.processPass3(subject);
            break;
        case "EXP_L":
            ProcessEXP_L.processPass3(subject);
            break;
        case "EXP_R":
            ProcessEXP_R.processPass3(subject);
            break;  
        default:
            break;
        }
    }
    
    /**
     * Getter for the class this Token belongs to
     * @author Raistlin Hess
     */
    public Class getParentClass()
    {
    	return parentClass;
    }
    
    /**
     * Getter for the method this Token belongs to
     * @author Raistlin Hess
     */
    public Method getParentMethod()
    {
    	return parentMethod;
    }
    
    /**
     * Getter for the Type of this Token
     * @author Raistlin Hess
     */
    public String getType()
    {
    	return this.type; 
    }
    
    /**
     * Setter for the class this Token belongs to
     * @author Raistlin Hess
     */
    public void setParentClass(Class c)
    {
    	this.parentClass = c;
    }
    
    /**
     * Setter for the method this Token belongs to
     * @author Raistlin Hess
     */
    public void setParentMethod(Method m)
    {
    	this.parentMethod = m;
    }
    
    /**
     * Setter for the method this Token belongs to
     * @author Raistlin Hess
     */
    public void setType(String type)
    {
    	this.type = type;
    }
    
    /**
     * Getter for the intermediate code of this Token
     * @author Jared Good
     */
    public StringBuffer getCode()
    {
    	return this.intermediateCode;
    }
    
    /**
     * Method to set the Token to "visited"
     */
    public void setVisited()
    {
    	visited = true;
    }
    
    /**
     * Checks to see if the token has been visited
     * @return visited - boolean value
     */
    public boolean isVisited()
    {
    	return visited;
    }
}
