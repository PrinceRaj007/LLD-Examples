package com.examples.tictactoe.models;

public class Board {
	int size;
	Piece[][] board;
	public Board(int size) {
		this.size = size;
		board = new Piece[size][size];
	}
	public boolean addPiece(int x,int y,Piece piece) {
		if(board[x][y]!=null) {
			return false;
		}
		board[x][y]=piece;
		return true;
	}
	public void print() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==null) {
					System.out.print("   ");
				}else {
					System.out.print(" "+board[i][j]+" ");
				}
				System.out.print("|");
				System.out.print("|");
			}
			System.out.println();
		}
	}
	public boolean checkForEmptyCell() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==null) {
					return true;					
				}
			}
		}
		return false;
	}
	public boolean checkForWinner(Player player,int row,int col) {
		boolean rowWinner=true,colWinner=true,diagWinner=true,antiDiagWinner=true;
		for(int i=0;i<size;i++) {
			if(board[row][i]!=player.getPiece()) {
				rowWinner=false;break;
			}
		}
		for(int i=0;i<size;i++) {
			if(board[i][col]!=player.getPiece()) {
				colWinner=false;break;
			}
		}
		for(int i=0;i<size;i++) {
			if(board[i][i]!=player.getPiece()) {
				diagWinner=false;break;
			}
		}
		for(int i=0,j=size-1;i<size;i++,j--) {
			if(board[i][j]!=player.getPiece()) {
				antiDiagWinner=false;break;
			}
		}
		return rowWinner || colWinner || diagWinner|| antiDiagWinner;
	}
}
