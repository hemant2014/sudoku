package com.game.sudoku.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandParserTest {
	
	@Test
    void shouldParseMoveCommand() {

        CommandParser parser = new CommandParser();

        ParsedCommand command = parser.parse("A3 7");

        Assertions.assertEquals(CommandType.MOVE, command.getType());
        Assertions.assertEquals(0, command.getRow());
        Assertions.assertEquals(2, command.getCol());
        Assertions.assertEquals(7, command.getValue());
    }

}
