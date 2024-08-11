package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {
	
	Random r=new Random();
	JFrame frame=new JFrame();
	JPanel heading=new JPanel();
	JPanel buttons=new JPanel();
	JLabel text=new JLabel();
	JButton[] btns=new JButton[9];
	boolean X_turn;
	
	TicTacToe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		text.setBackground(Color.GRAY);
		text.setForeground(Color.MAGENTA);
		text.setText("Tic Tac Toe");
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setFont(new Font("Sans Serif",Font.BOLD,50));
		
		buttons.setLayout(new GridLayout(3,3));
		
		heading.setLayout(new BorderLayout());
		heading.setBounds(0, 0, 600, 150);
		heading.add(text);
		
		for(int i=0;i<9;i++) {
			btns[i]=new JButton();
			buttons.add(btns[i]);
			btns[i].setFocusable(false);
			btns[i].setFont(new Font("Times New Roman",Font.BOLD,70));
			btns[i].addActionListener(this);
		}
		
		frame.add(heading,BorderLayout.NORTH);
		frame.add(buttons);
		
		Turn();
	}

	private void Turn() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(r.nextInt(2)==0) {
			X_turn=true;
			text.setText("X turn");
		}
		else {
			X_turn=false;
			text.setText("O turn");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++) {
			if(e.getSource()==btns[i]) {
				if(X_turn) {
					if(btns[i].getText()=="") {
						btns[i].setForeground(new Color(255,0,0));
						btns[i].setText("X");
						X_turn=false;
						text.setText("O turn");
						check();
					}
				}
				else {
					if(btns[i].getText()=="") {
						btns[i].setForeground(new Color(0,0,255));
						btns[i].setText("O");
						X_turn=true;
						text.setText("X turn");
						check();
					}
				}
			}
		}
	}

	private void check() {
		// TODO Auto-generated method stub
		boolean draw=true;
		for(int i=0;i<9;i+=3) {
			if(btns[i].getText()=="X" && btns[i+1].getText()=="X" && btns[i+2].getText()=="X")
				xWins(i,i+1,i+2);
		}
		for(int j=0;j<3;j++) {
			if(btns[j].getText()=="X" && btns[j+3].getText()=="X" && btns[j+6].getText()=="X")
				xWins(j,j+3,j+6);
		}
		if(btns[0].getText()=="X" && btns[4].getText()=="X" && btns[8].getText()=="X")
			xWins(0,4,8);
		if(btns[2].getText()=="X" && btns[4].getText()=="X" && btns[6].getText()=="X")
			xWins(2,4,6);
		
		
		for(int i=0;i<9;i+=3) {
			if(btns[i].getText()=="O" && btns[i+1].getText()=="O" && btns[i+2].getText()=="O")
				oWins(i,i+1,i+2);
		}
		for(int j=0;j<3;j++) {
			if(btns[j].getText()=="O" && btns[j+3].getText()=="O" && btns[j+6].getText()=="O")
				oWins(j,j+3,j+6);
		}
		if(btns[0].getText()=="O" && btns[4].getText()=="O" && btns[8].getText()=="O")
			oWins(0,4,8);
		if(btns[2].getText()=="O" && btns[4].getText()=="O" && btns[6].getText()=="O")
			oWins(2,4,6);
		for(int i=0;i<9;i++) {
			if(btns[i].getText()=="") {
				draw=false;
				break;
			}
		}
		if(draw) {
			if(text.getText()!="O wins" && text.getText()!="X wins")
				text.setText("Draw");
			for(int n=0;n<9;n++)
				btns[n].setEnabled(false);
		}
	}

	private void oWins(int i, int j, int k) {
		// TODO Auto-generated method stub
		btns[i].setBackground(new Color(0,255,0));
		btns[j].setBackground(new Color(0,255,0));
		btns[k].setBackground(new Color(0,255,0));
		for(int n=0;n<9;n++)
			btns[n].setEnabled(false);
		text.setText("O wins");
	}

	private void xWins(int i, int j, int k) {
		// TODO Auto-generated method stub
		btns[i].setBackground(new Color(0,255,0));
		btns[j].setBackground(new Color(0,255,0));
		btns[k].setBackground(new Color(0,255,0));
		for(int n=0;n<9;n++)
			btns[n].setEnabled(false);
		text.setText("X wins");
	}
}
