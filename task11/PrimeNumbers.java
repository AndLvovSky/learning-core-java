class PrimeThread extends Thread {

	private int nextToCheck;

	private int step;

	public PrimeThread(int initialCheck, int step) {
		nextToCheck = initialCheck;
		this.step = step;
	}

	private static void checkPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return;
			}
		}
		System.out.println(n);
	}

	public void run() {
		while (true) {
			checkPrime(nextToCheck);
			nextToCheck += step;
		}
	}

}

public class PrimeNumbers {

	public static void findPrimes(int n) {
		PrimeThread[] t = new PrimeThread[n];
		for (int i = 0; i < n; i++) {
			t[i] = new PrimeThread(i + 2, n);
			t[i].start();
		}
	}

	public static void main(String[] args) {
		findPrimes(4);
	}

}