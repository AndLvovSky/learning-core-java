public class MyCollectionsTest {
	private static void print(MyLinkedList list) {
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	private static void print(MyArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

	private static void testSwap() {
		System.out.println("swap test");

		MyLinkedList list = new MyLinkedList();
		list.addLast(4);
		list.addLast(2);
		list.addLast(3);
		MyCollections.swap(list, 0, 2);
		print(list);

		MyArrayList alist = new MyArrayList();
		alist.add(4);
		alist.add(2);
		alist.add(3);
		MyCollections.swap(alist, 0, 2);
		print(alist);
	}

	private static void testReverse() {
		System.out.println("reverse test");

		MyLinkedList list = new MyLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		MyCollections.reverse(list);
		print(list);

		MyArrayList alist = new MyArrayList();
		alist.add(1);
		alist.add(2);
		alist.add(3);
		alist.add(4);
		MyCollections.reverse(alist);
		print(alist);
	}

	private static void testCopy() {
		System.out.println("copy test");

		MyLinkedList list1 = new MyLinkedList();
		list1.addLast(1);
		list1.addLast(2);
		MyLinkedList list2 = new MyLinkedList();
		list2.addLast(3);
		list2.addLast(4);
		list2.addLast(5);
		MyCollections.copy(list1, list2);
		print(list1);
		print(list2);

		MyArrayList alist1 = new MyArrayList();
		alist1.add(1);
		alist1.add(2);
		MyArrayList alist2 = new MyArrayList();
		alist2.add(3);
		alist2.add(4);
		alist2.add(5);
		MyCollections.copy(alist1, alist2);
		print(alist1);
		print(alist2);
	}

	private static void testSort() {
		System.out.println("sort test");

		MyLinkedList list = new MyLinkedList();
		list.add(5);
		list.add(1);
		list.add(-3);
		list.add(0);
		list.add(6);
		list.add(1);
		list.add(2);
		System.out.print("not sorted: ");
		print(list);
		MyCollections.sort(list);
		System.out.print("sorted: ");
		print(list);

		MyArrayList alist = new MyArrayList();
		alist.add(5);
		alist.add(1);
		alist.add(-3);
		alist.add(0);
		alist.add(6);
		alist.add(1);
		alist.add(2);
		System.out.print("not sorted: ");
		print(alist);
		MyCollections.sort(alist);
		System.out.print("sorted: ");
		print(alist);
	}

	private static void testBinarySearch() {
		System.out.println("test binary search");
		MyArrayList list = new MyArrayList();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(6);
		list.add(8);
		list.add(10);
		list.add(15);
		list.add(20);
		print(list);
		System.out.println("position of 4 " + 
			MyCollections.binarySearch(list, 4));
		System.out.println("position of 11 " + 
			MyCollections.binarySearch(list, 11));
	}

	public static void main(String[] args) {
		testSwap();
		testReverse();
		testCopy();
		testSort();
		testBinarySearch();
	}
}