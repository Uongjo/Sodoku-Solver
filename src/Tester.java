
public class Tester {

	public static void main(String[] args) {
		int[][] con = new int[9][9];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				con[i][j] = i + 1;
			}
		}
		Board b = new Board(con);
		System.out.println(b);
	}

}
