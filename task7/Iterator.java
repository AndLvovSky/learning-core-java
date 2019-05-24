public class Iterator {
	private Element e;

	public Iterator(Element element) {
		this.e = element;
	}

	public boolean hasNext() {
		return e.next != null;
	}

	public Object next() throws RuntimeException {
		if (e.next == null) {
			throw new RuntimeException("No next element");
		}
		Object res = e.next.value;
		e = e.next;
		return res;
	}

	public void remove() {
		if (e.prev != null) {
			e.prev.next = e.next;
		}
		if (e.next != null) {
			e.next.prev = e.prev;
		}
	}

	public Object getElement() {
		return e.value;
	}

	public void setElement(Object value) {
		this.e.value = e.value;
	}
}