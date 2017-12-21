import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner s = new Scanner(new File("test.txt"));
		Solver test = new Solver(s);
		System.out.println(test.solve());
		
	}
	

}
