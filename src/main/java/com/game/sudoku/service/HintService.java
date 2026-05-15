package com.game.sudoku.service;

import com.game.sudoku.game.SudokuBoard;

public class HintService {
	
	public String provideHint(SudokuBoard board) {

        int[][] current = board.getBoard();
        int[][] solution = board.getSolution();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (current[row][col] == 0) {

                    current[row][col] = solution[row][col];

                    return "Hint: Cell " +
                            (char) ('A' + row) +
                            (col + 1) +
                            " = " + solution[row][col];
                }
            }
        }

        return "No hints available.";
    }

}
