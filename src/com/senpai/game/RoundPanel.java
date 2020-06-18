package com.senpai.game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundPanel extends JPanel {

	int x_cord = 10;
	
	public RoundPanel(int playerid) {
		this.setLayout(null);
		Player p = Main.game.getPlayerArray()[playerid];
		JLabel lbl1 = new JLabel();
		String scoresText = "Spieler "+ p.getPlayerId() +" ";
		for (int i = 0; i < p.getDiceScoreArray().length; i++) {
			scoresText = scoresText + " " + p.getDiceScoreArray()[i];
		}
		scoresText = scoresText + " , Zeitiger Score " + p.getScore();
		p.resetDiceScore();
		
		lbl1.setText(scoresText);
		lbl1.setBounds(0, 0, 300, 30);
		add(lbl1);
		x_cord += 40;

		this.setBackground(Color.LIGHT_GRAY);

	}

}
