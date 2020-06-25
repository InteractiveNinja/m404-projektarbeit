package com.senpai.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class BackgroundScoreGUI extends JFrame implements ActionListener {
	
	private GameLogic logic = Main.game;

	private JButton dice = new JButton();
	private JLabel roundsLabel = new JLabel();
	private JPanel backgroundPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane(backgroundPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private int pannelY = 0;
	private int currentPlayer = logic.getCurrentPlayer();
	private GameGUI gui;
	private RoundPanel panel;

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
		if (logic.getMusic()) {
			logic.startMusic();
		}

		roundsLabel.setText("Übrige Runden: " + logic.getRounds());
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
		roundsLabel.setText("Übrige Runden: " + logic.getRounds());
	}

	public void showScoresRound(int playerId) {

		panel = new RoundPanel(playerId); // neues Panel pro Runde
		panel.setBounds(0, pannelY, 450, 30);
		pannelY += 30; // y-Position des nächsten Runden Panels
		backgroundPanel.add(panel); // zum scrollbaren Panel hinzufügen
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dice) {
			gui = new GameGUI(currentPlayer, this);
			currentPlayer = logic.getCurrentPlayer();

			this.setEnabled(false);

		}

	}

}
