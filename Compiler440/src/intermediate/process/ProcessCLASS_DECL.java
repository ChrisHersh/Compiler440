package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;
/**
 * 
 * @author shannon jones
 * Handle process passes for:
 * CLASS_DECL­> class id { VAR_DECL_L METH_DECL_L }
 *           ­> class id extends id { VAR_DECL_L METH_DECL_L }
 * 
 * ClassName = id.getToken()
 * VAR_DECL_L.setClassName(ClassName)
 * METH_DECL_L.setClassName(ClassName)
 * 
 */
public class ProcessCLASS_DECL 
{
	/**
	 * Pass 1 -> Gather name and type of all variables, methods, classes
	 * @author sj2451
	 * @param subject
	 */
	public static void processPass1(Token subject) 
	{
		
		
	}

	/**
	 * Pass 2 -> Check that all types are valid
	 * @author sj2451
	 * @param subject
	 */
	public static void processPass2(Token subject) 
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Pass 3 -> Usage Check (exists, type match, generate intermediate code)
	 * @author shannon jones
	 * @param subject
	 */
	public static void processPass3(Token subject) 
	{
		// TODO Auto-generated method stub
		
	}
}
