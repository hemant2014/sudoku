# Sudoku Game

A Java-based Sudoku game implementation featuring puzzle generation, validation, and interactive gameplay with hints.

## Overview

This project implements a complete Sudoku game engine with the following capabilities:
- **Puzzle Generation**: Automatically generates valid Sudoku puzzles
- **Game Play**: Interactive command-driven gameplay with move validation
- **Validation**: Comprehensive Sudoku rule validation
- **Hints**: Hint system to assist players
- **Board Display**: Clean console-based board visualization

## Project Structure

```
src/
├── main/java/com/game/sudoku/
│   ├── Application.java              # Entry point
│   ├── game/
│   │   ├── SudokuGame.java          # Main game logic and flow control
│   │   ├── SudokuBoard.java         # Board representation and state
│   │   └── ValidationResult.java    # Result object for validation checks
│   ├── service/
│   │   ├── SudokuGenerator.java     # Puzzle generation logic
│   │   ├── SudokuValidator.java     # Sudoku rule validation
│   │   ├── HintService.java         # Hint suggestion system
│   │   └── BoardPrinter.java        # Board formatting and display
│   ├── command/                      # Command pattern implementations
│   └── exception/                    # Custom exception classes
└── test/java/com/game/sudoku/
    ├── game/                         # Game logic tests
    └── command/                      # Command tests
```

## Key Components

### Core Game Logic
- **SudokuGame.java**: Orchestrates the game flow, handles user input, and manages game state
- **SudokuBoard.java**: Represents the 9x9 Sudoku board with getter/setter methods for cells

### Services
- **SudokuGenerator.java**: Generates valid, solvable Sudoku puzzles
- **SudokuValidator.java**: Validates moves against Sudoku rules (rows, columns, 3x3 boxes)
- **HintService.java**: Provides hints by suggesting valid moves
- **BoardPrinter.java**: Formats and displays the board in the console

### Game Architecture
- **Application.java**: Entry point that initializes and starts the game
- **ValidationResult.java**: Encapsulates validation results with error messages

## Technology Stack

- **Language**: Java 8
- **Build Tool**: Maven
- **Testing**: JUnit 5
- **Project Structure**: Standard Maven layout

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven 3.6+

### Installation

1. Clone the repository:
```bash
git clone https://github.com/hemant2014/sudoku.git
cd sudoku
```

2. Build the project:
```bash
mvn clean install
```

### Running the Game

```bash
mvn exec:java -Dexec.mainClass="com.game.sudoku.Application"
```

Or compile and run directly:
```bash
javac -d target/classes src/main/java/com/game/sudoku/**/*.java
java -cp target/classes com.game.sudoku.Application
```

## Game Features

- **Play Sudoku**: Solve Sudoku puzzles with interactive moves
- **Validate Moves**: Real-time validation of player moves
- **Get Hints**: Request hints when stuck
- **Board Display**: Clear, formatted board visualization

## Running Tests

```bash
mvn test
```

This will run all unit tests in the `src/test/java` directory using JUnit 5.

## Project Dependencies

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

## Maven Build Plugins

- **Maven Surefire Plugin** (3.2.5): For running tests

## Development

### Building the Project
```bash
mvn clean package
```

### Running with Different Maven Goals
```bash
mvn compile          # Compile source code
mvn test             # Run tests
mvn clean            # Clean build artifacts
mvn verify           # Verify project
```

## License

This project is currently unlicensed. Consider adding a license (MIT, Apache 2.0, etc.) for better clarity on usage rights.

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for bugs and feature requests.

## Author

**hemant2014**

## Future Enhancements

- GUI implementation (Swing/JavaFX)
- Difficulty levels (Easy, Medium, Hard)
- Puzzle history and statistics
- Performance optimization for generator
- Multiplayer support
- Persistence (save/load games)

---

**Status**: Active Development
