import java.util.ArrayList;
import java.util.Collections;

public class RomanNumeralConverter {
	public static ArrayList<RomanNumeral> validRomanNumerals;
	private static RomanNumeral[] initialRomanNumberals;

	static {
		initialRomanNumberals = new RomanNumeral[] { new RomanNumeral("I", 1), new RomanNumeral("V", 5),
				new RomanNumeral("X", 10), new RomanNumeral("L", 50), new RomanNumeral("C", 100),
				new RomanNumeral("D", 500), new RomanNumeral("M", 1000) };
		validRomanNumerals = new ArrayList<RomanNumeral>();
		populateRomanNumerals();

	}

	/**
	 * creates the sorted list of valid roman numerals including "IV" and "IX" and such
	 */
	private static void populateRomanNumerals() {
		// populate first couple by hand
		validRomanNumerals.add(initialRomanNumberals[0]); // (I, 1)
		validRomanNumerals.add(new RomanNumeral("IV", 4)); // (IV, 4)
		validRomanNumerals.add(initialRomanNumberals[1]); // (V, 5)

		// populate the rest algorithmically
		for (int k = 2; k < initialRomanNumberals.length; k++) {
			RomanNumeral current = initialRomanNumberals[k];
			RomanNumeral below = initialRomanNumberals[k - 1];
			RomanNumeral belowbelow = initialRomanNumberals[k - 2];

			// if is power of 10
			if (Integer.toString(below.value).startsWith("1")) {
				// EX IV, XL
				validRomanNumerals.add(new RomanNumeral(below.string + current.string, current.value
						- below.value));
			}

			// if is power of 10
			if (Integer.toString(belowbelow.value).startsWith("1")) {
				// EX IX, XC
				validRomanNumerals.add(new RomanNumeral(belowbelow.string + current.string, current.value
						- belowbelow.value));
			}
			validRomanNumerals.add(initialRomanNumberals[k]); // the current roman numeral
		}
		// reverses it so the highest numbers are first
		Collections.reverse(validRomanNumerals);

	}

	public RomanNumeralConverter() {
		System.out.println(validRomanNumerals);
	}

	public RomanNumeral convert(int numb) {
		int initialNumb = numb;
		StringBuilder sb = new StringBuilder();
		for (RomanNumeral romanNumeral : validRomanNumerals) {
			while (numb >= romanNumeral.value) {
				numb -= romanNumeral.value;
				sb.append(romanNumeral.string);
			}
		}
		return new RomanNumeral(sb.toString(), initialNumb);
	}
}
