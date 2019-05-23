public class FactorialTest {
	public static void main(String[] args) {
		System.out.println(Factorial.factorial(3) == 6);
		System.out.println(Factorial.factorial(1) == 1);
		System.out.println(Factorial.factorial(0) == 1);
		System.out.println(Factorial.factorial(5) == 120);
		System.out.println(Factorial.factorial(7) == 5040);
	}
}