public class MyCollections {
	private static void selectionSort(MyLinkedList list) {
		for (int i = 0; i < list.size() - 1; i++) {
			int minPos = minIndex(list, i);
			swap(list, i, minPos);
		}
	}

	private static int minIndex(MyLinkedList l, int startIndex) {
		Iterator it = l.iterator();
		for (int i = 0; i < startIndex; i++) {
			it.next();
		}
		int pos = startIndex, minPos = startIndex;
		Integer min = Integer.MAX_VALUE;
		while (it.hasNext()) {
			Integer cur = it.next();
			if (min > cur) {
				minPos = pos;
				min = cur;
			}
			pos++;
		}
		return minPos;
	}

	private static void qSort(MyArrayList list, int l, int r) {
		if (l >= r) {
			return;
		}
		Integer midEl = (Integer)list.get((l + r) / 2);
		MyArrayList less = new MyArrayList();
		MyArrayList greater = new MyArrayList();
		MyArrayList equal = new MyArrayList();
		for (int i = l; i <= r; i++) {
			Integer cur = (Integer)list.get(i);
			if (cur < midEl) {
				less.add(cur);
			} else if (cur > midEl) {
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
		qSort(list, l, l + less.size() - 1);
		qSort(list, r - greater.size() + 1, r);
	}

	// O(n^2)
	public static void sort(MyLinkedList list) {
		selectionSort(list);
	}

	// *O(nlogn)
	public static void sort(MyArrayList list) {
		qSort(list, 0, list.size() - 1);
	}

	// O(n)
	public static void swap(MyLinkedList list, int i, int j) {
		Integer temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	// O(1)
	public static void swap(MyArrayList list, int i, int j) {
		Integer temp = (Integer)list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	// O(n)
	public static void copy(MyLinkedList dest, MyLinkedList src) {
		while (dest.size() != 0) {
			dest.removeLast();
		}
		Iterator it = src.iterator();
		while (it.hasNext()) {
			dest.addLast(it.next());
		}
	}

	// O(n)
	public static void copy(MyArrayList dest, MyArrayList src) {
		while (dest.size() != 0) {
			dest.remove(dest.size() - 1);
		}
		for (int i = 0; i < src.size(); i++) {
			dest.add(src.get(i));
		}
	}

	// O(n^2)
	public static void reverse(MyLinkedList list) {
		for (int i = 0; i < list.size() / 2; i++) {
			swap(list, i, list.size() - i - 1);
		}
	}

	// O(n)
	public static void reverse(MyArrayList list) {
		for (int i = 0; i < list.size() / 2; i++) {
			swap(list, i, list.size() - i - 1);
		}
	}

	// O(logn)
	public static int binarySearch(MyArrayList list, Integer key) {
		int l = 0, r = list.size() - 1;
		while (l < r) {
			int mid = (l + r + 1) / 2;
			if (key < (Integer)list.get(mid)) {
				r = mid - 1;
			} else {
				l = mid;
			}
		}
		if ((Integer)list.get(l) == key) {
			return l;
		}
		return -l - 1;
	}
}