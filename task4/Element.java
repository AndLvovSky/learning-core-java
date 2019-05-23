public class Element {
	public Element prev;
	public Element next;
	public Integer value;

	public Element(Integer value) {
		this.value = value;
	}

	public Element(Integer value, Element prev, Element next) {
		this(value);
		this.prev = prev;
		this.next = next;
	}
}