package com.senpai.game;

public class Main {
	
	static GameLogic game;

	public static void main(String[] args) {
		// Einstellungen f�rs Spiel einstellen
		game = new GameLogic();
		new SettingsGUI();
		
	}
	
	

}
