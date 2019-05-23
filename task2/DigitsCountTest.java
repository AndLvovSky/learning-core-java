public class DigitsCountTest {
	public static void main(String[] args) {
		System.out.println(DigitsCount.digitsCount(123) == 3);
		System.out.println(DigitsCount.digitsCount(5) == 1);
		System.out.println(DigitsCount.digitsCount(0) == 1);
		System.out.println(DigitsCount.digitsCount(45345) == 5);
		System.out.println(DigitsCount.digitsCount(9231233) == 7);
	}
}