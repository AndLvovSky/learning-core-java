public class PowerTest {
	public static void main(String[] args) {
		System.out.println(Power.power(2, 3) == 8);
		System.out.println(Power.power(3, 2) == 9);
		System.out.println(Power.power(15, 1) == 15);
		System.out.println(Power.power(2, 10) == 1024);
		System.out.println(Power.power(10, 5) == 100000);
	}
}