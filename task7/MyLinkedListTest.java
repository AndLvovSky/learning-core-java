public class MyLinkedListTest {
	private static void print(MyLinkedList list) {
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next().toString() + " ");
		}
		System.out.println();
	}

	private static void listInterfaceTest() {
		System.out.println("list interface test");
		MyList list = new MyLinkedList();
		list.add(1);
		list.addAll(new Integer[]{2, 3});
		print((MyLinkedList)list);
		list.addAll(1, new Integer[]{4, 5});
		print((MyLinkedList)list);
		Object[] arr = list.toArray();
		for (Object el : arr) {
			System.out.print((Integer)el + " ");
		}
		System.out.println();
	}

	private static void queueInterfaceTest() {
		System.out.println("queue interface test");
		Queue queue = new MyLinkedList();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println((Integer)queue.peek() == 3);
		System.out.println((Integer)queue.poll() == 3);
		System.out.println((Integer)queue.poll() == 2);
		System.out.println((Integer)queue.poll() == 1);
		boolean flag = false;
		try {
			queue.peek();
		} catch(RuntimeException ex) {
			ex.printStackTrace();
			flag = true;
		}
		System.out.println(flag);
	}

	private static void stackIntefaceTest() {
		System.out.println("stack interface test");
		Stack stack = new MyLinkedList();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println((Integer)stack.pop() == 3);
		System.out.println((Integer)stack.pop() == 2);
		System.out.println((Integer)stack.pop() == 1);
		Object res = null;
		try {
			res = stack.pop();
		} catch(RuntimeException ex) {
			ex.printStackTrace();
		}
		System.out.println(res == null);
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
		System.out.println((Integer)list.size() == 3);
		System.out.println((Integer)list.get(1) == 7);
		System.out.println((Integer)list.getFirst() == 6);
		System.out.println((Integer)list.getLast() == 3);
		System.out.println((Integer)list.indexOf(7) == 1);

		listInterfaceTest();
		queueInterfaceTest();
		stackIntefaceTest();
	}
}