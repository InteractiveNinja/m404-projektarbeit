package com.senpai.game;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameLogic extends JFrame {

	private int rounds = 0;
	private boolean music = false;
	private int playRounds = 5;
	private Player[] player;
	private int playerId = 1, playerCount = 0;

	public void createPlayers(int players) {
		playerCount = players;
		player = new Player[players + 1];
		for (int i = 1; i < players + 1; i++) {
			player[i] = new Player(i);

		}

	}

	public int getCurrentPlayer() {
		if (playerId == playerCount) {
			playerId = 1;
			return playerCount;
		} else {
			int send = playerId;
			playerId++;
			return send;
		}

	}
	public void startMusic()  {
		    AudioInputStream audioIn;
			try {
				audioIn = AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResource("bg.wav"));
				 Clip clip = AudioSystem.getClip();
				    clip.open(audioIn);
				    clip.loop(Clip.LOOP_CONTINUOUSLY);
				    clip.start();
			} catch (UnsupportedAudioFileException | IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
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
		return playRounds;
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
		if(!(_score < 1)) {
			JOptionPane.showMessageDialog(null, "Spieler " + _id + " hat gewonnen mit einem Score von: " + _score + "!");
			
		}else {
			JOptionPane.showMessageDialog(null, "Es gibt keine Gewinner");
				
		}
		System.exit(0);
	}

}
