/**
 * Representation of a Token that has a type and value.
 * 
 * @author Allon Hadaya, Keith McPherson
 */
public class Token {

	private TokenType type = TokenType.Other; // default: Other
	private String value = ""; // default: ""

	public void setType(String type) {
		this.type = TokenType.valueOf(type);
	}
	
	public void setType(TokenType type) {
		this.type = type;
	}

	public String getType() {
		return type.toString();
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public String toString() {
		return "Value: " + value + " " + "Type: " + type;
	}
}
