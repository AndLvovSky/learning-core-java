public class Fibonacci {
	public static int fibonacci(int n) {
		return n <= 1 ? 1 : fibonacci(n - 1) + fibonacci(n - 2);
	}
}