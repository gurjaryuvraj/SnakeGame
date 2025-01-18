import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakeGame {
    private int n; // Grid size
    private List<int[]> snake; // Snake’s body
    private int[] apple; // Apple position
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, down, left, up
    private int currentDirection = 0; // Start direction (0 = right)

    public SnakeGame(int n) {
        this.n = n;
        // Initialise Snake parameters, and initial apple position
        this.apple = new int[] {n-1, n-1};
        this.snake = new ArrayList<>();
        this.snake.add(new int[] {0, 0});


    }

    // Function to generate a random apple position
    private void generateApple() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(n) ;
            y = rand.nextInt(n) ;
        } while (isOccupiedBySnake(x, y)); // Ensure apple doesn’t spawn on the snake
        this.apple = new int[]{x, y};
    }

    // TODO: Check if a position is occupied by the snake
    private boolean isOccupiedBySnake(int x, int y) {
        // Implement this
        for( int[] i : snake){
            if( i[0] == x && i[1] == y){
                return true;
            }
        }


        return false;
    }

    // TODO: Implement the function to change the direction of the snake
    public void changeDirection(int newDirection) {
        // Ensure new direction is not directly opposite
        if (newDirection != (currentDirection + 2) % 4) {
            currentDirection = newDirection;
        }
    }

    // TODO: Implement the function to move the snake
    public boolean moveSnake() {
        // Move the snake, grow if needed, and check for collisions
        int[] first = new int[] {
            snake.get(0)[0] + directions[currentDirection][0],
            snake.get(0)[1] + directions[currentDirection][1]
        };
        snake.add(0, first);
        if (!Arrays.equals(first, apple)) {
            snake.remove(snake.size() - 1); // Remove the tail if the snake hasn't eaten the apple
        } else {
            generateApple();
        }
        
        if(isCollision(first)){
            return false;
        }
        
        return true; // Return false if collision occurs
    }

    // TODO: Implement collision detection logic
    private boolean isCollision(int[] first) {
        // Check for boundary and self-collision
        if(first[0] > this.n-1 ||  first[0] < 0){
            return true;
        }
        if(first[1] > this.n-1 ||  first[1] < 0){
            return true;
        }
        for (int i = 1; i < snake.size(); i++) {
            if (Arrays.equals(first, snake.get(i))) {
                return true; // Collision with itself
            }
        }

        return false;
    }

    // Print game state for debugging
    // TODO: Set position of snake by changing the relevant indices to S.
    public void printState() {
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) grid[i][j] = '.';
        }

        // SET POSITION OF APPLE
        grid[apple[0]][apple[1]] = 'A';

        //  set snake body
        grid[snake.get(0)[0]][snake.get(0)[1]] = 's';
        for(int i = 1; i < snake.size(); i++){
            grid[snake.get(i)[0]][snake.get(i)[1]] = 'S';
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scc = new Scanner(System.in);
        System.out.println("Enter size of Game ");
        int n = scc.nextInt();
        SnakeGame game = new SnakeGame(n);
        boolean gameState = true;
        game.printState();
        while (gameState) {
            Scanner sc = new Scanner(System.in);
            // System.out.println("Enter direction (0 = right, 1 = down, 2 = left, 3 = up, any other number exit): ");
            System.out.println("Enter direction (d = right, s = down, a = left, w = up, any other number exit): ");

            char input = sc.next().charAt(0);
            int direction = -1;

            if( input == 'w'){
                direction = 3;
            }else if( input == 'a'){
                direction = 2;
            }else if( input == 's'){
                direction = 1;
            }else if( input == 'd'){
                direction = 0;
            }else{
                direction = 5;
            }
            
            
            

            // int direction = sc.nextInt();
            if (direction < 0 || direction > 3) {
                gameState = false;
            }
            game.changeDirection(direction); // Change direction to down
            if (!game.moveSnake()) {
                System.out.println("Illegal move");
                gameState = false;
            }
            game.printState();
        }
    }
}
