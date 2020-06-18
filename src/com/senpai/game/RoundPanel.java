package com.senpai.game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundPanel extends JPanel  {

	
	int x_cord = 10;
	Player[] p = Main.game.getPlayerArray();

	public RoundPanel() {
		this.setLayout(null);

		for (int i = 1; i < p.length; i++) {
			
			JLabel lbl1 = new JLabel();
			lbl1.setText(String.valueOf(p[i].getScore()));
			lbl1.setBounds(x_cord, 10, 30, 30);
			add(lbl1);
			x_cord += 40;
			
		}
		this.setBackground(Color.LIGHT_GRAY);

	}

}
