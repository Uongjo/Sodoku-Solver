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
	int dimension;

	/**
	 * Default Constructor - standard 9 x 9 Sudoku board
	 * </br>pre: None
	 * </br>post: Instantiation of puzzle as a 9 x 9 board
	 */
	public Board() {
		dimension = 9;
		puzzle = new int[dimension][dimension];
	}

	/**
	 * Constructor takes in 2D array and creates a deep copy of n to puzzle
	 * </br>pre: dimension = n.length = n[0].length. Dimension must be a perfect square. 
	 * </br>All values in n must be between 0 - dimension inclusive, where 0 is an empty spot
	 * </br>post: puzzle[row][col] == n[row][col] for all values of row and col
	 * @param n - 2D array of ints
	 */
	public Board(int[][] n) {
		dimension = n.length;
		if(n.length != n[0].length) 
			throw new IllegalArgumentException("Parameter must be a square 2D array");
		if(!isPerfectSquare(dimension))
			throw new IllegalArgumentException("Parameter must have dimensions of a perfect square");
		puzzle = new int[dimension][dimension];
		//Deep copy of 2D Array
		for(int row = 0; row < n.length; row++) {
			for(int col = 0; col < n[0].length; col++) {
				puzzle[row][col] = n[row][col];
				if(puzzle[row][col] < 0 || puzzle[row][col] > dimension)
					throw new IllegalArgumentException("All values must be between 0-dimension inclusive");
			}
		}
	}
	
	/**
	 * Helper method for constructor - checks if dimension is a perfect square
	 * </br>pre: none
	 * @param num - Parameter being checked to be perfect square
	 * @return Returns true if num is a perfect square, false otherwise
	 */
	private boolean isPerfectSquare(int num) {
		int sqRt = (int)Math.sqrt(num);
		if(sqRt * sqRt == num)
			return true;
		return false;
	}

	/**
	 * Set Method for puzzle - sets a specified position to a value
	 * </br>pre: 0 <= row < dimension, 0 <= col < dimension, 0 <= val <= dimension
	 * </br>post: puzzle[row][col] = val
	 * @param row - row based on 0 base indexing
	 * @param col - column based on 0 base indexing
	 * @param val - value that should be inserted at position(row, col)
	 */
	public void setVal(int row, int col, int val) {
		if(row < 0 || row >= dimension || col < 0 || col >= dimension || val < 0 || val > dimension)
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
		if(row < 0 || row >= dimension || col < 0 || col >= dimension)
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
			for(int i = 0; i < puzzle[0].length; i++) {
				if(puzzle[i][col] != 0) {
					for(int j = i + 1; j < puzzle[0].length; j++) {
						if(puzzle[i][col] == puzzle[j][col])
							return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Helper method for isValidSetup - Checks sub divisions for non-zero duplicates
	 * </br>pre: none
	 * @return Returns true if all sub divisions contain no duplicates, false otherwise
	 */
	private boolean subGridCheck() {
		int sqRt = (int)Math.sqrt(dimension);
		for(int i = 0; i < sqRt; i++) {
			int increment = i * sqRt;
			for(int val = 1; val <= dimension; val++) {
				int valCounter = 0;
				for(int row = 0 + increment; row < sqRt + increment; row++) {
					for(int col = 0 + increment; col < sqRt + increment; col++) {
						if(puzzle[row][col] == val)
							valCounter++;
					}
				}
				if(valCounter >= 2)
					return false;
			}
		}
		return true;
	}

	/**
	 * Method prints out the Sudoku board in a string representation
	 * </br>pre: none
	 * @return Returns Sudoku board in string format
	 */
	@Override
	//UPDATE METHOD FOR BIGGER BOARDS
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int sqRt = (int)Math.sqrt(dimension);
		sb.append("-------------------------\n");
		for(int i = 1; i <= dimension; i++) {
			for(int j = 1; j <= dimension; j++) {
				if(j == 1) {
					sb.append("| ");
				}
				sb.append(puzzle[i - 1][j - 1]);
				sb.append(" ");
				if(j % sqRt == 0) 
					sb.append("| ");
			}
			sb.append("\n");
			if(i % sqRt == 0) 
				sb.append("-------------------------\n");	
		}
		return sb.toString();
	}
}
