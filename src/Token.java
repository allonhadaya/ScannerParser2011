/**
 * Representation of a Token that has a type and value.
 * 
 * @author Allon Hadaya, Keith McPherson
 */
public class Token {

	private String type = "Other";
	private String value = "";

	public void setType(String type) {
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
