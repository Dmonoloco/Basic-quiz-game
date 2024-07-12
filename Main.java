package main;

import java.util.*;

import javax.swing.ButtonModel;

public class Main {
		
		public static int score = 0;
		
		public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in);
	
			
			int score = 0;
			System.out.println("Welcome to this basic quiz game!");
			System.out.println("You will have series of ten questions to answer within 1 minute! "
					+ "Each question is worth a certain amount of points depending on difficulty. Good Luck! (50 points to win)");
		
			
			long start = System.currentTimeMillis();
			long end = start + 60 * 1000;
			Questions.createQuestions();
			
			Question rand = Questions.getRandomQuestion();
			QuizGUI UI = new QuizGUI(rand);
			
			while(score < 50  && System.currentTimeMillis() < end) {
				System.out.println(rand.getQuestion());
				rand = Questions.getRandomQuestion();
				UI.setQuestion(rand);
				
			}
				
			
			
		
			
			if(score >= 50)
				System.out.println("Congrats! you won with a score of: " + score);
			else 
				System.out.println("You failed with a score of: " + score);
			
			input.close();
			
			
			
		}
		
	}

