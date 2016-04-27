package intermediate.process;

import tokenizer.Token;
import tokenizer.TokenTypes;

public class ProcessEXP7
{

	public static void processPass1(Token subject) 
	{
		if(subject.getChildren().get(0).getTokenName().equals(TokenTypes.EXP_L.name())) {
			
			for(int i = 0; i < subject.getChildren().size(); i++)
			{
				subject.getChildren().get(i).setParentClass(subject.getParentClass());
				subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
			}
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
		}
		if(subject.getChildren().get(0).getTokenName().equals(TokenTypes.LBrace.name())) {
			
			for(int i = 0; i < subject.getChildren().size(); i++)
			{
				subject.getChildren().get(i).setParentClass(subject.getParentClass());
				subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
			}
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
		}
		if(subject.getChildren().get(0).getTokenName().equals(TokenTypes.RBrace.name())) {
			
			for(int i = 0; i < subject.getChildren().size(); i++)
			{
				subject.getChildren().get(i).setParentClass(subject.getParentClass());
				subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
			}
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
		}
		if(subject.getChildren().get(0).getTokenName().equals(TokenTypes.Id.name())) {
			
			for(int i = 0; i < subject.getChildren().size(); i++)
			{
				subject.getChildren().get(i).setParentClass(subject.getParentClass());
				subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
			}
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
		}
		if(subject.getChildren().get(0).getTokenName().equals(TokenTypes.Length.name())) {
			
			for(int i = 0; i < subject.getChildren().size(); i++)
			{
				subject.getChildren().get(i).setParentClass(subject.getParentClass());
				subject.getChildren().get(i).setParentMethod(subject.getParentMethod());
			}
			if(subject.getChildren().get(0).isVisited() == false)
			{
				Token.pass1(subject.getChildren());
			}
		}
		
		
		subject.setType(subject.getChildren().get(0).getType());
		subject.setVisited();
		
	}

	public static void processPass2(Token subject) {
		// TODO Auto-generated method stub
		
	}

	public static void processPass3(Token subject) {
		// TODO Auto-generated method stub
		
	}

}
