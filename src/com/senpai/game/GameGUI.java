package com.senpai.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameGUI extends JFrame implements ActionListener {

	private BackgroundScoreGUI gamegui;

	private JButton dice = new JButton();
	private JButton skip = new JButton();
	private JLabel dicePointsText = new JLabel();
	private JLabel roundsLeftText = new JLabel();
	private int playerId, dicePoints;
	private int roundsLeft = Main.game.getPlayRounds();
	private int localScore = 0;
	private int roundsPlayed = 0;
	private ImageIcon icon;

	public GameGUI(int _playerId, BackgroundScoreGUI gui) {

		gamegui = gui;
		setLayout(null);

		playerId = _playerId;

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.getContentPane();

		setSize(450, 440);

		setTitle("Spieler " + playerId);

		setVisible(true);
		elements();

	}

	private void elements() {
		dice.setText("Würfeln");
		dice.setBounds(130, 200, 120, 30);
		dice.addActionListener(this);
		add(dice);

		skip.setText("Sichern");
		skip.setBounds(130, 240, 120, 30);
		skip.addActionListener(this);
		add(skip);

		roundsLeftText.setText("Würfeln übrig: " + roundsLeft);
		roundsLeftText.setBounds(140, 20, 120, 30);
		add(roundsLeftText);

		dicePointsText.setText("");
		dicePointsText.setBounds(130, 50, 120, 110);
		add(dicePointsText);

	}

	private void updateText() {
		icon = new ImageIcon(this.getClass().getClassLoader().getResource("imgs/"+dicePoints+".png"));
		dicePointsText.setIcon(icon);
		roundsLeftText.setText("Wüfel übrig: " + roundsLeft);
		
	}

	private void endRound() {
		Main.game.getPlayerArray()[playerId].addScore(localScore);
		if (playerId == Main.game.getPlayerArray()[Main.game.getPlayerArray().length - 1].getPlayerId()) {
			Main.game.setPlayedRound();
			gamegui.updateText();

		}
		gamegui.showScoresRound(playerId);
		gamegui.setEnabled(true);
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dice) {

			roundsLeft--;
			dicePoints = Main.game.getRandom();

			Main.game.getPlayerArray()[playerId].getDiceScoreArray()[roundsPlayed] = dicePoints;
			roundsPlayed++;
			if (Main.game.isNotOdd(dicePoints)) {

				localScore += dicePoints;

			} else {
				localScore = 0;
				Main.game.getPlayerArray()[playerId].killDiceScore();
				JOptionPane.showMessageDialog(null, "Du hast " + dicePoints + " Gewürfelt! Runde wird beendet");
				endRound();

			}

			updateText();

			if (roundsLeft == 0) {
				endRound();
			}

		}
		if (e.getSource() == skip) {
			endRound();
		}

	}

}
