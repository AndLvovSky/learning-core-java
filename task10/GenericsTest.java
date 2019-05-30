import java.util.*;

public class GenericsTest {

	public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		c.clear();
		for (T el : a) {
			c.add(el);
		}
	}

	public static <T> void copyAll(
		Collection<? extends T> from, Collection<? super T> to) {
		to.clear();
		Iterator<? extends T> it = from.iterator();
		while (it.hasNext()) {
			T cur = it.next();
			to.add(cur);
		}
	}

	private static void testArrToColl() {
		Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
		ArrayList<Integer> list = new ArrayList<>();
		fromArrayToCollection(arr, list);
		System.out.println(Arrays.toString(list.toArray()));
	}

	private static class A {
		public int n;
		public A(int n) {
			this.n = n;
		}
		public String toString() {
			return String.valueOf(n);
		}
	}
	private static class B extends A {
		public B(int n) {
			super(n);
		}
	}

	private static void testCopyAll() {
		ArrayList<B> list1 = new ArrayList<>();
		list1.add(new B(1));
		list1.add(new B(2));
		list1.add(new B(3));
		ArrayList<A> list2 = new ArrayList<>();
		copyAll(list1, list2);
		System.out.println(Arrays.toString(list2.toArray()));
	}

	public static void main(String[] args) {
		testArrToColl();
		testCopyAll();
	}

}