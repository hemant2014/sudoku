package com.game.sudoku.command;

import com.game.sudoku.exception.InvalidCommandException;

public class CommandParser {
	
	public ParsedCommand parse(String input) {

        input = input.trim();

        if (input.equalsIgnoreCase("hint")) {
            return new ParsedCommand(CommandType.HINT, -1, -1, -1);
        }

        if (input.equalsIgnoreCase("check")) {
            return new ParsedCommand(CommandType.CHECK, -1, -1, -1);
        }

        if (input.equalsIgnoreCase("quit")) {
            return new ParsedCommand(CommandType.QUIT, -1, -1, -1);
        }

        String[] parts = input.split("\\s+");

        if (parts.length != 2) {
            throw new InvalidCommandException("Invalid command.");
        }

        String cell = parts[0].toUpperCase();

        int row = cell.charAt(0) - 'A';
        int col = Character.getNumericValue(cell.charAt(1)) - 1;

        if (parts[1].equalsIgnoreCase("clear")) {
            return new ParsedCommand(CommandType.CLEAR, row, col, 0);
        }

        int value = Integer.parseInt(parts[1]);

        return new ParsedCommand(CommandType.MOVE, row, col, value);
    }

}
