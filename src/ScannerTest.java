import org.junit.Test;

import junit.framework.TestCase;


public class ScannerTest extends TestCase {

	@Test
	void testCases(){
		TokenStream ts = new TokenStream("identifiers.txt");
		//while (!(ts.isEndofFile()))
		System.out.println("test");
		System.out.println(ts.nextToken().getType());
			//assertTrue(ts.nextToken().getType().equals( "Identifier"));
	}

}
