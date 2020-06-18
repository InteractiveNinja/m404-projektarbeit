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
	
	JButton finish = new JButton();
	JCheckBox music = new JCheckBox();
	JLabel rounds_label = new JLabel();
	JTextField rounds = new JTextField();
	JLabel playercount_label = new JLabel();
	JTextField playercount = new JTextField();
	JOptionPane msg = new JOptionPane();

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
					msg.showMessageDialog(null, "Spiel wird gestartet!");
					
				} catch (Exception e2) {
					msg.showMessageDialog(null, "Bitte f�ll das 'Runden' Feld mit einer G�ltigen Zahl");
					e2.printStackTrace();
					return;
				}
				this.dispose();
			} else {
				
				msg.showMessageDialog(null, "Bitte �berlege dir was f�r Werte du eingegeben hast.");
				
			}
				
			
		}

	}
}
