import java.util.Comparator;

public class MyCollections {
	private static void bubbleSort(MyList list, Comparator comp) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				Comparable a = (Comparable)list.get(j);
				Comparable b = (Comparable)list.get(j + 1);
				int compRes;
				if (comp == null) {
					compRes = a.compareTo(b);
				} else {
					compRes = comp.compare(a, b);
				}
				if (compRes > 0) {
					swap(list, j, j + 1);
				}
			}
		}
	}

	private static void qSort(MyList list, int l, int r, Comparator comp) {
		if (l >= r) {
			return;
		}
		Comparable midEl = (Comparable)list.get((l + r) / 2);
		MyList less = new MyArrayList();
		MyList greater = new MyArrayList();
		MyList equal = new MyArrayList();
		for (int i = l; i <= r; i++) {
			Comparable cur = (Comparable)list.get(i);
			int compRes;
			if (comp == null) {
				compRes = cur.compareTo(midEl);
			} else {
				compRes = comp.compare(cur, midEl);
			}
			if (compRes < 0) {
				less.add(cur);
			} else if (compRes > 0) {
				greater.add(cur);
			} else {
				equal.add(midEl);
			}
		}
		for (int i = 0; i < less.size(); i++) {
			list.set(l + i, less.get(i));
		}
		for (int i = 0; i < equal.size(); i++) {
			list.set(l + less.size() + i, midEl);
		}
		for (int i = 0; i < greater.size(); i++) {
			list.set(l + less.size() + equal.size() + i, greater.get(i));
		}
		qSort(list, l, l + less.size() - 1, comp);
		qSort(list, r - greater.size() + 1, r, comp);
	}

	public static void sort(MyList list) {
		if (list instanceof RandomAccess) {
			qSort(list, 0, list.size() - 1, null);		
		} else {
			bubbleSort(list, null);
		}
	}

	public static void sort(MyList list, Comparator comp) {
		if (list instanceof RandomAccess) {
			qSort(list, 0, list.size() - 1, comp);		
		} else {
			bubbleSort(list, comp);
		}
	}

	public static void swap(MyList list, int i, int j) {
		Object temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	public static void copy(MyList dest, MyList src) {
		while (dest.size() != 0) {
			dest.remove(dest.size() - 1);
		}
		for (int i = 0; i < src.size(); i++) {
			dest.add(src.get(i));
		}
	}

	public static void reverse(MyList list) {
		for (int i = 0; i < list.size() / 2; i++) {
			swap(list, i, list.size() - i - 1);
		}
	}
}