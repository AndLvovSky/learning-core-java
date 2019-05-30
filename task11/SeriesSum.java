class SeriesThread extends Thread {

	private float sum = 0;

	private int from;

	private int to;

	public SeriesThread(int from, int to) {
		this.from = from;
		this.to = to;
	}

	public void run() {
		for (int i = from; i <= to; i++) {
			sum += Math.sin(i);
		}
	}

	public float getSum() {
		return sum;
	}

}

public class SeriesSum {

	private static final float E = 0.0001f;

	public static float sumSeries(int threadCount, int n) {
		SeriesThread[] t = new SeriesThread[n];
		int step = 2 * n / threadCount;
		int from, to;
		for (int i = 0; i < threadCount - 1; i++) {
			from = i * step - n;
			to = (i + 1) * step - n - 1;
			t[i] = new SeriesThread(from, to);
			t[i].start();
		}
		from = (threadCount - 1) * step - n;
		to = n;
		t[threadCount - 1] = new SeriesThread(from, to);
		t[threadCount - 1].start();
		float res = 0;
		for (int i = 0; i < threadCount; i++) {
			try {
				t[i].join();	
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			res += t[i].getSum();
		}
		return res;
	}

	public static void main(String[] args) {
		float ans = sumSeries(4, 100000);
		System.out.println(Math.abs(ans) < E);
		ans = sumSeries(6, 657421);
		System.out.println(Math.abs(ans) < E);
	}

}
