package com.examples.tictactoe.models;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
	Deque<Player> players;
	Board board;
	public void initiate() {
		board = new Board(3);
		players = new LinkedList<Player>();
		players.add(new Player("Player 1", Piece.X));
		players.add(new Player("Player 2", Piece.O));
	}
	public String play() {
		while(true) {
			if(!board.checkForEmptyCell()) {
				break;
			}
			Player currPlayer = players.removeFirst();
			System.out.println(currPlayer.getName()+": Enter the position of the piece "+currPlayer.getPiece()+" you want to play:");
			Scanner scanner = new Scanner(System.in);
			int x = Integer.parseInt(scanner.nextLine());
			int y = Integer.parseInt(scanner.nextLine());
			if(!board.addPiece(x, y, currPlayer.getPiece())) {
				System.out.println("Given Position is already occupied. TRY AGAIN !!");
				players.addFirst(currPlayer);
				continue;
			}
			board.print();
			if(board.checkForWinner(currPlayer, x, y)) {
				return currPlayer.getName();
			}
			players.addLast(currPlayer);
			
		}
		return "tie";
	}
	
}
