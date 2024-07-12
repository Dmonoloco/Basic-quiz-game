package main;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class QuizGUI extends JFrame {
	
	public JButton buttonA;
	public JButton buttonB;
	public JButton buttonC;
	public JButton buttonD;
	public Question question;
	public Question randQuestion;
	public ArrayList<Question> list;
	public JLabel label;
	public String rand0;
	public String rand1;
	public String rand2;
	public String rand3;
	
	public QuizGUI(Question q){
		
		question = q;
		
		list = new ArrayList<Question>();
	
		list.add(Questions.getRandomQuestion());
		list.add(Questions.getRandomQuestion());
		list.add(question);
		list.add(Questions.getRandomQuestion());
	
		this.setTitle("Quiz Show");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(690,690);
		int frameHeight = this.getHeight();
		int frameWidth = this.getWidth();
		
		int rand = (int)(Math.random()*list.size());
		
		rand0 = list.remove(rand).getAnswer();
		rand = (int)(Math.random()*list.size());
		rand1 = list.remove(rand).getAnswer();
		rand = (int)(Math.random()*list.size());
		rand2 = list.remove(rand).getAnswer();
		rand = (int)(Math.random()*list.size());
		rand3 = list.remove(rand).getAnswer();
	
		buttonA = new JButton("A. " + rand0);
		buttonA.setBackground(Color.red);
		buttonA.addActionListener((e) -> {
			if(rand0.equals(question.getAnswer())) {
				System.out.println("That is the right answer!");
				Main.score++;
				System.out.println(Main.score);
			} else {
				System.out.println("Sorry, that is the wrong answer");
				System.out.println("The right answer was: " + question.getAnswer());
			}
			randQuestion = Questions.getRandomQuestion();
			setQuestion(randQuestion);
			refreshList(randQuestion);
			refreshFrame();
		});
		
		
		
		buttonB = new JButton("B. " +  rand1);
		buttonB.setBackground(Color.blue);
		buttonB.addActionListener((e) -> {
			if(rand1.equals(question.getAnswer())) {
				System.out.println("That is the right answer!");
				Main.score++;
				System.out.println(Main.score);
			} else {
				System.out.println("Sorry, that is the wrong answer");
				System.out.println("The right answer was: " + question.getAnswer());
			}
			randQuestion = Questions.getRandomQuestion();
			setQuestion(randQuestion);
			refreshList(randQuestion);
			refreshFrame();
		});
		
		
		
		buttonC = new JButton("C. " +  rand2);
		buttonC.setBackground(Color.orange);
		buttonC.addActionListener((e) -> {
			if(rand2.equals(question.getAnswer())) {
				System.out.println("That is the right answer!");
				Main.score++;
				System.out.println(Main.score);
			} else {
				System.out.println("Sorry, that is the wrong answer");
				System.out.println("The right answer was: " + question.getAnswer());
			}
			randQuestion = Questions.getRandomQuestion();
			setQuestion(randQuestion);
			refreshList(randQuestion);
			refreshFrame();
		});
		
		
		
		buttonD = new JButton("D. " +  rand3);
		buttonD.setBackground(Color.magenta);
		buttonD.addActionListener((e) -> {
			if(rand3.equals(question.getAnswer())) {
				System.out.println("That is the right answer!");
				Main.score++;
				System.out.println(Main.score);
			} else {
				System.out.println("Sorry, that is the wrong answer");
				System.out.println("The right answer was: " + question.getAnswer());
			}
			randQuestion = Questions.getRandomQuestion();
			setQuestion(randQuestion);
			refreshList(randQuestion);
			refreshFrame();
		});
		
		label = new JLabel(question.getQuestion());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JPanel greenPanel = new JPanel();
		greenPanel.setSize(200,690);
		greenPanel.setBackground(Color.green);
		greenPanel.add(label);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(455,690);
		mainPanel.setLayout(new GridLayout(2,2));
		mainPanel.add(buttonA);
		mainPanel.add(buttonB);
		mainPanel.add(buttonC);
		mainPanel.add(buttonD);
		
		
		
		int x = (frameWidth- greenPanel.getWidth()) / 2;
		int y = (frameHeight - greenPanel.getHeight()) / 2;
		
		greenPanel.setBounds(0,y,greenPanel.getHeight(),greenPanel.getWidth());
		mainPanel.setBounds(0,200, mainPanel.getHeight(), mainPanel.getWidth());
	
		
		this.add(greenPanel);
		this.add(mainPanel);
		this.setLayout(null);
		this.setVisible(true);

		
		
	}
	
	public void setQuestion(Question q) {
		question = q;
	}
	
	public String refreshList(Question que) {
		if(list.isEmpty()) {
			list.add(Questions.getRandomQuestion());
			list.add(Questions.getRandomQuestion());
			list.add(Questions.getRandomQuestion());
			list.add(que);
		}
		
		return "refreshList method passed";
	}
	
	public String refreshFrame() {
		
		int rand = (int)(Math.random()*list.size());
		
		rand0 = list.remove(rand).getAnswer();
		rand = (int)(Math.random()*list.size());
		rand1 = list.remove(rand).getAnswer();
		rand = (int)(Math.random()*list.size());
		rand2 = list.remove(rand).getAnswer();
		rand = (int)(Math.random()*list.size());
		rand3 = list.remove(rand).getAnswer();
		
		label.setText(question.getQuestion());
		buttonA.setText("A. " + rand0);
		buttonB.setText("B. " + rand1);
		buttonC.setText("C. " + rand2);
		buttonD.setText("D. " + rand3);
		
		return "refreshFrame method passed";
	}
	
}
