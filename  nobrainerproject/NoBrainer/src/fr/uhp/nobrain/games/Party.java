package fr.uhp.nobrain.games;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Party implements ActionListener {
	
	private int level;
	private int score;
	private JComponent view;
	
	public Party() {
		this.level = 0;
		this.score = 0;
		
		JLabel choice = new JLabel("Choose a difficulty", JLabel.CENTER);
		
		JButton easy, medium, hard;
		(easy = new JButton("Easy")).addActionListener(this);
		(medium = new JButton("Medium")).addActionListener(this);
		(hard = new JButton("Hard")).addActionListener(this);
	}
	
	public JComponent getView() {
		return this.view;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) throws StringIndexOutOfBoundsException
    {
		String string = event.getActionCommand();
	   
		if(string == "easy")
			level = 0;
		else if (string == "medium")
			level = 1;
		else
			level = 2;
		
		this.start();
	}
	
	private void start() {
		Game let = new LettersGame(level);
		Game num = new NumbersGame(level);
		Game geo = new GeographyGame(level);
		let.play();
		num.play();
		geo.play();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	JFrame f = new JFrame("Difficulty");
        		f.setDefaultCloseOperation(3);
        		f.setSize(300, 300);
        		Party p = new Party();
        		f.add(p.getView());
        		f.setVisible(true);
        		p.start();
            }
        });
		
	}
	}
