package com.senpai.game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundPanel extends JPanel {

	public RoundPanel(int playerid) {
		this.setLayout(null);
		Player p = Main.game.getPlayerArray()[playerid];
		JLabel lbl1 = new JLabel();
		if (p.getDiceScoreArray() != null) {
			String scoresText = "Spieler " + p.getPlayerId() + " ";
			for (int i = 0; i < p.getDiceScoreArray().length; i++) {
				scoresText = scoresText + " " + p.getDiceScoreArray()[i];
			}
			scoresText = scoresText + " , Zeitiger Score " + p.getScore();
			p.resetDiceScore();
			lbl1.setText(scoresText);
			lbl1.setBounds(10, 0, 300, 30);
			add(lbl1);

			this.setBackground(Color.LIGHT_GRAY);
		} else {
			p.resetDiceScore();
			lbl1.setText("Spieler " + p.getPlayerId()
					+ " hat eine Ungerade Zahl gewürfelt, Score:" + p.getScore());
			lbl1.setBounds(10, 0, 300, 30);
			add(lbl1);

			this.setBackground(Color.RED);
		}

	}

}
