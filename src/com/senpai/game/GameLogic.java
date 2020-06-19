package com.senpai.game;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameLogic extends JFrame {

	private JOptionPane msg = new JOptionPane();

	private int rounds = 0;
	private int max_throws = 5;
	private boolean music = false;
	private int play_rounds = 5;
	private Player[] player;
	private int player_id = 1, player_count = 0;

	public void createPlayers(int players) {
		player_count = players;
		player = new Player[players + 1];
		for (int i = 1; i < players + 1; i++) {
			player[i] = new Player(i);

		}

	}

	public int getCurrentPlayer() {
		if (player_id == player_count) {
			player_id = 1;
			return player_count;
		} else {
			int send = player_id;
			player_id++;
			return send;
		}

	}
	public void startMusic()  {
		 File f = new File("./bg.wav");
		    AudioInputStream audioIn;
			try {
				audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
				 Clip clip = AudioSystem.getClip();
				    clip.open(audioIn);
				    clip.loop(clip.LOOP_CONTINUOUSLY);
				    clip.start();
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		   
	
	}
	public Player[] getPlayerArray() {
		return player;
	}

	public int getRounds() {
		return rounds;
	}

	public int getPlayRounds() {
		return play_rounds;
	}

	public void setRounds(int _rounds) {
		rounds = _rounds;
	}

	public void setPlayedRound() {
		if (rounds == 1) {
			endGame();
		} else {
			rounds--;
		}

	}

	public void setMusic(boolean state) {
		music = state;
	}

	public boolean getMusic() {
		return music;
	}

	public int getRandom() {
		return (int) (Math.random() * 6 + 1);
	}

	public boolean isNotOdd(int i) {

		if ((i % 2) == 0) {
			return true;

		} else {
			return false;
		}

	}

	private void endGame() {
		int _id = 0;
		int _score = 0;
		for (int i = 1; i < player.length; i++) {
			if (_score < player[i].getScore()) {
				_score = player[i].getScore();
				_id = player[i].getPlayerId();
			}
		}
		msg.showMessageDialog(null, "Spieler " + _id + " hat gewonnen mit einem Score von: " + _score + "!");
		System.exit(0);
	}

}
