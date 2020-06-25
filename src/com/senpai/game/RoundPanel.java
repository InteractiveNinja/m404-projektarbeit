package com.senpai.game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundPanel extends JPanel {

	public RoundPanel(int playerId) {
		this.setLayout(null);
		Player playerArray = Main.game.getPlayerArray()[playerId];
		JLabel label = new JLabel();
		if (playerArray.getDiceScoreArray() != null) {
			String scoresText = "Spieler " + playerArray.getPlayerId() + " ";
			for (int i = 0; i < playerArray.getDiceScoreArray().length; i++) {
				scoresText = scoresText + " " + playerArray.getDiceScoreArray()[i];
			}
			scoresText = scoresText + " , Zeitiger Score " + playerArray.getScore();
			playerArray.resetDiceScore();
			label.setText(scoresText);
			label.setBounds(10, 0, 300, 30);
			add(label);

			this.setBackground(Color.LIGHT_GRAY);
		} else {
			playerArray.resetDiceScore();
			label.setText("Spieler " + playerArray.getPlayerId()
					+ " hat eine Ungerade Zahl gewürfelt, Score:" + playerArray.getScore());
			label.setBounds(10, 0, 300, 30);
			add(label);

			this.setBackground(Color.RED);
		}

	}

}
