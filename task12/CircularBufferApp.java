public class CircularBufferApp {

	public static void main(String[] args) {
		int n = 3;
		if (args.length == 1) {
			n = Integer.parseInt(args[0]); 
		}
		CircularBuffer buffer = new CircularBuffer(n);
		int readers = 2, writers = 2;
		for (int i = 0; i < writers; i++) {
			new Thread(new BufferWriter(buffer), "WT" + i).start();
		}
		try {
			Thread.sleep(4000);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		for (int i = 0; i < readers; i++) {
			new Thread(new BufferReader(buffer), "RT" + i).start();
		}
	}

}