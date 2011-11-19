/**
 * @author Christelle
 * 
 */
public class ScannerDemo {

	private static String file1 = "testjay.txt";
	private static int counter = 1;

	public static void main(String args[]) {

		TokenStream ts = new TokenStream(file1);

		System.out.println(file1);

		while (!ts.isEndofFile()) {
			Token t = ts.nextToken();
			System.out.println(t);
			}
	}
}
