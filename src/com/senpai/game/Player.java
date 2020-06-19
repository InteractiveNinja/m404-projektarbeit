package com.senpai.game;

public class Player {
	private int playerid = 0;
	private int playerScore = 0;
	private int[] diceScores = new int[5];
	
	public Player(int id) {
		playerid = id;

	}

	public void addScore(int score) {

		playerScore += score;

	}

	public int getScore() {

		return playerScore;
	}
	
	public int getPlayerId() {
		return playerid;
	}
	public int[] getDiceScoreArray() {
		return diceScores;
	}
	
	public void resetDiceScore() {
		diceScores = new int[5];
	}
	public void killDiceScore() {
		diceScores = null;
	}
	

}
