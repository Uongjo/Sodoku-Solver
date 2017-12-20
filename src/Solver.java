import java.util.Scanner;
/**
 * Main class that solves Sudoku puzzles.
 *
 * @author Joel Uong
 * @version 1.0
 */
public class Solver {
	
	Board board;
	
	/**
	 * Default Constructor
	 * </br>pre: none
	 */
	public Solver() {
		board = new Board();
	}
	
	/**
	 * Constructor takes in 2D array and creates a board out of 2D array
	 * </br>pre: Board class takes care of pre-conditions
	 * </br>post: board.getVal(row, col) = n[row][col] for all possible row and col
	 * @param n - 2D array of ints
	 */
	public Solver(int[][] n) {
		board = new Board(n);
	}
	
	/**
	 * Constructor taking in Scanner variable
	 * </br>pre: Sudoku puzzle in text file must follow standard Sudoku format and be in following format:
	 * </br>First number in the text file should be the dimensions of the puzzle, ie: 9
	 * </br>One the next line should be the puzzle. Each number should be separated by a space, and each row should be on a new line
	 * </br>post: board is instantiated   
	 * @param s - Scanner variable connected to text file with Sudoku puzzle
	 */
	public Solver(Scanner s) {
		int dimension = s.nextInt();
		int[][] con = new int[dimension][dimension];
		for(int row = 0; row < dimension; row++) {
			for(int col = 0; col < dimension; col++) {
				con[row][col] = s.nextInt();
			}
		}
		board = new Board(con);
	}
}
