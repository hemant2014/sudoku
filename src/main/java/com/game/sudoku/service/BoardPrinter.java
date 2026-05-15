package com.game.sudoku.service;

import com.game.sudoku.game.SudokuBoard;

public class BoardPrinter {
	
	public void print(SudokuBoard board) {

        int[][] grid = board.getBoard();

        System.out.println("    1 2 3 4 5 6 7 8 9");

        for (int row = 0; row < 9; row++) {

            System.out.print("  " + (char) ('A' + row) + " ");

            for (int col = 0; col < 9; col++) {

                if (grid[row][col] == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print(grid[row][col] + " ");
                }
            }

            System.out.println();
        }
    }

}
