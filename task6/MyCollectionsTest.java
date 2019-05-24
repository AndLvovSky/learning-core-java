public class MyCollectionsTest {
	private static void print(MyLinkedList list) {
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	private static void testSwap() {
		MyLinkedList list = new MyLinkedList();
		list.addLast(4);
		list.addLast(2);
		list.addLast(3);
		MyCollections.swap(list, 0, 2);
		print(list);
	}

	private static void testReverse() {
		MyLinkedList list = new MyLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		MyCollections.reverse(list);
		print(list);
	}

	private static void testCopy() {
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
	}

	private static void testSort() {
		MyLinkedList list = new MyLinkedList();
		list.addLast(5);
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
	}

	public static void main(String[] args) {
		testSwap();
		testReverse();
		testCopy();
		testSort();
	}
}