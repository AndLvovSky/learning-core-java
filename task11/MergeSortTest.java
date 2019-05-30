import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {

	private static void testSmall() {
		Integer[] a = new Integer[]{
			7, 1 -6, 9, 2, 5, 4, 7, 2, 0, -4, 3
		};
		MergeSort.parallelSort(a, 2);
		System.out.println(Arrays.toString(a));
	}

	private static boolean testBig(int n, int minDiv) {
		Random rand = new Random();
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i] = rand.nextInt();
		}
		Integer[] b = a.clone();
		long start = System.currentTimeMillis();
		MergeSort.parallelSort(b, minDiv);
		long end = System.currentTimeMillis();
		System.out.println("multiple threads: " + (end - start) + " ms");
		for (int i = 0; i < n - 1; i++) {
			if (b[i] > b[i + 1]) {
				return false;
			}
		}
		b = a.clone();
		start = System.currentTimeMillis();
		MergeSort.parallelSort(b, n);
		end = System.currentTimeMillis();
		System.out.println("single thread: " + (end - start) + " ms");
		return true;
	}

	public static void main(String[] args) {
		testSmall();
		int n = 500000;
		if (args.length == 1) {
			System.out.println(testBig(n, Integer.parseInt(args[0])));
		} else {
			System.out.println(testBig(n, n / 8));
		}
	}

}
