package com.game.sudoku.command;

public class ParsedCommand {
	
	private final CommandType type;
    private final int row;
    private final int col;
    private final int value;

    public ParsedCommand(CommandType type, int row, int col, int value) {
        this.type = type;
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public CommandType getType() {
        return type;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }

}
