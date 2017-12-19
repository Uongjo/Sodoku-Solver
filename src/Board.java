import java.util.Arrays;

public class Board {
	int[][] puzzle;
	int dimensions;
	
	//Standard 9 x 9 Sodoku format
	public Board() {
		puzzle = new int[9][9];
	}
	
	//Constructor: Instantiation of instance variables
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
	
	//Method checks and sees if the current puzzle is a valid Sodoku solution
	public boolean isValidSetup() {
		for(int row = 0; row < puzzle.length; row++) {
			
		}
		return true;
	}
	
	//Method prints out board string format
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
