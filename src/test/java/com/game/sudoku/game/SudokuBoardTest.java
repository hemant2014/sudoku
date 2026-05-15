package com.game.sudoku.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.game.sudoku.exception.InvalidMoveException;
import com.game.sudoku.service.SudokuGenerator;

public class SudokuBoardTest {
	
	@Test
    void shouldNotAllowModificationOfFixedCell() {

        SudokuGenerator generator = new SudokuGenerator();

        final SudokuBoard board = new SudokuBoard(
                generator.getPuzzle(),
                generator.getSolution()
        );

        Assertions.assertThrows(
                InvalidMoveException.class,
                () -> board.setCell(0, 0, 7)
        );
    }

}
