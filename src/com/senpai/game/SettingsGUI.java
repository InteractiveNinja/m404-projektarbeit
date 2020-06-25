package com.senpai.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SettingsGUI extends JFrame implements ActionListener {
	
	private JButton finish = new JButton();
	private JCheckBox music = new JCheckBox();
	private JLabel rounds_label = new JLabel();
	private JTextField rounds = new JTextField();
	private JLabel playercount_label = new JLabel();
	private JTextField playercount = new JTextField();
	public SettingsGUI() {

		setLayout(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(400, 480);
		setTitle("Einstellungen");
		setVisible(true);
		Elements();
		

	}

	private void Elements() {
		
		
		
		playercount_label.setText("Spieler anzahl:");
		playercount_label.setBounds(130,10,120,30);
		add(playercount_label);
		
		playercount.setBounds(130, 40, 120, 30);
		add(playercount);
		
		rounds_label.setText("Runden:");
		rounds_label.setBounds(130,70,120,30);
		add(rounds_label);
		
		rounds.setBounds(130, 100, 120, 30);
		add(rounds);
		
		music.setText("Musik");
		music.setBounds(130, 150, 120, 30);
		add(music);
		
		finish.setText("Starten");
		finish.setBounds(130, 200, 120, 30);
		finish.addActionListener(this);
		add(finish);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == finish) {
			if(!rounds.getText().contentEquals("") && !(Integer.parseInt(rounds.getText()) <= 1) && !(Integer.parseInt(playercount.getText()) < 1) ) {
				try {
					Main.game.setRounds(Integer.parseInt(rounds.getText()));
					Main.game.setMusic(music.isSelected());
					Main.game.createPlayers(Integer.parseInt(playercount.getText()));
					new BackgroundScoreGUI();
					JOptionPane.showMessageDialog(null, "Spiel wird gestartet!");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bitte füll das 'Runden' Feld mit einer Gültigen Zahl");
					e2.printStackTrace();
					return;
				}
				this.dispose();
			} else {
				
				JOptionPane.showMessageDialog(null, "Bitte überlege dir was für Werte du eingegeben hast.");
				
			}
				
			
		}

	}
}
