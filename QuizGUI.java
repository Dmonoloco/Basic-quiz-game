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
	
	QuizGUI(Question q){
			
		question = q;
		
		list = new ArrayList<Question>();
	
		list.add(Questions.getRandomQuestion());
		list.add(Questions.getRandomQuestion());
		list.add(q);
		list.add(Questions.getRandomQuestion());
	
		this.setTitle("Quiz Show");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(690,690);
		int frameHeight = this.getHeight();
		int frameWidth = this.getWidth();
		
		int rand = (int)(Math.random()*list.size());
		
		buttonA = new JButton("A. " + list.remove(rand).getAnswer());
		buttonA.setBackground(Color.red);
		buttonA.setSize(200,frameWidth/2);
		buttonA.addActionListener(this);
		
		rand = (int)(Math.random()*list.size());
		
		buttonB = new JButton("B. " +  list.remove(rand).getAnswer());
		buttonB.setBackground(Color.blue);
		buttonB.setSize(200,frameWidth/2);
		buttonB.addActionListener(this);
		
		rand = (int)(Math.random()*list.size());
		
		buttonC = new JButton("C. " +  list.remove(rand).getAnswer());
		buttonC.setBackground(Color.orange);
		buttonC.setSize(200,frameWidth/2);
		buttonC.addActionListener(this);
		
		rand = (int)(Math.random()*list.size());
		
		buttonD = new JButton("D. " +  list.remove(rand).getAnswer());
		buttonD.setBackground(Color.magenta);
		buttonD.setSize(200,frameWidth/2);
		buttonD.addActionListener(this);
		
		JLabel label = new JLabel(q.getQuestion());
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
	
	public void setList(ArrayList<Question> list) {
		this.list = list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonA) {
			System.out.println("buttonA did this");
		}
		if(e.getSource() == buttonB) {
			System.out.println("buttonB did this");
		}
		if(e.getSource() == buttonC) {
			System.out.println("buttonC did this");
		}
		if(e.getSource() == buttonD) {
			System.out.println("buttonD did this");
		}
		
	}
}
