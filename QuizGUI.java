package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class QuizGUI extends JFrame implements ActionListener {
	JButton buttonA;
	JButton buttonB;
	JButton buttonC;
	JButton buttonD;
	
	QuizGUI(){
		
		this.setTitle("test GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(690,690);
		int frameHeight = this.getHeight();
		int frameWidth = this.getWidth();
		
		
		buttonA = new JButton("A");
		buttonA.setBackground(Color.red);
		buttonA.setSize(200,frameWidth/2);
		buttonA.addActionListener(this);
		
		buttonB = new JButton("B");
		buttonB.setBackground(Color.blue);
		buttonB.setSize(200,frameWidth/2);
		buttonB.addActionListener(this);
		
		buttonC = new JButton("C");
		buttonC.setBackground(Color.orange);
		buttonC.setSize(200,frameWidth/2);
		buttonC.addActionListener(this);
		
		buttonD = new JButton("D");
		buttonD.setBackground(Color.magenta);
		buttonD.setSize(200,frameWidth/2);
		buttonD.addActionListener(this);
		
		JLabel label = new JLabel("Testing label");
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
