
/**
 * @author Allon Hadaya, Keith McPherson
 */
public class ScannerDemo {

	private static String file1 = "TestDeepMath.jay";
	private static int counter = 1;

	public static void main(String args[]) {

		System.out.println(file1);
		TokenStream ts = new TokenStream(file1);
		ConcreteSyntax syn = new ConcreteSyntax(ts);
		System.out.println(syn.program().display());
		/*while (!ts.isEoF()) {
			System.out.println(ts.nextToken());
		}*/
	}
}
