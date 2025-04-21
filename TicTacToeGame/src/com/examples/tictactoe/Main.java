package com.examples.tictactoe;

import com.examples.tictactoe.models.Game;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		game.initiate();
		String winner = game.play();
		System.out.println("GAME OVER !!");
		if(winner.equals("tie")) {
			System.out.println("Game was DRAW ");
		}else {			
			System.out.println(winner+" WON the GAME");
		}
	}
}
