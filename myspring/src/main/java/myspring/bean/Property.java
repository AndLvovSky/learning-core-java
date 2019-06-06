package myspring.bean;

public class Property {

	public final String name;

	public final String value;

	public final boolean isRef;

	public Property(String name, String value, boolean isRef) {
		this.name = name;
		this.value = value;
		this.isRef = isRef;
	}

}