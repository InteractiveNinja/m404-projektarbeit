package com.senpai.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class BackgroundScoreGUI extends JFrame implements ActionListener {

	JButton dice = new JButton();
	JLabel rounds_label = new JLabel();
	JOptionPane msg = new JOptionPane();
	private JPanel pnl1 = new JPanel();
	private JScrollPane scrollpane = new JScrollPane(pnl1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	int pannel_y = 0;
	int currentplayer = Main.game.getCurrentPlayer();

	public BackgroundScoreGUI() {

		setLayout(null);
		pnl1.setLayout(null);
		Elements();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(450, 500);
		setTitle("W�rfelspiel");
		setVisible(true);

	}

	void Elements() {
		if (Main.game.getMusic()) {
			Main.game.startMusic();
		}

		rounds_label.setText("�brige Runden: " + Main.game.getRounds());
		rounds_label.setBounds(130, 10, 120, 30);
		add(rounds_label);

		scrollpane.setBounds(10, 60, 400, 350);
		add(scrollpane);

		dice.setText("W�rfeln");
		dice.setBounds(130, 420, 120, 30);
		dice.addActionListener(this);
		add(dice);

	}

	public void UpdateText() {
		rounds_label.setText("�brige Runden: " + Main.game.getRounds());
	}

	public void showScoresRound(int plyid) {

		RoundPanel panel = new RoundPanel(plyid); // neues Panel pro Runde
		panel.setBounds(0, pannel_y, 450, 30);
		pannel_y += 30; // y-Position des n�chsten Runden Panels
		pnl1.add(panel); // zum scrollbaren Panel hinzuf�gen
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dice) {
			GameGUI window = new GameGUI(currentplayer, this);
			currentplayer = Main.game.getCurrentPlayer();

			this.setEnabled(false);

		}

	}

}
