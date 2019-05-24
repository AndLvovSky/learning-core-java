public class MyLinkedList implements MyList, Queue, Stack {
	private Element head;
	private Element tail;
	private int size;

	private Element find(int index) {
		Element cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur;
	}

	public MyLinkedList() {
		head = tail = null;
		size = 0;
	}

	@Override
	public void add(Object e) {
		addLast(e);
	}

	@Override
	public void add(int index, Object element) {
		if (index > size || index < 0) {
			throw new RuntimeException("Index out of range");
		}
		if (index == 0) {
			addFirst(element);
			return;
		} else if (index == size) {
			addLast(element);
			return;
		}
		Element cur = find(index);
		Element newE = new Element(element, cur.prev, cur);
		cur.prev.next = newE;
		cur.prev = newE;
		size++;
	}

	@Override
	public void addAll(Object[] c) {
		if (c == null) {
			throw new RuntimeException("Array is null");
		}
		for (Object o : c) {
			addLast(o);
		}
	}

	@Override
	public void addAll(int index, Object[] c) {
		if (index > size || index < 0) {
			throw new RuntimeException("Index out of range");
		}
		if (c == null) {
			throw new RuntimeException("Array is null");
		}
		if (index == size) {
			addAll(c);
		}
		Element last = find(index);
		Element first = last.prev;
		Element cur = new Element(c[0], first, null);
		if (first != null) {
			first.next = cur;
		}
		for (int i = 1; i < c.length; i++) {
			Element newE = new Element(c[i], cur, null);
			cur.next = newE;
			cur = newE;
		}
		cur.next = last;
		last.prev = cur;
		size += c.length;
	}

	public void addFirst(Object element) {
		Element newE = new Element(element, null, head);
		if (size == 0) {
			head = tail = newE;
		} else {
			head.prev = newE;
			head = newE;
		}
		size++;
	}

	public void addLast(Object element) {
		Element newE = new Element(element, tail, null);
		if (size == 0) {
			head = tail = newE;
		} else {
			tail.next = newE;
			tail = newE;
		}
		size++;
	}

	@Override
	public Object get(int index) {
		if (index == 0) {
			return getFirst();
		} else if (index == size) {
			return getLast();
		}
		if (index > size) {
			throw new RuntimeException("Index out of range");
		}
		return find(index).value;
	}

	public Object getFirst() throws RuntimeException {
		if (size == 0) {
			throw new RuntimeException("List is empty");
		}
		return head.value;
	}

	public Object getLast() {
		if (size == 0) {
			throw new RuntimeException("List is empty");
		}
		return tail.value;
	}

	@Override
	public Object remove(int index) {
		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} 
		if (index > size || index < 0) {
			throw new RuntimeException("Index out of range");
		}
		Element curE = find(index);
		curE.next.prev = curE.prev;
		curE.prev.next = curE.next;
		size--;
		return curE.value;
	}

	public Object removeFirst() {
		if (size == 0) {
			throw new RuntimeException("List is empty");
		}
		Element curE = head;
		head = head.next;
		if (head != null) {
			head.prev = null;
		}
		size--;
		return curE.value;
	}

	public Object removeLast() {
		if (size == 0) {
			throw new RuntimeException("List is empty");
		}
		Element curE = tail;
		tail = tail.prev;
		if (tail != null) {
			tail.next = null;
		}
		size--;
		return curE.value;
	}

	@Override
	public void set(int index, Object element) {
		if (index > size || index < 0) {
			throw new RuntimeException("Index out of range");
		}
		find(index).value = element;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(Object element) {
		Element cur = head;
		int res = 0;
		while (cur != null && !(cur.value.equals(element))) {
			cur = cur.next;
			res++;
		}
		return cur == null ? -1 : res;
	}

	public Iterator iterator() {
		return new Iterator(new Element(0, null, head));
	}

	@Override
	public Object[] toArray() {
		Object[] a = new Object[size];
		int i = 0;
		Iterator it = iterator();
		while (it.hasNext()) {
			a[i++] = it.next();
		}
		return a;
	}

	@Override
	public void offer(Object element) {
		addLast(element);
	}

	@Override
	public Object peek() {
		return getLast();
	}

	@Override
	public Object poll() {
		return removeLast();
	}

	@Override
	public void push(Object element) {
		addLast(element);
	}

	@Override
	public Object pop() {
		return removeLast();
	}
}