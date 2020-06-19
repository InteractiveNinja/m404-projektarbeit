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
	private JPanel pnl1 = new JPanel(); // Panel, welches andere Panels aufnimmt
	private JScrollPane scrollpane = new JScrollPane(pnl1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	int pannel_y = 0;
	int currentplayer = Main.game.getCurrentPlayer();

	public BackgroundScoreGUI() {

		setLayout(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(450, 500);
		setTitle("Würfelspiel");
		setVisible(true);
		Elements();

	}

	void Elements() {

		rounds_label.setText("Übrige Runden: " + Main.game.getRounds());
		rounds_label.setBounds(130, 10, 120, 30);
		add(rounds_label);

		scrollpane.setBounds(10, 60, 400, 350);
		add(scrollpane);

		dice.setText("Würfeln");
		dice.setBounds(130, 420, 120, 30);
		dice.addActionListener(this);
		add(dice);

	}

	public void UpdateText() {

		/*rounds_label.setText("Übrige Runden: " + Main.game.getRounds());
		this.repaint();*/
	}

	public void showScoresRound(int plyid) {

		RoundPanel panel = new RoundPanel(plyid); // neues Panel pro Runde
		panel.setBounds(0, pannel_y, 450, 30);
		pannel_y += 30; // y-Position des nächsten Runden Panels
		pnl1.add(panel); // zum scrollbaren Panel hinzufügen
		
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
