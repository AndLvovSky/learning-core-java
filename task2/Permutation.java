public class Permutation {
	private static int getNumber(int it, int pos, int n) {
		if (pos == 0) {
			return it / Factorial.factorial(n - 1);
		}
		int res = it;
		for (int i = 0; i < pos; i++) {
			res %= Factorial.factorial(n - i - 1);
		}
		res /= Factorial.factorial(n - pos - 1);
		int prev = -1;
		if (res != 0) {
			prev = getNumber(it - Factorial.factorial(n - pos - 1), pos, n);
		}
		for (int i = res; i < n; i++) {
			boolean used = false;
			for (int j = 0; j < pos; j++) {
				if (getNumber(it, j, n) == i) {
					used = true;
					break;
				}
			}
			if (!used && i != prev) {
				return i;
			}
		}
		return 0;
	}

	public static void printAllPermutations(int n) {
		for (int i = 0; i < Factorial.factorial(n); i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(getNumber(i, j, n) + 1 +  " ");
			}
			System.out.println();
		}
	}
}