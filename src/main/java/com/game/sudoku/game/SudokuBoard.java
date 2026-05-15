package com.game.sudoku.game;

import com.game.sudoku.exception.InvalidMoveException;

public class SudokuBoard {
	
	private final int[][] board;
    private final int[][] solution;
    private final boolean[][] fixed;

    public SudokuBoard(int[][] puzzle, int[][] solution) {

        this.board = new int[9][9];
        this.solution = solution;
        this.fixed = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = puzzle[i][j];
                fixed[i][j] = puzzle[i][j] != 0;
            }
        }
    }

    public int getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, int value) {

        if (fixed[row][col]) {
            throw new InvalidMoveException("Cell is pre-filled.");
        }

        if (value < 1 || value > 9) {
            throw new InvalidMoveException("Value must be between 1 and 9.");
        }

        board[row][col] = value;
    }

    public void clearCell(int row, int col) {

        if (fixed[row][col]) {
            throw new InvalidMoveException("Cannot clear pre-filled cell.");
        }

        board[row][col] = 0;
    }

    public boolean isFixed(int row, int col) {
        return fixed[row][col];
    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] getSolution() {
        return solution;
    }

    public boolean isSolved() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != solution[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

}
