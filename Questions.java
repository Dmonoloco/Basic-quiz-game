package main;

import java.io.*;
import java.util.ArrayList;

public class Questions {
	
	private static ArrayList<Question> questions = new ArrayList<Question>();
	public static final File file = new File("C:\\Users\\Diego\\eclipse-workspace\\Quiz_Show\\src\\main\\fileOfQuizQuestions.txt");		

	
	public static Question getRandomQuestion() {
		
		String line = "";
		int count = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null)
			{
				if(line.substring(0,8).equals("QUESTION"))
					count++;
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		int random = (int)(Math.random()*count);
		return questions.get(random);
	}
	
	public Question getQuestion(int val){
		return questions.get(val);
	}
	
	public void createQuestions() {
		
		String line1 = "";
		String line2 = "";
		
		try {
			BufferedReader  br = new BufferedReader(new FileReader(file));
			while( (line1 = br.readLine()) != null) {
				line2 = br.readLine();
				questions.add(new Question(5,line1,line2.substring(8)));
			}
			
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
