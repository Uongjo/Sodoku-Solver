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
	 * Constructor takes in 2D array and creates a deep copy of n to puzzle
	 * </br>pre: n must be a 9 x 9 matrix. All values must be between 0 - 9 inclusive, where 0 is an empty spot
	 * </br>post: Instantiation of puzzle 
	 * @param n - 2D array of ints
	 */
	public Board(int[][] n) {
		if(n.length != 9 && n[0].length != 9) 
			throw new IllegalArgumentException("Dimensions must be 9 x 9");
		puzzle = new int[9][9];
		//Deep copy of 2D Array
		for(int row = 0; row < n.length; row++) {
			for(int col = 0; col < n[0].length; col++) {
				puzzle[row][col] = n[row][col];
				if(puzzle[row][col] < 0 || puzzle[row][col] > 9)
					throw new IllegalArgumentException("All values must be between 0-9 inclusive");
			}
		}
	}

	/**
	 * Set Method for puzzle - sets a specified position to a value
	 * </br>pre: 0 <= row < 9, 0 <= col < 9, 1 <= val <= 9
	 * </br>post: puzzle[row][col] = val
	 * @param row - row based on 0 base indexing
	 * @param col - column based on 0 base indexing
	 * @param val - value that should be inserted at position(row, col)
	 */
	public void setVal(int row, int col, int val) {
		if(row < 0 || row >= 9 || col < 0 || col >= 9 || val < 1 || val > 9)
			throw new IllegalArgumentException("Parameters out of bounds");
		puzzle[row][col] = val;
	}

	/**
	 * Get Method for puzzle - gets a value given position
	 *</br> pre: 0 <= row < 9, 0 <= col < 9
	 * @param row - row based on 0 base indexing 
	 * @param col - column based on 0 base indexing
	 * @return Value specified at position(row, col)
	 */
	public int getVal(int row, int col) {
		if(row < 0 || row >= 9 || col < 0 || col >= 9)
			throw new IllegalArgumentException("Parameters out of bounds");
		return puzzle[row][col];
	}

	/**
	 * Checks and see if the current Sudoku puzzle is a valid set up (excluding 0's)
	 * </br>pre: none
	 * @return Returns true if the current Sudoku puzzle is a valid set up, false otherwise
	 */
	public boolean isValidSetup() {
		if(!rowCheck())
			return false;
		if(!columnCheck())
			return false;
		if(!subGridCheck())
			return false;
		return true;
	}

	/**
	 * Helper method for isValidSetup - Checks rows for non-zero duplicates
	 * </br>pre: none
	 * @return Returns true if all rows contain no duplicates, false otherwise
	 */
	private boolean rowCheck() {
		for(int[] row : puzzle) {
			for(int i = 0; i < row.length; i++) {
				if(row[i] != 0) {
					for(int j = i + 1; j < row.length; j++) {
						if(row[i] == row[j])
							return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Helper method for isValidSetup - Checks columns for non-zero duplicates
	 * </br>pre: none
	 * @return Returns true if all columns contain no duplicates, false otherwise
	 */
	private boolean columnCheck() {
		for(int col = 0; col < puzzle[0].length; col++) {

		}
		return true;
	}

	/**
	 * Helper method for isValidSetup - Checks sub divisions for non-zero duplicates
	 * </br>pre: none
	 * @return Returns true if all sub divisions contain no duplicates, false otherwise
	 */
	private boolean subGridCheck() {
		return true;
	}

	/**
	 * Method prints out the Sudoku board in a string representation
	 * </br>pre: none
	 * </br>post: none
	 * @return Returns Sudoku board in string format
	 */
	@Override
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
