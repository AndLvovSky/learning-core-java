public class MyQueue {
	private MyLinkedList list = new MyLinkedList();

	public void offer(Integer element) {
		list.addLast(element);
	}

	public Integer peek() throws RuntimeException {
		Integer res;
		try {
			res = list.getLast();
		} catch (RuntimeException ex) {
			throw new RuntimeException("Queue is empty");
		}
		return res;
	}

	public Integer poll() throws RuntimeException {
		Integer res;
		try {
			res = list.removeLast();
		} catch (RuntimeException ex) {
			throw new RuntimeException("Queue is empty");
		}
		return res;
	}
}