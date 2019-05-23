public class Reverse {
	public static int reverse(int n) {
		int r = 0;
		while (n != 0) {
			r *= 10;
			r += n % 10;
			n /= 10;
		}
		return r;
	}
}