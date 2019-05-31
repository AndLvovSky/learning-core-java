import java.util.Random;

public class BufferWriter implements Runnable {

	private final static int WRITES_COUNT = 5;

	private final static int SLEEP_RANGE = 2000;

	private CircularBuffer buffer;

	public BufferWriter(CircularBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		Random rand = new Random();
		String threadName = Thread.currentThread().getName();
		for (int i = 0; i < WRITES_COUNT; i++) {
			int num = rand.nextInt(20);
			System.out.println(
				"Thread " + threadName + " is offering " + num);
			buffer.offer(new Integer(num));
			System.out.println(
				"Thread's " + threadName + 
				" offer of " + num + " is completed");
			try {
				Thread.sleep(rand.nextInt(SLEEP_RANGE));
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

}