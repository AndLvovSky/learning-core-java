import java.util.Random;

public class BufferReader implements Runnable {

	private final static int SLEEP_RANGE = 2000;

	private CircularBuffer buffer;

	public BufferReader(CircularBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		Random rand = new Random();
		String threadName = Thread.currentThread().getName();
		while (true) {
			System.out.println(
				"Thread " + threadName + " is polling next number");
			int num = (int)buffer.poll();
			System.out.println(
				"Thread " + threadName + " polled number " + num);
			try {
				Thread.sleep(rand.nextInt(SLEEP_RANGE));
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

}