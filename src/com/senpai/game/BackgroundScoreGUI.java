package com.senpai.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class BackgroundScoreGUI extends JFrame implements ActionListener {

	private JButton dice = new JButton();
	private JLabel roundsLabel = new JLabel();
	private JPanel backgroundPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane(backgroundPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private int pannelY = 0;
	private int currentPlayer = Main.game.getCurrentPlayer();

	public BackgroundScoreGUI() {

		setLayout(null);
		backgroundPanel.setLayout(null);
		elements();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(450, 500);
		setTitle("Würfelspiel");
		setVisible(true);

	}

	private void elements() {
		if (Main.game.getMusic()) {
			Main.game.startMusic();
		}

		roundsLabel.setText("Übrige Runden: " + Main.game.getRounds());
		roundsLabel.setBounds(130, 10, 120, 30);
		add(roundsLabel);

		scrollPane.setBounds(10, 60, 400, 350);
		add(scrollPane);

		dice.setText("Würfeln");
		dice.setBounds(130, 420, 120, 30);
		dice.addActionListener(this);
		add(dice);

	}

	public void updateText() {
		roundsLabel.setText("Übrige Runden: " + Main.game.getRounds());
	}

	public void showScoresRound(int plyid) {

		RoundPanel panel = new RoundPanel(plyid); // neues Panel pro Runde
		panel.setBounds(0, pannelY, 450, 30);
		pannelY += 30; // y-Position des nächsten Runden Panels
		backgroundPanel.add(panel); // zum scrollbaren Panel hinzufügen
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dice) {
			new GameGUI(currentPlayer, this);
			currentPlayer = Main.game.getCurrentPlayer();

			this.setEnabled(false);

		}

	}

}
