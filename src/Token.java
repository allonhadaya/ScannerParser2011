/**
 * Representation of a Token that has a type and value.
 * @author Allon Hadaya, Keith McPherson
 */
public class Token {

	public TokenType type = TokenType.Error; // default: Error
	public String value = ""; // default: ""

	public String toString() {
		return "Value: " + value + " " + "Type: " + type;
	}
}