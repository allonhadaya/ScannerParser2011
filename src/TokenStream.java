import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementation of the Scanner for JAY
 * 
 * @author Allon Hadaya, Keith McPherson
 */
public class TokenStream {

	private BufferedReader input;
	private boolean isEoF = false;
	private char nextChar = ' ';

	/**
	 * Construct a new TokenStream that reads from fileName
	 * 
	 * @param fileName The file to be scanned
	 * @throws FileNotFoundException The file to be scanned could not be found
	 */
	public TokenStream(String fileName) throws FileNotFoundException {
		input = new BufferedReader(new FileReader(fileName));
	}

	/**
	 * @return Returns the next token type and value
	 */
	public Token nextToken() {

		skipWhiteSpace();

		Token t = new Token();

		// comment or /
		if (nextChar == '/') {
			t.value += nextChar;
			readChar();
			if (nextChar == '/') {
				while (!isEndOfLine(nextChar)) {
					readChar();
				}
				readChar();
				t = nextToken();
			} else {
				t.type = TokenType.Operator;
			}
			return t;
		}

		// &&
		if (nextChar == '&') {
			t.value += nextChar;
			readChar();
			if (nextChar == '&') {
				t.type = TokenType.Operator;
				t.value += nextChar;
				readChar();
			} else {
				collectErrorToken(t);
			}
			return t;
		}

		// ||
		if (nextChar == '|') {
			t.value += nextChar;
			readChar();
			if (nextChar == '|') {
				t.type = TokenType.Operator;
				t.value += nextChar;
				readChar();
			} else {
				collectErrorToken(t);
			}
			return t;
		}

		// <, >, !, =, <=, >=, !=, ==, +, -, *, or !
		if (isOperator(nextChar)) {
			t.type = TokenType.Operator;
			t.value += nextChar;
			switch (nextChar) {
			case '<':
			case '>':
			case '!':
			case '=':
				readChar();
				if (nextChar == '=') { // matches <=, >=, !=, ==
					t.value += nextChar;
					readChar();
				}
				break;
			default: // other 1 character operators
				readChar();
				break;
			}
			return t;
		}

		// separator
		if (isSeparator(nextChar)) {
			t.type = TokenType.Separator;
			t.value += nextChar;
			readChar();
			return t;
		}

		// identifier, keyword, or literal.
		if (isLetter(nextChar)) {
			t.type = TokenType.Identifier;

			while ((isLetter(nextChar) || isDigit(nextChar))) {
				t.value += nextChar;
				readChar();
			}

			if (isKeyword(t.value)) {
				t.type = TokenType.Keyword;
			}
			if (isBooleanLiteral(t.value)) {
				t.type = TokenType.BooleanLiteral;
			}
			if (!isEndOfToken()) {
				collectErrorToken(t);
			}
			return t;
		}

		// IntegerLiteral
		if (isDigit(nextChar)) {
			t.type = TokenType.IntegerLiteral;

			while (isDigit(nextChar)) {
				t.value += nextChar;
				readChar();
			}

			if (!isEndOfToken()) {
				collectErrorToken(t);
			}

			return t;
		}
		
		// Error
		collectErrorToken(t);

		return t;
	}

	/**
	 * Sets nextChar to the next character in input.
	 */
	private void readChar() {
		int next = 0;
		if (!isEoF) {
			try {
				next = input.read();
			} catch (IOException e) {
				System.exit(-1);
			}
			if (next == -1) {
				isEoF = true;
				next = 0;
			}
		}
		nextChar = (char) next;
	}

	private boolean isKeyword(String s) {
		return s.matches("boolean|else|if|int|main|void|while");
	}

	private boolean isBooleanLiteral(String s) {
		return s.matches("true|false");
	}

	private boolean isSeparator(char c) {
		return String.valueOf(c).matches("[(){};,]");
	}

	private boolean isOperator(char c) {
		return String.valueOf(c).matches("(=|\\+|-|\\*|/|<|>|!)");
	}

	private boolean isLetter(char c) {
		return String.valueOf(c).matches("[a-zA-Z]");
	}

	private boolean isDigit(char c) {
		return String.valueOf(c).matches("[0-9]");
	}

	private boolean isEndOfToken() {
		return (isWhiteSpace(nextChar) || isOperator(nextChar) || isSeparator(nextChar) || isEoF);
	}

	private boolean isWhiteSpace(char c) {
		return (c == ' ' || c == '\t' || c == '\r' || c == '\n' || c == '\f');
	}

	private boolean isEndOfLine(char c) {
		return (c == '\r' || c == '\n' || c == '\f');
	}

	public boolean isEoF() {
		return isEoF;
	}

	private void skipWhiteSpace() {
		while (!isEoF && isWhiteSpace(nextChar)) {
			readChar();
		}
	}

	private void collectErrorToken(Token t) {
		while (!isEndOfToken()) {
			t.value += nextChar;
			readChar();
		}
	}
}
