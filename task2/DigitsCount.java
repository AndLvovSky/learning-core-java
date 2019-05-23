public class DigitsCount {
	public static int digitsCount(int n) {
		int c = 0;
		do {
			n /= 10;
			c++;
		} while (n != 0);
		return c;
	}
}