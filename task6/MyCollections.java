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
		System.out.println(startIndex + " " + min);
		return minPos;
	}

	// O(n^2)
	public static void sort(MyLinkedList list) {
		selectionSort(list);
	}

	// O(n)
	public static void swap(MyLinkedList list, int i, int j) {
		Integer temp = list.get(i);
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
	public static void reverse(MyLinkedList list) {
		for (int i = 0; i < list.size() / 2; i++) {
			swap(list, i, list.size() - i - 1);
		}
	}
}