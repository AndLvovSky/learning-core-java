public class Power {
	public static int power(int x, int n) {
		return n == 0 ? 1 : x * power(x, n - 1);
	}
}