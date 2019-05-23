public class MyQueueTest {	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.peek() == 3);
		System.out.println(queue.poll() == 3);
		System.out.println(queue.poll() == 2);
		System.out.println(queue.poll() == 1);
		boolean flag = false;
		try {
			queue.peek();
		} catch(RuntimeException ex) {
			ex.printStackTrace();
			flag = true;
		}
		System.out.println(flag);
	}
}