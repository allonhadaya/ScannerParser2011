import java.io.FileNotFoundException;

/**
 * @author Allon Hadaya, Keith McPherson 
 */
public class ScannerDemo {

	private static String file1 = "testjay.txt";
	private static int counter = 1;

	public static void main(String args[]) {

		try {
			System.out.println(file1);
			TokenStream ts = new TokenStream(file1);
			while (!ts.isEoF()) {
				System.out.println(ts.nextToken());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
