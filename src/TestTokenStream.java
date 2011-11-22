import java.io.FileNotFoundException;
import org.junit.Test;
import junit.framework.Assert;

public class TestTokenStream {
	
	@Test
	public void testIdentifier() {
		try {
			TokenStream ts = new TokenStream("Identifier.jay");
			while (!ts.isEoF()) {
				Assert.assertEquals(TokenType.Identifier.toString(), ts.nextToken().getType());
			}
		}
		catch (FileNotFoundException e) { Assert.fail(); }
	}

	@Test
	public void testKeyword() {
		try {
			TokenStream ts = new TokenStream("Keyword.jay");
			while (!ts.isEoF()) {
				Assert.assertEquals(TokenType.Keyword.toString(), ts.nextToken().getType());
			}
		}
		catch (FileNotFoundException e) { Assert.fail(); }
	}
	
	@Test
	public void testBooleanLiteral() {
		try {
			TokenStream ts = new TokenStream("BooleanLiteral.jay");
			while (!ts.isEoF()) {
				Assert.assertEquals(TokenType.BooleanLiteral.toString(), ts.nextToken().getType());
			}
		}
		catch (FileNotFoundException e) { Assert.fail(); }
	}
	
	@Test
	public void testIntegerLiteral() {
		try {
			TokenStream ts = new TokenStream("IntegerLiteral.jay");
			while (!ts.isEoF()) {
				Assert.assertEquals(TokenType.IntegerLiteral.toString(), ts.nextToken().getType());
			}
		}
		catch (FileNotFoundException e) { Assert.fail(); }
	}
	
	@Test
	public void testOperator() {
		try {
			TokenStream ts = new TokenStream("Operator.jay");
			while (!ts.isEoF()) {
				Assert.assertEquals(TokenType.Operator.toString(), ts.nextToken().getType());
			}
		}
		catch (FileNotFoundException e) { Assert.fail(); }
	}
	
	@Test
	public void testSeparator() {
		try {
			TokenStream ts = new TokenStream("Separator.jay");
			while (!ts.isEoF()) {
				Assert.assertEquals(TokenType.Separator.toString(), ts.nextToken().getType());
			}
		}
		catch (FileNotFoundException e) { Assert.fail(); }
	}
	
	@Test
	public void testError() {
		try {
			TokenStream ts = new TokenStream("Error.jay");
			while (!ts.isEoF()) {
				Assert.assertEquals(TokenType.Other.toString(), ts.nextToken().getType());
			}
		}
		catch (FileNotFoundException e) { Assert.fail(); }
	}
}