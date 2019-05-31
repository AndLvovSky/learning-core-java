public class CircularBuffer {

	private int capacity;

	private int size = 0;

	private Object[] el;

	private int head = 0;

	private int tail = 0;

	public CircularBuffer(int capacity) {
		this.capacity = capacity;
		el = new Object[capacity]; 
	}

	public synchronized void offer(Object o) {
		while (isFull()) {
			try {
				wait();
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		simpleOffer(o);
		notify();
	}

	public synchronized Object poll() {
		while (isEmpty()) {
			try {
				wait();
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		Object o = simplePoll();
		notify();
		return o;
	}

	private void simpleOffer(Object o) {
		el[tail] = o;
		tail = (tail + 1) % capacity;
		size++;
	}

	private Object simplePoll() {
		Object res = el[head];
		head = (head + 1) % capacity;
		size--;
		return res;
	}

	public synchronized boolean isFull() {
		return head == tail && size != 0;
	}

	public synchronized boolean isEmpty() {
		return head == tail && size == 0;
	}

}