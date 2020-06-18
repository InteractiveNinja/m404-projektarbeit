package com.senpai.game;

public class GameLogic {

	private int rounds = 0;
	private int max_throws = 5;
	private boolean music = false;
	private int play_rounds = 5;
	private Player[] player;
	private int player_id = 0, player_count;

	public void createPlayers(int players) {
		player_count = players;
		player = new Player[players + 1];
		for (int i = 1; i < players + 1; i++) {
			player[i] = new Player(i);

		}

	}

	public int getCurrentPlayer() {
		int local_player_id = player_id;
		if (local_player_id == player_count) {
			player_id = 1;
			setPlayedRound();
			return local_player_id;
		} else {
			player_id++;
			return player_id;
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
			System.out.println("Ende");
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

	int getRandom() {

		int random = (int) (Math.random() * 6 + 1);

		return random;
	}

	boolean isNotOdd(int i) {

		if ((i % 2) == 0) {
			return true;

		} else {
			return false;
		}

	}

}
