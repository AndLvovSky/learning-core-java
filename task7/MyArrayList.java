public class MyArrayList implements MyList, RandomAccess {
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

	@Override
	public void add(Object element) {
		ensureCapacity(size + 1);
		elements[size++] = element;
	}

	@Override
	public void add(int index, Object element) {
		ensureCapacity(Math.max(index, size) + 1);
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}

	@Override
	public void addAll(Object[] c) {
		ensureCapacity(size + c.length);
		for (int i = size; i < size + c.length; i++) {
			elements[i] = c[i - size];
		}
		size += c.length;
	}

	@Override
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

	@Override
	public Object get(int index) {
		if (index >= size || index < 0) {
			throw  new RuntimeException("Index out of range");
		}
		return elements[index];
	}

	@Override
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

	@Override
	public void set(int index, Object element) {
		ensureCapacity(index + 1);
		size = Math.max(size, index + 1);
		elements[index] = element;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(Object o) {
		if (o == null) {
			throw new RuntimeException("Object is null");
		}
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Object[] toArray() {
		return java.util.Arrays.copyOfRange(elements, 0, size);
	}
}
