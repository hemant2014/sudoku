package com.game.sudoku.service;

import java.util.HashSet;
import java.util.Set;

import com.game.sudoku.game.SudokuBoard;
import com.game.sudoku.game.ValidationResult;

public class SudokuValidator {
	
	public ValidationResult validate(SudokuBoard board) {

        int[][] grid = board.getBoard();

        for (int row = 0; row < 9; row++) {

            Set<Integer> seen = new HashSet<Integer>();

            for (int col = 0; col < 9; col++) {

                int value = grid[row][col];

                if (value == 0) {
                    continue;
                }

                if (!seen.add(value)) {
                    return new ValidationResult(false,
                            "Number " + value + " already exists in Row " +
                                    (char) ('A' + row));
                }
            }
        }

        for (int col = 0; col < 9; col++) {

            Set<Integer> seen = new HashSet<Integer>();

            for (int row = 0; row < 9; row++) {

                int value = grid[row][col];

                if (value == 0) {
                    continue;
                }

                if (!seen.add(value)) {
                    return new ValidationResult(false,
                            "Number " + value + " already exists in Column " + (col + 1));
                }
            }
        }

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {

            for (int boxCol = 0; boxCol < 9; boxCol += 3) {

                Set<Integer> seen = new HashSet<Integer>();

                for (int row = boxRow; row < boxRow + 3; row++) {

                    for (int col = boxCol; col < boxCol + 3; col++) {

                        int value = grid[row][col];

                        if (value == 0) {
                            continue;
                        }

                        if (!seen.add(value)) {
                            return new ValidationResult(false,
                                    "Number " + value + " already exists in the same 3x3 subgrid.");
                        }
                    }
                }
            }
        }

        return new ValidationResult(true, "No rule violations detected.");
    }

}
