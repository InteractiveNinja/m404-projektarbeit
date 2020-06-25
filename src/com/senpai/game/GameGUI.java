package com.senpai.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameGUI extends JFrame implements ActionListener {

	private BackgroundScoreGUI gamegui;

	private JButton dice = new JButton();
	private JButton skip = new JButton();
	private JLabel dice_points_text = new JLabel();
	private JLabel rounds_left_text = new JLabel();
	private int playerid, dice_points;
	private int rounds_left = Main.game.getPlayRounds();
	private int localscore = 0;
	private int roundsplayed = 0;

	public GameGUI(int _playerid, BackgroundScoreGUI gui) {

		gamegui = gui;
		setLayout(null);

		playerid = _playerid;

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.getContentPane();

		setSize(450, 240);

		setTitle("Spieler " + playerid);

		setVisible(true);
		elements();

	}

	private void elements() {
		dice.setText("Würfeln");
		dice.setBounds(130, 100, 120, 30);
		dice.addActionListener(this);
		add(dice);

		skip.setText("Sichern");
		skip.setBounds(130, 140, 120, 30);
		skip.addActionListener(this);
		add(skip);

		rounds_left_text.setText("Wüfel übrig: " + rounds_left);
		rounds_left_text.setBounds(130, 20, 120, 30);
		add(rounds_left_text);

		dice_points_text.setText("");
		dice_points_text.setBounds(130, 50, 120, 30);
		add(dice_points_text);

	}

	private void updateText() {
		dice_points_text.setText("Würfel Wert: " + dice_points);
		rounds_left_text.setText("Wüfel übrig: " + rounds_left);
	}

	private void endRound() {
		Main.game.getPlayerArray()[playerid].addScore(localscore);
		if (playerid == Main.game.getPlayerArray()[Main.game.getPlayerArray().length - 1].getPlayerId()) {
			Main.game.setPlayedRound();
			gamegui.updateText();

		}
		gamegui.showScoresRound(playerid);
		gamegui.setEnabled(true);
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dice) {

			rounds_left--;
			dice_points = Main.game.getRandom();

			Main.game.getPlayerArray()[playerid].getDiceScoreArray()[roundsplayed] = dice_points;
			roundsplayed++;
			if (Main.game.isNotOdd(dice_points)) {

				localscore += dice_points;

			} else {
				localscore = 0;
				Main.game.getPlayerArray()[playerid].killDiceScore();
				JOptionPane.showMessageDialog(null, "Du hast " + dice_points + " Gewürfelt! Runde wird beendet");
				endRound();

			}

			updateText();

			if (rounds_left == 0) {
				endRound();
			}

		}
		if (e.getSource() == skip) {
			endRound();
		}

	}

}
