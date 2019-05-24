public class Element {
	public Element prev;
	public Element next;
	public Object value;

	public Element(Object value) {
		this.value = value;
	}

	public Element(Object value, Element prev, Element next) {
		this(value);
		this.prev = prev;
		this.next = next;
	}
}