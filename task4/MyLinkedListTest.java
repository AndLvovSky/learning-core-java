public class MyLinkedListTest {
	private static void print(MyLinkedList list) {
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addLast(1);
		print(list);
		list.addLast(2);
		print(list);
		list.addLast(3);
		print(list);
		list.addLast(4);
		print(list);
		list.addFirst(5);
		print(list);
		list.add(1, 6);
		print(list);
		list.remove(2);
		print(list);
		list.removeFirst();
		print(list);
		list.removeLast();
		print(list);
		list.set(1, 7);
		print(list); 
		System.out.println(list.size() == 3);
		System.out.println(list.get(1) == 7);
		System.out.println(list.getFirst() == 6);
		System.out.println(list.getLast() == 3);
		System.out.println(list.indexOf(7) == 1);
	}
}