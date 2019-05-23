public class MyStack {
	private MyLinkedList list = new MyLinkedList();

	public void push(Integer element) {
		list.addLast(element);
	}

	public Integer pop() throws RuntimeException {
		Integer res;
		try {
			res = list.removeLast();
		} catch (RuntimeException ex) {
			throw new RuntimeException("Stack is empty");
		}
		return res;
	}
}