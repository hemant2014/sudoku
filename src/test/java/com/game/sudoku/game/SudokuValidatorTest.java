package com.game.sudoku.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.game.sudoku.service.SudokuGenerator;
import com.game.sudoku.service.SudokuValidator;

public class SudokuValidatorTest {
	
	@Test
    void shouldDetectRowViolation() {

        SudokuGenerator generator = new SudokuGenerator();

        SudokuBoard board = new SudokuBoard(
                generator.getPuzzle(),
                generator.getSolution()
        );

        board.setCell(0, 2, 3);

        SudokuValidator validator = new SudokuValidator();

        ValidationResult result = validator.validate(board);

        Assertions.assertFalse(result.isValid());
    }

}
