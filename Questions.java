package main;

import java.io.*;
import java.util.ArrayList;

public class Questions {
	
	private ArrayList<Question> questions = new ArrayList<Question>();
	public static final File file = new File("C:\\Users\\Diego\\eclipse-workspace\\Quiz_Show\\src\\main\\fileOfQuizQuestions.txt");		

	
	public Question getRandomQuestion() {
		
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
				
//		Question q1 = new Question(5,"What do you call a group of flamingos?","flamboyance");
//		Question q2 = new Question(4,"What sport was featured on the first curved U.S. coin in 2014?","Baseball");
//		Question q3 = new Question(2,"What country uses approximately four billion miles of toilet paper each year?","China");
//		Question q4 = new Question(5,"Cyberphobia is the fear of what?", "Computers");
//		
//		questions.add(q1);
//		questions.add(q2);
//		questions.add(q3);
//		questions.add(q4);
		
	}

}
