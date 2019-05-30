class MergeSortThread<T extends Comparable<T>> extends Thread {

	private T[] a;

	private int l;

	private  int r;

	private int minDiv = 100;

	private static final int SMALL = 1000;

	public MergeSortThread(T[] a, int l, int r) {
		this.a = a;
		this.l = l;
		this.r = r;
	}

	public MergeSortThread(T[] a, int l, int r, int minDiv) {
		this(a, l, r);
		this.minDiv = minDiv;
	}

	public void run() {
		sort(l, r);
	}

	private void smallSort(int l, int r) {
		int d = r - l + 1;
		for (int i = 0; i < d; i++) {
			for (int j = l; j < r; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					T temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void sort(int l, int r) {
		if (l >= r) {
			return;
		} 
		int mid = (l + r) / 2;
		int d = r - l + 1;
		if (d <= SMALL && SMALL < minDiv) {
			smallSort(l, r);
			return;
		} else if (d >= minDiv) {
			Thread t1 = new MergeSortThread<T>(a, l, mid, minDiv);
			Thread t2 = new MergeSortThread<T>(a, mid + 1, r, minDiv);
			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		} else {
			sort(l, mid);
			sort(mid + 1, r);
		}
		T[] temp = (T[])new Comparable[d];
		int pt = 0, pl = l, pr = mid + 1;
		while (pt < d) {
			if (pl > mid || pr <= r && a[pr].compareTo(a[pl]) < 0) {
				temp[pt++] = a[pr++];
			} else {
				temp[pt++] = a[pl++];
			}
		}
		for (int i = 0; i < d; i++) {
			a[i + l] = temp[i];
		}
	}

}

public class MergeSort {

	public static <T extends Comparable<T>> void
		parallelSort(T[] a) {
		Thread t = new MergeSortThread<T>(a, 0, a.length - 1);
		t.start();
		try {
			t.join();
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public static <T extends Comparable<T>> void
		parallelSort(T[] a, int minDiv) {
		Thread t = new MergeSortThread<T>(a, 0, a.length - 1, minDiv);
		t.start();
		try {
			t.join();
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
