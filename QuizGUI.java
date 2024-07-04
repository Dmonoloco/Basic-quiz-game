package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class QuizGUI extends JFrame implements ActionListener {
	
	JButton buttonA;
	JButton buttonB;
	JButton buttonC;
	JButton buttonD;
	Question question;
	ArrayList<Question> list;
	String rand0;
	String rand1;
	String rand2;
	String rand3;
	
	QuizGUI(Question q){
		
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
		buttonA.setSize(200,frameWidth/2);
		
		
		buttonB = new JButton("B. " +  rand1);
		buttonB.setBackground(Color.blue);
		buttonB.setSize(200,frameWidth/2);
		
		
		
		buttonC = new JButton("C. " +  rand2);
		buttonC.setBackground(Color.orange);
		buttonC.setSize(200,frameWidth/2);
		
		
		
		buttonD = new JButton("D. " +  rand3);
		buttonD.setBackground(Color.magenta);
		buttonD.setSize(200,frameWidth/2);
		
		JLabel label = new JLabel(question.getQuestion());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JPanel greenPanel = new JPanel();
		greenPanel.setSize(200,690);
		greenPanel.setBackground(Color.green);
		greenPanel.add(label);
		
		
		int x = (frameWidth- greenPanel.getWidth()) / 2;
		int y = (frameHeight - greenPanel.getHeight()) / 2;
		
		greenPanel.setBounds(0,y,greenPanel.getHeight(),greenPanel.getWidth());
		
		x = (frameWidth- buttonA.getHeight()) / 2;
		y = (frameHeight - buttonA.getHeight() + 56) / 2;
		
		buttonA.setBounds(0,y,buttonA.getHeight(),buttonA.getWidth());
		
		x = buttonB.getWidth() + 143;
		y = (frameHeight - buttonB.getHeight() + 56) / 2;
				
		buttonB.setBounds(x,y,buttonB.getHeight(),buttonB.getWidth());
		
		buttonC.setBounds(0,397,buttonC.getHeight(),buttonC.getWidth());
		
		buttonD.setBounds(343,400,buttonD.getHeight(),buttonD.getWidth());
		
		this.add(buttonA);
		this.add(buttonB);
		this.add(buttonC);
		this.add(buttonD);
		this.add(greenPanel);
		this.setLayout(null);
		this.setVisible(true);

		
		
	}
	
	public void setQuestion(Question q) {
		question = q;
	}
	
	public void refreshList(Question que) {
		if(list.isEmpty()) {
			list.add(Questions.getRandomQuestion());
			list.add(Questions.getRandomQuestion());
			list.add(Questions.getRandomQuestion());
			list.add(que);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonA) {
			if(rand0.equals(question.getAnswer())) {
				System.out.println("That is the right answer!");
				Main.score++;
				System.out.println(Main.score);
			} else {
				System.out.println("Sorry, that is the wrong answer");
			}
		}
		if(e.getSource() == buttonB) {
			if(rand1.equals(question.getAnswer())) {
				System.out.println("That is the right answer!");
				Main.score++;
				System.out.println(Main.score);
			} else {
				System.out.println("Sorry, that is the wrong answer");
			}
		}
		if(e.getSource() == buttonC) {
			if(rand2.equals(question.getAnswer())) {
				System.out.println("That is the right answer!");
				Main.score++;
				System.out.println(Main.score);
			} else {
				System.out.println("Sorry, that is the wrong answer");
			}
		}
		if(e.getSource() == buttonD) {
			if(rand3.equals(question.getAnswer())) {
				System.out.println("That is the right answer!");
				Main.score++;
				System.out.println(Main.score);
			} else {
				System.out.println("Sorry, that is the wrong answer");
			}
		}
		
	}
}
