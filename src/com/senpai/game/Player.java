package com.senpai.game;

public class Player {
	private int playerid = 0;
	private int playerScore = 0;

	
	public Player(int id) {
		playerid = id;

	}

	public void addScore(int score) {

		playerScore = +score;

	}

	public int getScore() {

		return playerScore;
	}
	
	public int getPlayerId() {
		return playerid;
	}

}
