public class MyArrayList {
	private Object[] elements;
	private int size;
	private int capacity;

	public MyArrayList() {
		size = 0;
		capacity = 10;
		elements = new Object[capacity];
	}

	public MyArrayList(int initialCapacity) {
		size = 0;
		capacity = initialCapacity;
		elements = new Object[capacity];
	}

	public void add(Object element) {
		ensureCapacity(size + 1);
		elements[size++] = element;
	}

	public void add(int index, Object element) {
		ensureCapacity(Math.max(index, size) + 1);
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}

	public void addAll(Object[] c) {
		ensureCapacity(size + c.length);
		for (int i = size; i < size + c.length; i++) {
			elements[i] = c[i - size];
		}
		size += c.length;
	}

	public void addAll(int index, Object[] c) {
		ensureCapacity(size + c.length);
		for (int i = size - 1; i >= index; i--) {
			elements[i + c.length] = elements[i];
		}
		for (int i = index; i < index + c.length; i++) {
			elements[i] = c[i - index];
		}
		size += c.length;
	} 

	private void ensureCapacity(int minCapacity) {
		if (capacity >= minCapacity) {
			return;
		}
		while (capacity < minCapacity) {
			capacity *= 2;
		}
		Object[] temp = new Object[size];
		for (int i = 0; i < size; i++) {
			temp[i] = elements[i];
		}
		elements = new Object[capacity];
		for (int i = 0; i < size; i++) {
			elements[i] = temp[i];
		}
	}

	public Object get(int index) {
		if (index >= size || index < 0) {
			throw  new RuntimeException("Index out of range");
		}
		return elements[index];
	}

	public Object remove(int index) {
		if (index >= size || index < 0) {
			throw new RuntimeException("Index out of range");
		}
		Object res = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
		return res;
	}

	public void set(int index, Object element) {
		ensureCapacity(index + 1);
		size = Math.max(size, index + 1);
		elements[index] = element;
	}

	public int size() {
		return size;
	}
}