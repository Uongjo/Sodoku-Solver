import java.util.Arrays;

/**
 * A class that represents a Sudoku Board.
 *
 * @author Joel Uong
 * @version 1.0
 */

public class Board {
	//2D Array as internal storage container
	int[][] puzzle;
	
	/**
	 * Default Constructor
	 * </br>pre: None
	 * </br>post: Instantiation of puzzle
	 */
	public Board() {
		puzzle = new int[9][9];
	}
	
	/**
	 * Constructor takes in 2D array and creates a deep copy
	 * @param n: 2D array of ints
	 * </br>pre: n must be a 9 x 9 matrix. All values must be between 0 - 9 inclusive, where 0 is an empty spot
	 * </br>post: Instantiation of puzzle 
	 */
	public Board(int[][] n) {
		if(n.length != 9 && n[0].length != 9) 
			throw new IllegalArgumentException("Dimensions must be 9 x 9");
		puzzle = new int[9][9];
		//Deep copy of 2D Array
		for(int row = 0; row < n.length; row++) {
			for(int col = 0; col < n[0].length; col++) {
				puzzle[row][col] = n[row][col];
			}
		}
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 */
	public void setNum(int row, int col) {
		
	}
	
	//Checks and sees if the current puzzle is a valid Sodoku solution
	//pre: None
	//post: returns true if current puzzle is valid, false otherwise
	public boolean isValidSetup() {
		for(int row = 0; row < puzzle.length; row++) {
			
		}
		return true;
	}
	
	//Method prints out board string representation
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-------------------------\n");
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				if(j == 1) {
					sb.append("| ");
				}
				sb.append(puzzle[i - 1][j - 1]);
				sb.append(" ");
				if(j % 3 == 0) 
					sb.append("| ");
			}
			sb.append("\n");
			if(i % 3 == 0) 
				sb.append("-------------------------\n");	
		}
		return sb.toString();
	}
}
