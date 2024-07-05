package main;
import java.util.*;
public class Main {
		
		public static int score = 0;
		private static boolean running = true;
		private static boolean paused = true;
		private static final Object lock = new Object();
		
		public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in);
	
			
			int score = 0;
			System.out.println("Welcome to this basic quiz game!");
			System.out.println("You will have series of ten questions to answer within 1 minute! "
					+ "Each question is worth a certain amount of points depending on difficulty. Good Luck! (50 points to win)");
		
			
			long start = System.currentTimeMillis();
			long end = start + 60 * 1000;
			Questions list = new Questions();
			list.createQuestions();
			Question rand = Questions.getRandomQuestion();
			QuizGUI UI = new QuizGUI(rand);
			String Panswer = "";
			
			
			while(System.currentTimeMillis() < end && score < 50 && running)
			{
				synchronized(lock) {
					while(paused) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					UI.setQuestion(rand);
					
					System.out.println(rand.getQuestion());
					
					UI.buttonA.addActionListener(UI);
					UI.buttonB.addActionListener(UI);
					UI.buttonC.addActionListener(UI);
					UI.buttonD.addActionListener(UI);
					rand = Questions.getRandomQuestion();
				
					UI.refreshList(rand);
					UI.setQuestion(rand);
					Panswer = input.nextLine();	
				}			
			
			}
			
			if(score >= 50)
				System.out.println("Congrats! you won with a score of: " + score);
			else 
				System.out.println("You failed with a score of: " + score);
			
			input.close();
			
			
			
		}
		
	}

