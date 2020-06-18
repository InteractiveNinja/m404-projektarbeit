package com.senpai.game;

public class Main {
	
	static GameLogic game;

	public static void main(String[] args) {
		// Einstellungen fürs Spiel einstellen
		game = new GameLogic();
		new SettingsGUI();
		
	}
	
	

}
