public class RomanNumeral {
	final public String string;
	final public int value;

	/**
	 * a struct to store roman numerals string from and their corrisponding value
	 * 
	 * @param str
	 * @param value
	 */
	public RomanNumeral(String str, int value) {
		this.string = str;
		this.value = value;
	}

	@Override
	public String toString() {
		return "\n" + this.string + " => " + this.value;
	}
}
