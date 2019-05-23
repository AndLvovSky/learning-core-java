/**
 * SomeFunction is a class, that contain 
 * a method for calculating 'some function'
 * 
 * @author Viktor Ilvovskyi
 */
public class SomeFunction {
	/**
	 * Returns result of computing 'some function'.
	 * <p>
	 * 'Some function' is following function of two arguments a and x:
	 * y=log2(x-4)+exp(2a-x).
	 * Special cases:
	 * <ul>
	 * 	<li>If x less than 4, then the result is NaN</li>
	 * </ul>
	 * 
	 * @param a first argument a
	 * @param x second argument x
	 * @return the result of computing 'some function'
	 */
	public static double someFunction(double a, double x) {
		if (x < 4) {
			return Double.NaN;
		}
		return Math.log(x - 4) / Math.log(2) + Math.exp(2 * a - x);
	}
}