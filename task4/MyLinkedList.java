public class MyLinkedList {
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

	public void add(Integer e) {
		addLast(e);
	}

	public void add(int index, Integer element) throws RuntimeException {
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

	public void addFirst(Integer element) {
		Element newE = new Element(element, null, head);
		if (size == 0) {
			head = tail = newE;
		} else {
			head.prev = newE;
			head = newE;
		}
		size++;
	}

	public void addLast(Integer element) {
		Element newE = new Element(element, tail, null);
		if (size == 0) {
			head = tail = newE;
		} else {
			tail.next = newE;
			tail = newE;
		}
		size++;
	}

	public Integer get(int index) throws RuntimeException {
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

	public Integer getFirst() throws RuntimeException {
		if (size == 0) {
			throw new RuntimeException("List is empty");
		}
		return head.value;
	}

	public Integer getLast() throws RuntimeException {
		if (size == 0) {
			throw new RuntimeException("List is empty");
		}
		return tail.value;
	}

	public Integer remove(int index) throws RuntimeException {
		if (index == 0) {
			return removeFirst();
		} else if (index == size) {
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

	public Integer removeFirst() throws RuntimeException {
		if (size == 0) {
			throw new RuntimeException("List is empty");
		}
		Element curE = head;
		head = head.next;
		size--;
		return curE.value;
	}

	public Integer removeLast() throws RuntimeException {
		if (size == 0) {
			throw new RuntimeException("List is empty");
		}
		Element curE = tail;
		tail = tail.prev;
		size--;
		return curE.value;
	}

	public void set(int index, Integer element) throws RuntimeException {
		if (index > size || index < 0) {
			throw new RuntimeException("Index out of range");
		}
		find(index).value = element;
	}

	public int size() {
		return size;
	}

	public int indexOf(Integer element) {
		Element cur = head;
		int res = 0;
		while (cur != null && cur.value != element) {
			cur = cur.next;
			res++;
		}
		return cur == null ? -1 : res;
	}

	public Iterator iterator() {
		return new Iterator(new Element(0, null, head));
	}
}