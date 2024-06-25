package main;

public class Question {

	private int value;
	private String question;
	private String answer;
	
	public Question(int value, String question,String answer)
	{
		this.value = value;
		this.question = question;
		this.answer = answer;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public int getValue() {
		return value;
	}
	
	
	
	
}
