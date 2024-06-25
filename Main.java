package main;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int score = 0;
		System.out.println("Welcome to this basic quiz game!");
		System.out.println("You will have series of ten questions to answer within 1 minute! "
				+ "Each question is worth a certain amount of points depending on difficulty. Good Luck! (50 points to win)");
	
		
		long start = System.currentTimeMillis();
		long end = start + 60 * 1000;
		String Panswer;
		Questions list = new Questions();
		list.createQuestions();
		Question rand;
		
		while(System.currentTimeMillis() < end && score < 50)
		{
			rand = list.getRandomQuestion();
			System.out.println(rand.getQuestion());
			Panswer = input.nextLine();
			Panswer = Panswer.substring(0,1).toUpperCase() + Panswer.substring(1);
			if(Panswer.equals(rand.getAnswer()) ) 
			{
				System.out.println("Correct!");
				score += rand.getValue();
			} else {
				System.out.println("Sorry Wrong Answer!");
				System.out.println("Correct answer was : " + rand.getAnswer());
			}
		}
		
		if(score >= 50)
			System.out.println("Congrats! you won with a score of: " + score);
		else 
			System.out.println("You failed with a score of: " + score);
		
		input.close();
		
		
		
	}
}
