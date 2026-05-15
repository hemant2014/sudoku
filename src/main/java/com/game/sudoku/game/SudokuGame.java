package com.game.sudoku.game;

import java.util.Scanner;

import com.game.sudoku.command.CommandParser;
import com.game.sudoku.command.ParsedCommand;
import com.game.sudoku.service.BoardPrinter;
import com.game.sudoku.service.HintService;
import com.game.sudoku.service.SudokuGenerator;
import com.game.sudoku.service.SudokuValidator;

public class SudokuGame {
	
	private final SudokuBoard board;
    private final CommandParser parser;
    private final SudokuValidator validator;
    private final BoardPrinter printer;
    private final HintService hintService;

    public SudokuGame() {

        SudokuGenerator generator = new SudokuGenerator();

        this.board = new SudokuBoard(
                generator.getPuzzle(),
                generator.getSolution()
        );

        this.parser = new CommandParser();
        this.validator = new SudokuValidator();
        this.printer = new BoardPrinter();
        this.hintService = new HintService();
    }
    
    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Sudoku!\n");

        while (true) {

            printer.print(board);

            if (board.isSolved()) {
                System.out.println("You have successfully completed the Sudoku puzzle!");
                break;
            }

            System.out.println();
            System.out.print("Enter command: ");

            String input = scanner.nextLine();

            try {

                ParsedCommand command = parser.parse(input);

                processCommand(command);

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }
    }
    
    private void processCommand(ParsedCommand command) {

        switch (command.getType()) {

            case MOVE:
                board.setCell(
                        command.getRow(),
                        command.getCol(),
                        command.getValue()
                );
                System.out.println("Move accepted.");
                break;

            case CLEAR: 
                board.clearCell(
                        command.getRow(),
                        command.getCol()
                );
                System.out.println("Cell cleared.");
                break;

            case HINT:
            	System.out.println(hintService.provideHint(board));
                break;

            case CHECK:
                ValidationResult result = validator.validate(board);
                System.out.println(result.getMessage());
                break;

            case QUIT:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
                
            default: 
            	break;
        }
    }

}
