package com.senpai.game;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameGUI extends JFrame implements ActionListener {

	BackgroundScoreGUI gamegui;

	JButton dice = new JButton();
	JButton skip = new JButton();
	JLabel dice_points_text = new JLabel();
	JLabel rounds_left_text = new JLabel();
	JOptionPane msg = new JOptionPane();
	int playerid, dice_points;
	int rounds_left = Main.game.getPlayRounds();
	int rounds_counter = Main.game.getRounds();
	int localscore = 0;

	public GameGUI(int _playerid, BackgroundScoreGUI gui) {

		gamegui = gui;
		setLayout(null);

		playerid = _playerid;

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = this.getContentPane();

		setSize(450, 240);

		setTitle("Spieler " + playerid);

		setVisible(true);
		Elements();

	}

	private void Elements() {
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

	private void UpdateText() {
		dice_points_text.setText("Würfel Wert: " + dice_points);
		rounds_left_text.setText("Wüfel übrig: " + rounds_left);
	}

	private void Endgame() {
		Main.game.getPlayerArray()[playerid].addScore(localscore);
		/*
		 * for (int i = 1; i < Main.game.getPlayerArray().length; i++) {
		 * System.out.println(Main.game.getPlayerArray()[i].getScore() +
		 * " | "+Main.game.getPlayerArray()[i].getPlayerId()); }
		 */
		if (playerid == Main.game.getPlayerArray()[Main.game.getPlayerArray().length-1].getPlayerId()) {
			gamegui.UpdateText();

		}
		gamegui.setEnabled(true);
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dice) {

			rounds_left--;
			dice_points = Main.game.getRandom();

			if (Main.game.isNotOdd(dice_points)) {

				localscore += dice_points;

			} else {
				msg.showMessageDialog(null, "Du hast " + dice_points + " Gewürfelt! Runde wird beendet");
				Endgame();

			}

			UpdateText();

			if (rounds_left == 0) {
				Endgame();
			}

		}
		if (e.getSource() == skip) {
			Endgame();
		}

	}

}
