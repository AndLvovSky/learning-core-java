public class SomeFunctionTest {
	public static double E = 1e-5; 

	private static void check(double a, double x, double correct) {
		double res = SomeFunction.someFunction(a, x);
		if (Double.isNaN(correct)) {
			System.out.println(Double.isNaN(res));
		} else {
			System.out.println(!Double.isNaN(res) 
				&& Math.abs(res - correct) < E);
		}
	}

	public static void main(String[] args) {
		check(3, 5, 2.71828182846);
		check(4, 5, 20.0855369232);
		check(3, 6, 2);
		check(3, 8, 2.13533528323);
		check(7, 11, 22.8928918452);
		check(10, 3, Double.NaN);
	}
}