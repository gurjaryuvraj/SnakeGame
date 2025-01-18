# Snake Game

A console-based implementation of the classic Snake game in Java. The game features a dynamic grid, random apple generation, and collision detection. Players control the snake using keyboard inputs to collect apples and grow longer while avoiding collisions with walls or the snake's own body.

## Features
- **Dynamic Grid Size**: Users can specify the size of the grid.
- **Random Apple Placement**: Apples are placed randomly on the grid, avoiding the snake's body.
- **Collision Detection**: The game ends if the snake collides with the grid boundaries or itself.
- **Keyboard Controls**: Use `W`, `A`, `S`, and `D` keys to control the snake's direction.

## Running the Application
Clone the repository:
```bash
git clone https://github.com/gurjaryuvraj/SnakeGame.git
```
Navigate to the source file directory:
```bash
cd Source_File
```
Compile the `SnakeGame.java` file:
```bash
javac SnakeGame.java
```
Run the program:
```bash
java SnakeGame
```
Enter the grid size and control the snake using `W`, `A`, `S`, and `D` keys as described above.

## Code Overview

### Classes and Methods
- **`SnakeGame`**: Main class containing all the logic for the game.
  - `generateApple()`: Generates a random position for the apple.
  - `isOccupiedBySnake(x, y)`: Checks if a position is occupied by the snake.
  - `changeDirection(newDirection)`: Updates the snake's direction.
  - `moveSnake()`: Moves the snake in the current direction and checks for collisions.
  - `isCollision(position)`: Checks for collisions with walls or the snake's body.
  - `printState()`: Prints the current state of the game grid.

### Controls
- Directions are controlled by:
  - `W`: Up
  - `A`: Left
  - `S`: Down
  - `D`: Right
- Any other key exits the game.

## Example Output
```
Enter size of Game
5
s . . . .
. . . . .
. . . . .
. . . . .
. . . . A

Enter direction (d = right, s = down, a = left, w = up, any other number exit):
d
. s . . .
. . . . .
. . . . .
. . . . .
. . . . A
```

## Requirements
- Java 8 or higher

## Future Improvements
- Add scoring functionality.
- Implement levels with increasing difficulty.
- Add support for diagonal movements.

## Author
Yuvraj Gurjar

## License
This project is open-source and available under the [GNU GENERAL PUBLIC LICENSE](LICENSE).
