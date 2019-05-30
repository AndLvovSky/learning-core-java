import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class GenericsTest {

	public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		c.clear();
		for (T el : a) {
			c.add(el);
		}
	}

	private static void testArrToColl() {
		Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
		ArrayList<Integer> list = new ArrayList<>();
		fromArrayToCollection(arr, list);
		System.out.println(Arrays.toString(list.toArray()));
	}

	public static void main(String[] args) {
		testArrToColl();
	}

}